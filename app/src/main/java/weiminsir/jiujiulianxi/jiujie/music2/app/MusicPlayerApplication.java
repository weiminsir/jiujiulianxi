package weiminsir.jiujiulianxi.jiujie.music2.app;

import android.app.Application;

import java.util.List;

import weiminsir.jiujiulianxi.jiujie.music2.dal.IDao;
import weiminsir.jiujiulianxi.jiujie.music2.dal.MusicDaoFactory;
import weiminsir.jiujiulianxi.jiujie.music2.entity.Music;

/**
 * Created by Weimin on 2016/3/11.
 */
public class MusicPlayerApplication extends Application {

    private List<Music> musicList;

    @Override
    public void onCreate() {
       super.onCreate();
        IDao<Music> dao = MusicDaoFactory.newInstance();
        musicList = dao.getData();
    }

    public List<Music> getMusicList() {
        return musicList;
    }

}
