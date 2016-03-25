package weiminsir.jiujiulianxi.youlu.module;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Conversation;
import weiminsir.jiujiulianxi.youlu.entity.Sms;

/**
 * Created by Weimin on 2016/3/15.
 */
public interface ISmsModel {
    /**
     * 加载所有会话数据
     */

    List<Conversation> loadAllConversations();

    List<Sms> findSmsByThreadId(int threadId);


}
