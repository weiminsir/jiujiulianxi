package weiminsir.jiujiulianxi.jiujie.music2.dal;


import weiminsir.jiujiulianxi.jiujie.music2.entity.Music;

/**
 * Created by Weimin on 2016/3/11.
 */
public class MusicDaoFactory {

    public static IDao<Music> newInstance() {
        
        return (IDao)new MusicDao();
    }

}
