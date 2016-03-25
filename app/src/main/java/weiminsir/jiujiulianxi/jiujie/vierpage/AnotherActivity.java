package weiminsir.jiujiulianxi.jiujie.vierpage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import weiminsir.jiujiulianxi.R;

public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Log.i("wick", "要适配图片了");
    }



}
