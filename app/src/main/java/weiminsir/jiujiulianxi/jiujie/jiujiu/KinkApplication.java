package weiminsir.jiujiulianxi.jiujie.jiujiu;

import android.app.Application;

/**
 * Created by ken on 18/7/15.
 */
public class KinkApplication extends Application {

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public static boolean RECEIVE_PUSH = true;
    public static String DEVICE_TOKEN = "";
    public static KinkApplication context;
    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(this));
        // Context
        if (context == null) {
            context = (KinkApplication) getApplicationContext();
//            SPUtil.init(context);
        }

        //get screen size
//        SCREEN_WIDTH = Device.getScreenWidth(context);
//        SCREEN_HEIGHT = Device.getScreenHeight(context);

        //get local token

        //get local setting about whether receive push

        //init sticker camera


    }
}
