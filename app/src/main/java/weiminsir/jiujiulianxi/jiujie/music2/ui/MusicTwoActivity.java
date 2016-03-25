package weiminsir.jiujiulianxi.jiujie.music2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.jiujie.music2.adapter.MusicAdapter;
import weiminsir.jiujiulianxi.jiujie.music2.app.MusicPlayerApplication;
import weiminsir.jiujiulianxi.jiujie.music2.entity.Music;
import weiminsir.jiujiulianxi.jiujie.music2.service.PlayMusicService;

public class MusicTwoActivity extends Activity implements View.OnClickListener{

    /**
     * ImageButton：播放/暂停
     */
    private ImageButton ibPlayOrPause;
    /**
     * ListView：歌曲列表控件
     */
    private ListView lvMusics;
    /**
     * 歌曲的数据源
     */
    private List<Music> musics;
    /**
     * 歌曲列表的Adapter
     */
    private MusicAdapter adapter;
    /**
     * Application
     */
    private MusicPlayerApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_two);

        ibPlayOrPause = (ImageButton) findViewById(R.id.ib_music_play_or_pause);
        lvMusics = (ListView) findViewById(R.id.lv_musics);

        // 准备数据源
        app = (MusicPlayerApplication) getApplication();
        musics = app.getMusicList();

        // 准备显示ListView
        adapter = new MusicAdapter(this, musics);
        lvMusics.setAdapter(adapter);

        // 为控件添加监听器
        ibPlayOrPause.setOnClickListener(this);
//        sendBroadcast(new Intent());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_music_play_or_pause:
                Intent intent = new Intent(this, PlayMusicService.class);
                intent.putExtra("action", 1);
                startService(intent);
                break;
            default:
                break;
        }
    }

}
