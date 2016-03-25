package weiminsir.jiujiulianxi.youlu.presenter;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Calllog;
import weiminsir.jiujiulianxi.youlu.module.CalllogModel;
import weiminsir.jiujiulianxi.youlu.module.ICalllogModel;
import weiminsir.jiujiulianxi.youlu.view.ICalllogView;

/**
 * Created by Weimin on 2016/3/14.
 */
public class CalllogPresenter implements ICalllogPresenter {
    private ICalllogView view;
    private ICalllogModel model;

    public CalllogPresenter(ICalllogView view) {
        this.view = view;
        this.model = new CalllogModel();
    }
    @Override
    public void loadAllCalllogs() {
        List<Calllog> logs = model.findAllCallogs();
        view.setCalllogList(logs);
        view.showList();
    }
}
