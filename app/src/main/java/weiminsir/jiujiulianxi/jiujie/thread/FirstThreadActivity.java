package weiminsir.jiujiulianxi.jiujie.thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class FirstThreadActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.txt_thread)
    TextView textView;
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_thread);
        ButterKnife.inject(this);
        progressBar.setOnClickListener(this);

    }

    int progress = 0;
    class outer extends Thread {
        class inner implements Runnable {
            @Override
            public void run() {
                progressBar.setProgress(progress);
                if (progress >= 100) {
                    progressBar.setEnabled(false);

                }
            }
        }
        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                progress = i;
                runOnUiThread(new inner());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.progressBar:
                new outer().start();
                break;
        }
    }
}
