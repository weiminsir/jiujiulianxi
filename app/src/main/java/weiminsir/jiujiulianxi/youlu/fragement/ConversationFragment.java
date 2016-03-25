package weiminsir.jiujiulianxi.youlu.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.activity.SmsActivity;
import weiminsir.jiujiulianxi.youlu.entity.Conversation;
import weiminsir.jiujiulianxi.youlu.presenter.ConversationPresenter;
import weiminsir.jiujiulianxi.youlu.presenter.IConversationPresenter;
import weiminsir.jiujiulianxi.youlu.view.IConversationView;

/**
 * Created by Weimin on 2016/3/15.
 */
public class ConversationFragment extends BaseFragement implements IConversationView {
    @InjectView(R.id.listView)
    protected ListView listView;
    private List<Conversation> conversations;
    private IConversationPresenter presenter;
    private ArrayAdapter <Conversation>adapter;

    public ConversationFragment() {
        presenter = new ConversationPresenter(this);

    }

    @Override
    public int getResourceId() {
        return R.layout.fragment_conversation;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.loadConversation();
        setListener();
    }
    public void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Conversation con = conversations.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("conversation",con);
                Intent intent = new Intent(mContext, SmsActivity.class);
                intent.putExtra("conversation", bundle);
            }
        });
    }

    @Override
    public void setList(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    @Override
    public void showList() {
        adapter = new ArrayAdapter<Conversation>(mContext, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
    }
}
