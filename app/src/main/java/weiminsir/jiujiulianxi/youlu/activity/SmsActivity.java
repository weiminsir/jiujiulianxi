package weiminsir.jiujiulianxi.youlu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.adapter.SmsAdapter;
import weiminsir.jiujiulianxi.youlu.entity.Conversation;
import weiminsir.jiujiulianxi.youlu.entity.Sms;
import weiminsir.jiujiulianxi.youlu.presenter.ISmsPresenter;
import weiminsir.jiujiulianxi.youlu.presenter.SmsPresenter;
import weiminsir.jiujiulianxi.youlu.view.ISmsView;

public class SmsActivity extends Activity implements ISmsView {

    @InjectView(R.id.listView)
    protected ListView listView;
    private ISmsPresenter presenter;
    private List<Sms> smsList;
    public SmsActivity() {
        presenter = new SmsPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Conversation con = (Conversation) getIntent().getSerializableExtra("conversation");
        int threadId = con.getId();
        presenter.loadSmsByThreadId(threadId);

    }

    @Override
    public void setList(List<Sms> smsList) {
        this.smsList = smsList;
    }

    @Override
    public void showList() {
        Log.i("info", "短信数据：" + smsList.toString());
        //自定义Adapter  呈现界面
        SmsAdapter adapter = new SmsAdapter(this, smsList);
        listView.setAdapter(adapter);
    }
}
