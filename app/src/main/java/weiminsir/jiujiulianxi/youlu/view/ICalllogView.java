package weiminsir.jiujiulianxi.youlu.view;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Calllog;

/**
 * Created by Weimin on 2016/3/14.
 */
public interface ICalllogView  {
    /**
     * 设置数据集合
     */
    void setCalllogList(List<Calllog> logs);
    /**
     * 显示listview
     */
    void showList();

}
