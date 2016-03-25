package weiminsir.jiujiulianxi.youlu.module;

import java.util.List;
import weiminsir.jiujiulianxi.youlu.entity.Contact;
/**
 * Created by Weimin on 2016/3/14.
 */
public interface IContactModel {
    /**
     * 查询联系人数据库 获取所有联系人
     * 并封装成List<Contact></>
     * 执行回调方法
     */
    void loadContact(Callback callback);

    public static interface Callback {
        void OnResponse(List<Contact> contact);
    }


}
