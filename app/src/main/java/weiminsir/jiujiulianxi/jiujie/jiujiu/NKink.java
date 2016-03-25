package weiminsir.jiujiulianxi.jiujie.jiujiu;

import java.util.List;

/**
 * Created by Weimin on 2015/11/18.
 */
public class NKink extends NObject {
    final public int kink_id;
    public String kink_content;
    public int kink_answer_num;
    public int kink_comment_num;
    public int kink_share_num;
    public Boolean kink_owner;
    final public long kink_ctime;
    final public List<NChoice> kink_questions;
    NKink() {
        kink_id = 0;
        kink_content = "";
        kink_answer_num = 0;
        kink_comment_num = 0;
        kink_share_num = 0;
        kink_ctime = 0;
        kink_questions=null;
        kink_owner=false;
    }
}
