package weiminsir.jiujiulianxi.youlu.presenter;

/**
 * Created by Weimin on 2016/3/15.
 */
public interface ISmsPresenter {
    /**
     * 通过threadId 查找所有短消息
     */
    void loadSmsByThreadId(int id);

}
