package weiminsir.jiujiulianxi.youlu.view;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Sms;

/**
 * Created by Weimin on 2016/3/15.
 */
public interface ISmsView  {

    void setList(List<Sms> conversations);

    void showList();
}
