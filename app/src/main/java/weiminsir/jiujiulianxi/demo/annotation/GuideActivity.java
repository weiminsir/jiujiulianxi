package weiminsir.jiujiulianxi.demo.annotation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.demo.animation.SplashActivity;

public class GuideActivity extends Activity {


    @InjectView(R.id.vp_guide)
    protected ViewPager mViewPage;
    @InjectView(R.id.btn_next)
    protected Button btnNext;

    private static final int[] imageRS = new int[]{
            R.drawable.guide_1,
            R.drawable.guide_2,
            R.drawable.guide_3,
    };
    List<ImageView> mViewList = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.inject(this);
        initViews();
        mViewPage.setAdapter(new MyAdapter());
    }
    public void initViews() {
        for (int i = 0; i < imageRS.length; i++) {
            ImageView image = new ImageView(this);
            image.setImageResource(imageRS[i]);
            mViewList.add(image);
        }
    }

    @OnClick(R.id.btn_next)
    protected void startOnClick() {
//        prefUtils.setBoolen("is_showed", true);
        startActivity(new Intent(GuideActivity.this, SplashActivity.class));
        finish();
    }

    class MyAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return mViewList == null ? 0 : imageRS.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
