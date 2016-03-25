package weiminsir.jiujiulianxi.youlu.fragement;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.adapter.CalllogAdapter;
import weiminsir.jiujiulianxi.youlu.entity.Calllog;
import weiminsir.jiujiulianxi.youlu.presenter.IDialPresenter;
import weiminsir.jiujiulianxi.youlu.util.StringUtil;
import weiminsir.jiujiulianxi.youlu.view.IDialView;

public class DialFragment extends BaseFragement implements IDialView {

    @InjectView(R.id.lvCalllog)
    protected ListView listView;
    @InjectView(R.id.rlKeyboard)
    protected RelativeLayout rlKeyboard;
    @InjectView(R.id.gvKeyboard)
    protected GridView gvKeyboard;
    @InjectView(R.id.tvTitle)
    protected TextView tvTitle;

    private List<Calllog> logs;
    private IDialPresenter presenter;
    private CalllogAdapter adapter;

    private String[] keys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
    private KeyBoardAdapter keyBoardAdapter;

    @Override
    public int getResourceId() {
        return R.layout.fragment_dial;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //给gridView设置适配器
        setAdapter();
        setListener();
        presenter.loadAllCalllogs();

    }

    public void setListener() {
        gvKeyboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String key = keys[position];
                String text = tvTitle.getText().toString();
                text = StringUtil.atob(text) + key;
                String valule = StringUtil.btoa(text);
                tvTitle.setText(valule);
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                    if (rlKeyboard.getVisibility() == View.VISIBLE) {
                        TranslateAnimation anim = new TranslateAnimation(0, 0, 0, rlKeyboard.getHeight());
                        anim.setDuration(300);
                        rlKeyboard.startAnimation(anim);
                        rlKeyboard.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
        tvTitle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (rlKeyboard.getVisibility() == View.INVISIBLE) {
                    rlKeyboard.setVisibility(View.VISIBLE);
                    TranslateAnimation anim = new TranslateAnimation(0, 0, rlKeyboard.getHeight(), 0);
                    anim.setDuration(500);
                    rlKeyboard.startAnimation(anim);
                }
                return false;
            }
        });

    }

    public void setAdapter() {
        keyBoardAdapter = new KeyBoardAdapter();
        gvKeyboard.setAdapter(adapter);

    }

    @Override
    public void setCalllogList(List<Calllog> logs) {
        this.logs = logs;

    }

    @Override
    public void showList() {
        adapter = new CalllogAdapter(mContext);
        listView.setAdapter(adapter);

    }

    class KeyBoardAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return keys.length;
        }

        @Override
        public Object getItem(int i) {
            return keys[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = View.inflate(getActivity(), R.layout.item_gv_keyboard, null);
            TextView tvKey = (TextView) view.findViewById(R.id.tvKey);
            tvKey.setText(keys[position]);
            return view;
        }
    }

}
