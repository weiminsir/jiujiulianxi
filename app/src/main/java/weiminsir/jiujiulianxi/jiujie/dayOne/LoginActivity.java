package weiminsir.jiujiulianxi.jiujie.dayOne;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import weiminsir.jiujiulianxi.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

  
}
