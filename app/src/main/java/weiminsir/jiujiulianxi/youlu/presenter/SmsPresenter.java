package weiminsir.jiujiulianxi.youlu.presenter;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Sms;
import weiminsir.jiujiulianxi.youlu.module.ISmsModel;
import weiminsir.jiujiulianxi.youlu.module.SmsModel;
import weiminsir.jiujiulianxi.youlu.view.ISmsView;

/**
 * Created by Weimin on 2016/3/15.
 */
public class SmsPresenter implements ISmsPresenter {

    private ISmsModel model;
    private ISmsView view;

    public SmsPresenter(ISmsView view) {
        model = new SmsModel();
        this.view = view;

    }

    @Override
    public void loadSmsByThreadId(int id) {

        List<Sms> smsList = model.findSmsByThreadId(id);
        view.setList(smsList);
        view.showList();
    }
}
