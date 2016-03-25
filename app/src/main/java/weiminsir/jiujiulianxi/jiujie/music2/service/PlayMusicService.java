package weiminsir.jiujiulianxi.jiujie.music2.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;
import java.util.List;

import weiminsir.jiujiulianxi.jiujie.music2.app.MusicPlayerApplication;
import weiminsir.jiujiulianxi.jiujie.music2.entity.Music;

/**
 * Created by Weimin on 2016/3/11.
 */
public class PlayMusicService extends Service {
    private List<Music> musics;
    /**
     * 当前播放的歌曲的索引
     */
    private int currentMusicIndex;
    /**
     * 暂停时播放到的位置，单位：毫秒
     */
    private int pausePosition;
    /**
     * Application
     */
    private MusicPlayerApplication app;
    /**
     * 播放工具
     */
    private MediaPlayer player;

    @Override
    public void onCreate() {
        // 准备数据源
        app = (MusicPlayerApplication) getApplication();
        musics = app.getMusicList();
        // 初始化播放工具
        player = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int action = intent.getIntExtra("action", -1);
        switch (action) {
            case 1: // 播放/暂停
                if(player.isPlaying()) {
                    pause();
                } else {
                    play();
                }
                break;

            default:
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 播放
     */
    private void play() {
        try {
            player.reset();
            player.setDataSource(musics.get(currentMusicIndex).getPath());
            player.prepare();
            player.seekTo(pausePosition);
            player.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停
     */
    private void pause() {
        if(player.isPlaying()) {
            player.pause();
            pausePosition = player.getCurrentPosition();
        }
    }

    /**
     * 播放上一首
     */
    private void previous() {
        currentMusicIndex--;
        if(currentMusicIndex < 0) {
            currentMusicIndex = musics.size() - 1;
        }
        pausePosition = 0;
        play();
    }

    /**
     * 播放下一首
     */
    private void next() {
        currentMusicIndex++;
        if(currentMusicIndex >= musics.size()) {
            currentMusicIndex = 0;
        }
        pausePosition = 0;
        play();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // （无视）
        return null;
    }
}
