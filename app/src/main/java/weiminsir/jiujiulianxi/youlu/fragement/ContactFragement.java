package weiminsir.jiujiulianxi.youlu.fragement;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.adapter.ContactAdapter;
import weiminsir.jiujiulianxi.youlu.entity.Contact;
import weiminsir.jiujiulianxi.youlu.presenter.ContactPresenter;
import weiminsir.jiujiulianxi.youlu.presenter.IContactPresenter;
import weiminsir.jiujiulianxi.youlu.view.IContactView;
/**
 * Created by Weimin on 2016/3/14.
 */
public class ContactFragement extends BaseFragement implements IContactView {

    public static final String MY_LOG = "WICK";
    protected IContactPresenter presenter;

//    @InjectView(R.id.gvContact)
    protected GridView gridView;

    private List<Contact> contacts;
    public ContactFragement() {
        presenter = new ContactPresenter(this);
    }
    @Override
    public int getResourceId() {
        return R.layout.fragment_contact;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = (GridView) mRootView.findViewById(R.id.gvContact);

        presenter.loadAllContacts();

        Log.i(MY_LOG, "加载所有联系人");
        ContactAdapter adapter = new ContactAdapter(mActivity,contacts);
        gridView.setAdapter(adapter);
        setListener();
    }

    public void setListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "详情页面", Toast.LENGTH_LONG);            }
        });
    }
    @Override
    public void showContactList(List<Contact> contacts) {
        this.contacts = contacts;

    }
}
