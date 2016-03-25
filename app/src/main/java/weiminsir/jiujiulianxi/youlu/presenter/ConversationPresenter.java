package weiminsir.jiujiulianxi.youlu.presenter;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Conversation;
import weiminsir.jiujiulianxi.youlu.module.ISmsModel;
import weiminsir.jiujiulianxi.youlu.module.SmsModel;
import weiminsir.jiujiulianxi.youlu.view.IConversationView;

/**
 * Created by Weimin on 2016/3/15.
 */
public class ConversationPresenter implements IConversationPresenter {

    private ISmsModel model;
    private IConversationView view;
    public ConversationPresenter(IConversationView view) {
        model = new SmsModel();
        this.view = view;
    }



    @Override
    public void loadConversation() {
        List<Conversation> conversations = model.loadAllConversations();
        view.setList(conversations);
        view.showList();
    }
}
