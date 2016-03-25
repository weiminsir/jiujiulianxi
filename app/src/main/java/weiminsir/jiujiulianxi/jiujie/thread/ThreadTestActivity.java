package weiminsir.jiujiulianxi.jiujie.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import weiminsir.jiujiulianxi.R;
public class ThreadTestActivity extends Activity implements View.OnClickListener {

    private Handler handler;
    private Looper subThreadLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);

        Log.e("tedu", "MainActivity.onCreate(), current thread id=" + Thread.currentThread().getId());
        findViewById(R.id.btn_send_message).setOnClickListener(this);

        new Thread() {
            public void run() {
                Log.d("tedu", "SubThread.run(), new Handler, current thread id=" + Thread.currentThread().getId());
                Looper.prepare();
                Log.d("tedu", "Looper.prepare()");
                Looper.loop();
                Log.d("tedu", "Looper.loop()");
                subThreadLooper = Looper.myLooper();
                Log.d("tedu", "subThreadLooper -> " + subThreadLooper);
            }
        }.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler = new Handler(subThreadLooper, new InnerHandlerCallback());
    }

    class InnerHandlerCallback implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            Log.i("tedu", "handleMessage(), current thread id=" + Thread.currentThread().getId());
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        new Thread() {
            public void run() {
                Log.d("tedu", "SubThread.run(), send Message, current thread id=" + Thread.currentThread().getId());
                Message.obtain(handler).sendToTarget();
            }
        }.start();
    }

    public void test() {



    }
}
