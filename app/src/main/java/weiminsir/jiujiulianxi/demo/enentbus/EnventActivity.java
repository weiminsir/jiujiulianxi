package weiminsir.jiujiulianxi.demo.enentbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import weiminsir.jiujiulianxi.R;

public class EnventActivity extends Activity {
//    @InjectView(R.id.btn_event)
    Button button;
//    @InjectView(R.id.tv_msg)
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String message = "书写一定要认真";
        setContentView(R.layout.activity_envent);
        EventBus.getDefault().register(this);

        button = (Button)findViewById(R.id.btn_event);
        msg = (TextView)findViewById(R.id.tv_msg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().post(new FirstEnvent(message));
            }
        });

    }

    public void onEventMainThread(FirstEnvent event) {

        msg.setText(event.getMsg());
        Toast.makeText(this, event.getMsg(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
