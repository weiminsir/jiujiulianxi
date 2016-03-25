package weiminsir.jiujiulianxi.demo.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.demo.MessageActivity.MessageActivity;

public class SplashActivity extends AppCompatActivity {

    @InjectView(R.id.rl_root)
    protected RelativeLayout rlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);
        startAnimation();

    }

    public void startAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3000);
        rotate.setFillAfter(true);
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(3000);// 动画时间
        alpha.setFillAfter(true);// 保持动画状态
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(scaleAnimation);
        set.addAnimation(rotate);
        set.addAnimation(alpha);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jumpNextPage();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        rlRoot.startAnimation(set);
    }

    public void jumpNextPage() {
        startActivity(new Intent(SplashActivity.this, MessageActivity.class));
        finish();

//        boolean is_shown = prefUtils.getBoolen("is_shown", false);

//        if (!is_shown) {
//            startActivity(new Intent(SplashActivity.this, MainActivity.class));
//            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
//        }//        } else {
////
//        }

    }
}
