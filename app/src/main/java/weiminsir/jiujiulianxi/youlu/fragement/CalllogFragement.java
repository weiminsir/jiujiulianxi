package weiminsir.jiujiulianxi.youlu.fragement;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.adapter.CalllogAdapter;
import weiminsir.jiujiulianxi.youlu.entity.Calllog;
import weiminsir.jiujiulianxi.youlu.presenter.CalllogPresenter;
import weiminsir.jiujiulianxi.youlu.presenter.ICalllogPresenter;
import weiminsir.jiujiulianxi.youlu.view.ICalllogView;

/**
 * Created by Weimin on 2016/3/14.
 */
public class CalllogFragement extends BaseFragement implements ICalllogView {

    protected ListView listView;
    private List<Calllog> logs;
    private CalllogAdapter adapter;
    private ICalllogPresenter presenter;


    public CalllogFragement() {
        presenter = new CalllogPresenter(this);
    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_calllog;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) mRootView.findViewById(R.id.lvCalllog);
        presenter.loadAllCalllogs();
        adapter = new CalllogAdapter(mActivity);
        listView.setAdapter(adapter);
    }

    @Override
    public void setCalllogList(List<Calllog> logs) {
        this.logs = logs;
    }

    @Override
    public void showList() {

    }
}
