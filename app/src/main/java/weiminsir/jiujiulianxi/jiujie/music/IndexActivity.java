package weiminsir.jiujiulianxi.jiujie.music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class IndexActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener,
        SeekBar.OnSeekBarChangeListener,MediaPlayer.OnCompletionListener {
    private String path = "/mnt/sdcard/Music/FF10-ToZanarkand.mp3";
    @InjectView(R.id.ib_play_or_pause)
    protected ImageButton ibPlayorPause;
    @InjectView(R.id.lv_musics)
    protected ListView mListView;
    @InjectView(R.id.tv_music_current_position)
    protected TextView mCurrentTime;
    @InjectView(R.id.tv_music_duration)
    protected TextView mDurrention;//总时间长
    @InjectView(R.id.ib_next)
    protected ImageButton mNext;
    @InjectView(R.id.ib_previous)
    protected ImageButton mPrevious;
    @InjectView(R.id.sb_music_progress)
    protected SeekBar mSeekBar;

    private MediaPlayer player;
    private int pausePosition;
    private MusicAdapter adapter;
    private List<Music> musicList;
    private int currentItem;

    private boolean isRunning =false;
    private boolean isStart =false;
    private boolean isTouchSeekBar =false;

    private upDatedUIThread thread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.inject(this);
        initView();
        setListener();

    }
    public void initView() {
        player = new MediaPlayer();
        MusicDao musicDao = new MusicDao();
        musicList = musicDao.getData();
        adapter = new MusicAdapter(this, musicList);
        mListView.setAdapter(adapter);
//        mDurrention.setText();
    }

    public void setListener() {
        ibPlayorPause.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mPrevious.setOnClickListener(this);
        mListView.setOnItemClickListener(this);
    }


    public void startUpdateUIThread() {
        if (thread == null) {
            isRunning = true;
            thread = new upDatedUIThread();
            thread.start();
        }
    }

    public void stopUpdateUiThread() {
        isRunning = false;
        thread = null;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_play_or_pause:
                if (player.isPlaying()) {
                    pause();
                } else {
                    play();
                }
                break;
            case R.id.ib_next:
                next();
                break;
            case R.id.ib_previous:
                previous();
                break;
        }
    }
    public void pause() {
        player.pause();
        pausePosition = player.getCurrentPosition();
        ibPlayorPause.setImageResource(android.R.drawable.ic_media_play);
        stopUpdateUiThread();
    }

    public void play() {
        try {
            player.reset();
            player.setDataSource(musicList.get(currentItem).getPath());
            player.prepare();
            player.seekTo(pausePosition);
            player.start();
            ibPlayorPause.setImageResource(android.R.drawable.ic_media_pause);
            startUpdateUIThread();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void next() {
        currentItem++;
        if (currentItem >= musicList.size()) {
            currentItem = 0;
        }
        pausePosition = 0;
        play();
    }
    public void previous() {
        currentItem--;
        if (currentItem < 0) {
            currentItem = musicList.size();
        }
        pausePosition = 0;
        play();
    }

    class upDatedUIThread extends Thread{
        class Runner implements Runnable{
            @Override
            public void run() {
                if (player.isPlaying()) {
                    while (isRunning) {
                        int currentPosition = player.getCurrentPosition();
                        int duration = player.getDuration();
                        int percent = 100 * currentPosition / duration;
                        mCurrentTime.setText(timeUtils.formatTime(currentPosition));
                        if (!isTouchSeekBar) {
                            mSeekBar.setProgress(percent);
                        }
                    }
                }

            }
        }

        private Runner runner = new Runner();
        @Override
        public void run() {
            while (isRunning) {
                if (player.isPlaying()) {
                    runOnUiThread(runner);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        currentItem = position;
        pausePosition = 0;
        play();

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        next();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        isTouchSeekBar = true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int percent = seekBar.getProgress();
        pausePosition = player.getDuration() * percent / 100;
        play();
        isTouchSeekBar = false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }
}
