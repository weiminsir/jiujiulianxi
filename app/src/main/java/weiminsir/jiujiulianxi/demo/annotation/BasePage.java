package weiminsir.jiujiulianxi.demo.annotation;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Weimin on 2016/3/15.
 */
public class BasePage {
    public Activity mActivity;
    public View mRootView;// 布局对象
    public TextView tvTitle;// 标题对象
    public FrameLayout flContent;// 内容
    public ImageButton btnMenu;// 菜单按钮

    public BasePage(Activity activity) {
        mActivity = activity;
        initViews();
    }

    public void initViews() {
    }

}
