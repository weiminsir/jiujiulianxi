package weiminsir.jiujiulianxi.jiujie.jiujiu;
/**
 * Created by ken on 18/7/15.
 */
public class NChoice extends NObject {
    //    这块给出一个方图question_picture_min 640x640，一个全图question_picture 750x1334，一个横图question_picture_hor 1280x640
    final static public int AChoiceSeq = 1;
    final static public int BChoiceSeq = 2;
    final static public int CChoiceSeq = 3;
    final static public int DChoiceSeq = 4;
    final public int question_kink_id;
    final public String question_answer_num_percentage;
    final public String question_picture_hor;
    final public int question_answer_num;
    final public String question_title;
    final public String question_picture;
    final public String question_picture_min;
    final public int question_sequence;
    final public int question_id;
    NChoice() {
        question_kink_id = DEFAULT_ID_VALUE;
        question_answer_num_percentage = "";
        question_picture_hor = "";
        question_answer_num = 0;
        question_title = "";
        question_picture = "";
        question_picture_min = "";
        question_sequence = 0;
        question_id = DEFAULT_ID_VALUE;
    }
    public String getChoiceName() {
        if (question_sequence == AChoiceSeq) {
            return "a";
        } else if (question_sequence == BChoiceSeq) {
            return "b";
        } else if (question_sequence == CChoiceSeq) {
            return "c";
        } else if (question_sequence == DChoiceSeq) {
            return "d";
        }
        return "";
     }
    public static String getChoiceName(int seq) {
        if (seq == AChoiceSeq) {
            return "a";
        } else if (seq == BChoiceSeq) {
            return "b";
        } else if (seq == CChoiceSeq) {
            return "c";
        } else if (seq == DChoiceSeq) {
            return "d";
        }
        return "";
    }
    public String getQuestionTitle() {
        return question_title == null ? "" : question_title;
    }
}