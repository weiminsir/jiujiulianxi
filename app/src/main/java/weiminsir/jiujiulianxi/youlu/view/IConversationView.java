package weiminsir.jiujiulianxi.youlu.view;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Conversation;

/**
 * Created by Weimin on 2016/3/15.
 */
public interface IConversationView
{
   void  setList(List<Conversation> conversations);

    void showList();
}
