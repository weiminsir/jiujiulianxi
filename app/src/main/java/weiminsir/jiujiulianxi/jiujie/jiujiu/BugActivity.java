package weiminsir.jiujiulianxi.jiujie.jiujiu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import weiminsir.jiujiulianxi.R;


/**
 * Created by ken on 19/7/15.
 */
public class BugActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);
        TextView textView = (TextView) findViewById(R.id.bugTextView);
        textView.setText(getIntent().getStringExtra("stackTrace"));
    }
}
