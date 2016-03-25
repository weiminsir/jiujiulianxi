package weiminsir.jiujiulianxi.youlu.presenter;

import android.util.Log;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Contact;
import weiminsir.jiujiulianxi.youlu.module.ContactModel;
import weiminsir.jiujiulianxi.youlu.module.IContactModel;
import weiminsir.jiujiulianxi.youlu.view.IContactView;

/**
 * Created by Weimin on 2016/3/14.
 */
public class ContactPresenter implements IContactPresenter {

    private IContactModel model;
    private IContactView view;

    public ContactPresenter(IContactView view) {
        model = new ContactModel();//加载数据库联系人
        this.view = view;
        Log.i("WICK", "加载数据库联系人");

    }

    @Override
    public void loadAllContacts() {
        //调用业务层 查询联系人列表
        model.loadContact(new IContactModel.Callback() {
            @Override
            public void OnResponse(List<Contact> contact) {
                view.showContactList(contact);
            }
        });

    }
}
