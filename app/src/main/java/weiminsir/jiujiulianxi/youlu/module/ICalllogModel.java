package weiminsir.jiujiulianxi.youlu.module;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Calllog;

/**
 * Created by Weimin on 2016/3/14.
 */
public interface ICalllogModel {
    /**
     * 查询所有通话记录
     */

    List<Calllog> findAllCallogs();

}
