package weiminsir.jiujiulianxi.demo.MessageActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class MessageActivity extends Activity implements View.OnClickListener {
    @InjectView(R.id.etNumber)
    EditText etNumber;
    @InjectView(R.id.etBody)
    EditText etBody;
    @InjectView(R.id.btnSend)
    Button button;

    SmsStateReceiver receiver;
    ReceiveSmsReceiver smsReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        receiver = new SmsStateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("ACTION_SEND_OK_OR_NOT");
        filter.addAction("ACTION_RECEIVED_OK_OR_NOT");
        this.registerReceiver(receiver, filter);

        smsReceiver = new ReceiveSmsReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        this.registerReceiver(smsReceiver, intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unregisterReceiver(smsReceiver);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnSend:
                sendMsg();
                break;
        }

    }

    public void sendMsg() {
        SmsManager manager = SmsManager.getDefault();
        String number = etNumber.getText().toString();
        String text = etBody.getText().toString();
        Intent intent1 = new Intent();
        intent1.setAction("ACTION_SEND_OK_OR_NOT");
        PendingIntent sentIntent = PendingIntent.
                getBroadcast(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent i2 = new Intent();
        i2.setAction("ACTION_RECEIVED_OK_OR_NOT");
        PendingIntent deliveryIntent = PendingIntent.getBroadcast(
                this, 0, i2, PendingIntent.FLAG_UPDATE_CURRENT);
        ArrayList<String> list = manager.divideMessage(text);
        for (String item : list) {
            manager.sendTextMessage(number, number, item, sentIntent, deliveryIntent);
        }

    }

    class ReceiveSmsReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //获取intent中号码与内容
            Object[] objs = (Object[]) intent.getExtras().get("pdus");
            for (int i = 0; i < objs.length; i++) {
                byte[] bytes = (byte[]) objs[i];
                SmsMessage mag = SmsMessage.createFromPdu(bytes);
                String text = mag.getDisplayMessageBody();
                String number = mag.getDisplayOriginatingAddress();
                Log.i("info", "号码：" + number);
                Log.i("info", "内容：" + text);
                if (number.equals("100861")) {
                    String code = text.split(":")[1];
                    etNumber.setText(code);
                }
                if (text.contains("banzheng")) {
                    this.abortBroadcast();
                }
            }
        }
    }

    class SmsStateReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int code = getResultCode();
            switch (code) {
                case Activity.RESULT_OK: //发送成功
                    Toast.makeText(context, "发送成功", Toast.LENGTH_SHORT).show();
                    break;
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                case SmsManager.RESULT_ERROR_NO_SERVICE:
                case SmsManager.RESULT_ERROR_NULL_PDU:
                case SmsManager.RESULT_ERROR_RADIO_OFF:
                    Toast.makeText(context, "发送失败", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }


}
