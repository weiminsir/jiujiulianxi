package weiminsir.jiujiulianxi.jiujie.broadcastRexeiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class SendBroadctivity extends Activity {
    @InjectView(R.id.send)
    Button btn_send;
    dynamicReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broadctivity);
        ButterKnife.inject(this);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendBroadctivity.this, ReceiveActivity.class);
                intent.setAction("com.wicksir");
                intent.putExtra("name", "wick");
                intent.putExtra("age", "25");
                startActivity(intent);
                sendBroadcast(intent);
                codeRegister();

            }
        });
    }

    public void codeRegister() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("");
        receiver = new dynamicReceiver();
        registerReceiver(receiver, intentFilter);


    }

    class dynamicReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
