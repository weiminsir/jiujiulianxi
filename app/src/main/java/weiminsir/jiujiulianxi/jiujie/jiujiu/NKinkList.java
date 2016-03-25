package weiminsir.jiujiulianxi.jiujie.jiujiu;
import java.util.List;

/**
 * Created by Weimin on 2015/11/18.
 */

public class NKinkList extends NObject{
    final public int count;
    final public String next;
    final public String previous;
    final public List<NKink> results;
    NKinkList() {
        count = 0;
        next = "";
        previous = "";
        results = null;
    }


}
