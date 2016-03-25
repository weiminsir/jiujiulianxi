package weiminsir.jiujiulianxi.jiujie.words;

import java.util.List;

/**
 * Created by Weimin on 2016/3/12.
 */
public interface IDao<T> {

    long insert(T t);

    int delete(long id);

    int update(T t);

    List<T> query(String whereClause, String[] whereArgs, String orderBy);


}
