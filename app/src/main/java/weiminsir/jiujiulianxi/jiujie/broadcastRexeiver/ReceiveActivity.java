package weiminsir.jiujiulianxi.jiujie.broadcastRexeiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class ReceiveActivity extends Activity {
    @InjectView(R.id.txt)
    TextView textView;
    String name = "";
    String age = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        ButterKnife.inject(this);
        textView.setText(name+":"+age);

    }


    public  class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            name = intent.getStringExtra("name");
            age = intent.getStringExtra("age");
            Log.i("wick", "receive start");
            Log.i("wick", intent.getStringExtra("name"));
            Log.i("wick", intent.getStringExtra("age"));
            System.out.println(intent.getStringExtra("name") + "\n" + intent.getStringExtra("age") + "\n");
        }
    }


}
