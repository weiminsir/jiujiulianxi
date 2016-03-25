package weiminsir.jiujiulianxi.youlu.activity;

import android.app.Application;

/**
 * Created by Weimin on 2016/3/14.
 */
public class MyApplication extends Application {

    public static  MyApplication mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        if (mContext==null) {
            mContext = (MyApplication)getApplicationContext();
        }
    }
    public static MyApplication getContext() {
        return mContext;
    }

}
