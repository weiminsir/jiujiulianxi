package weiminsir.jiujiulianxi.jiujie.words;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class WordsActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.tv_title)
    protected TextView tvTitle;
    @InjectView(R.id.et_en)
    protected EditText etEn;
    @InjectView(R.id.et_zh)
    protected EditText etZh;
    @InjectView(R.id.btn_submit)
    protected Button btnSubmit;
    @InjectView(R.id.btn_back)
    protected Button btnBack;
    @InjectView(R.id.lv_words)
    protected ListView lvWords;
    protected WordAdapter adapter;
    protected List<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        WordDao dao = new WordDao(this);
        words = dao.query(null, null, "_id desc");
        adapter = new WordAdapter(this,words);
        lvWords.setAdapter(adapter);
        btnSubmit.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        registerForContextMenu(lvWords);
    }

    public static final int ACTION_EDIT = 100;
    public static final int ACTION_DELETE = 101;


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                menuInfo;
        int position = info.position;
        menu.add(Menu.NONE, ACTION_EDIT, Menu.NONE, "编辑" + words.get(position).getEn());
        menu.add(Menu.NONE, ACTION_EDIT, Menu.NONE, "编辑" + words.get(position).getEn());
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private boolean isEditMode;
    private long editId;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ContextMenu.ContextMenuInfo menuInfo = item.getMenuInfo();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int position = info.position;
        WordDao dao = new WordDao(this);
        switch (item.getItemId()) {
            case ACTION_EDIT:
                isEditMode = true;
                Word word = words.get(position);
                editId = word.getId();
                etEn.setText(word.getEn());
                etZh.setText(word.getZh());
                btnSubmit.setText(word.getEn());
                btnBack.setText(word.getZh());
                btnBack.setVisibility(View.VISIBLE);
                tvTitle.setText("编辑" + word.getEn() + "的信息");
                break;
            case ACTION_DELETE:
                int affectedRows = dao.delete(words.get(position).getId());
                if (affectedRows > 0) {
                    words.clear();
                    words.addAll(dao.query(null, null, "_id desc"));
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(WordsActivity.this, "删除失败，再次尝试", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                isEditMode = false;
                tvTitle.setText("请输入单词信息：");
                etEn.setText("");
                etZh.setText("");
                btnSubmit.setText("添加");
                btnBack.setVisibility(View.GONE);
                break;
            case R.id.btn_submit:
                // 1. 获取EditText中的数据
                String en = etEn.getText().toString().trim();
                String zh = etZh.getText().toString().trim();
                // 2. 验证数据的有效性
                //（忽略）
                // 3. 将数据封装为Word对象
                Word word = new Word();
                word.setEn(en);
                word.setZh(zh);
                // 4. 获取WordDao对象
                WordDao dao = new WordDao(this);
                // 5. 判断操作模式
                if(isEditMode) {
                    // 向Word对象中封装数据的ID
                    word.setId(editId);
                    // 修改数据，并获取接收
                    int affectedRows = dao.update(word);
                    // 取消编辑模式
                    isEditMode = false;
                    tvTitle.setText("请输入单词信息：");
                    etEn.setText("");
                    etZh.setText("");
                    btnSubmit.setText("添加");
                    btnBack.setVisibility(View.GONE);
                    // 提示操作结果
                    if(affectedRows > 0) {
                        words.clear();
                        words.addAll(dao.query(null, null, "_id desc"));
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(this, "删除失败！请联系管理员！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // 添加数据，并获取结果
                    long id = dao.insert(word);
                    // 提示操作结果
                    if(id == -1) {
                        Toast.makeText(this, "添加数据失败！", Toast.LENGTH_SHORT).show();
                    } else {
                        // Toast.makeText(this, "添加数据成功！", Toast.LENGTH_SHORT).show();
                        etEn.setText("");
                        etZh.setText("");
                        // 更新ListView
                        words.clear();
                        words.addAll(dao.query(null, null, "_id desc"));
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
}
