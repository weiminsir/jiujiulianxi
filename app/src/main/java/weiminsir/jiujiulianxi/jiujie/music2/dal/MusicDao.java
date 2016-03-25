package weiminsir.jiujiulianxi.jiujie.music2.dal;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import weiminsir.jiujiulianxi.jiujie.music.Music;
/**
 * Created by Weimin on 2016/3/11.
 */
public class MusicDao implements IDao<Music> {
    @Override
    public List<Music> getData() {
        List<Music> musicList = new ArrayList<>();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            File musicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
            if (musicDir.exists()) {
                File[] files = musicDir.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].getName().toLowerCase(Locale.CHINA).endsWith(".mpe")) {
                            Music music = new Music();
                            music.setPath(files[i].getAbsolutePath());
                            music.setTitle(files[i].getName().substring(0, files[i].getName().length() - 4));
                            musicList.add(music);
                        }
                    }
                }
            }
        }
        return musicList;
    }
}
