package weiminsir.jiujiulianxi.jiujie.music2.dal;

/**
 * Created by Weimin on 2016/3/11.
 */
import java.util.List;
/**
 * 数据访问接口  访问的数据类型
 *
 * */
public interface IDao <T>{
    List<T> getData();
}
