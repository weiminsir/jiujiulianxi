package weiminsir.jiujiulianxi.jiujie.dayOne;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
public class BottomMenuActivity extends FragmentActivity implements View.OnClickListener {
    @InjectView(R.id.btn_tab_menu_deal)
    public Button btnTabMenuDeal;
    @InjectView(R.id.btn_tab_menu_nearby)
    public Button btnTabMenuNearby;
    @InjectView(R.id.btn_tab_menu_my)
    public Button btnTabMenuMy;
    @InjectView(R.id.btn_tab_menu_more)
    public Button btnTabMenuMore;
    @InjectView(R.id.bottom_viewpage)
    public ViewPager viewPager;
    private int currentItem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);
        ButterKnife.inject(this);
        initView();
    }
    public void initView() {
        btnTabMenuDeal.setOnClickListener(this);
        btnTabMenuNearby.setOnClickListener(this);
        btnTabMenuMy.setOnClickListener(this);
        btnTabMenuMore.setOnClickListener(this);
        setTabMenuSelected(currentItem);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
                setTabMenuSelected(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void setTabMenuSelected(int position) {
        btnTabMenuDeal.setSelected(false);
        btnTabMenuNearby.setSelected(false);
        btnTabMenuMy.setSelected(false);
        btnTabMenuMore.setSelected(false);
        if (position == 0) {
            btnTabMenuDeal.setSelected(true);
        }
        if (position == 1) {
            btnTabMenuNearby.setSelected(true);
        }
        if (position == 2) {
            btnTabMenuMy.setSelected(true);
        }
        if (position == 3) {
            btnTabMenuMore.setSelected(true);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tab_menu_deal:
                currentItem = 0;
                setTabMenuSelected(currentItem);
                viewPager.setCurrentItem(currentItem);
                break;
            case R.id.btn_tab_menu_nearby:
                currentItem = 1;
                setTabMenuSelected(currentItem);
                viewPager.setCurrentItem(currentItem);
                break;
            case R.id.btn_tab_menu_my:
                currentItem = 2;
                setTabMenuSelected(currentItem);
                viewPager.setCurrentItem(currentItem);
                break;
            case R.id.btn_tab_menu_more:
                currentItem = 3;
                setTabMenuSelected(currentItem);
                viewPager.setCurrentItem(currentItem);
                break;
        }
    }
    public class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return 4;
        }
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new FrageMentOne();
                    break;
                case 1:
                    fragment = new FrageMentTwo();
                    break;
                case 2:
                    fragment = new FrageMentThree();
                    break;
                case 3:
                    fragment = new FrageMentFour();
                    break;
            }
            return fragment;
        }
    }
}