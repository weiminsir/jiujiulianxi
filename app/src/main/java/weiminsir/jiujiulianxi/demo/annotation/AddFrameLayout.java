package weiminsir.jiujiulianxi.demo.annotation;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by Weimin on 2016/3/15.
 */
public class AddFrameLayout extends BasePage{

    public AddFrameLayout(Activity activity) {
        super(activity);
    }

    public void initData() {
        System.out.println("初始化政务数据....");


        TextView text = new TextView(mActivity);
        text.setText("政务");
        text.setTextColor(Color.RED);
        text.setTextSize(25);
        text.setGravity(Gravity.CENTER);

        // 向FrameLayout中动态添加布局
        flContent.addView(text);
    }
}
