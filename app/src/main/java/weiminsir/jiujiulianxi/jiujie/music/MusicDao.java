package weiminsir.jiujiulianxi.jiujie.music;


import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Weimin on 2016/3/10.
 */
public class MusicDao {

    public List<Music> getData() {
        List<Music> musics = new ArrayList<Music>();
//        String path = "";
//        File file = new File(path);


        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            File musicDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_MUSIC);
            if (musicDir.exists()) {
                File[] files = musicDir.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].isFile()) {
                            if (files[i].getName().toLowerCase(Locale.CHINA).
                                    endsWith(".mp3")) {
                                Music music = new Music();
                                music.setPath(files[i].getAbsolutePath());

                                music.setTitle(files[i].getName().substring(0,
                                        files[i].getName().length() - 4));
                                musics.add(music);
                                Log.d("tedu", "" + files[i]);
                            }
                        }
                    }
                }

            }
        }
        return musics;
    }
}
