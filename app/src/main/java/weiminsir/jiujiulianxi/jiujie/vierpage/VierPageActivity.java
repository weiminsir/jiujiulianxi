package weiminsir.jiujiulianxi.jiujie.vierpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import weiminsir.jiujiulianxi.R;

public class VierPageActivity extends FragmentActivity {

    //    PagerTabStrip pagerTabStrip;
    PagerTitleStrip pagerTitleStrip;
    ViewPager viewPager;
    ArrayList<String> titlesList = new ArrayList<>();
//    ArrayList<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vier_main);
        initView();
        viewPager.setAdapter(new viewPageAdapter(getSupportFragmentManager()));

    }
    public void initView() {
//        pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pagerTitleStrip=(PagerTitleStrip) findViewById(R.id.pagertab);
        pagerTitleStrip.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        //设置背景颜色
//        pagerTabStrip.setBackgroundColor(getResources().getColor(android.R.color.background_dark));
        //设置下环线颜色
//        pagerTabStrip.setTabIndicatorColor(getResources().getColor(android.R.color.holo_blue_bright));
//        FragementOne fragementOne = new FragementOne();
//        fragment2 fragementTwo=new fragment2();
//        fragment3 fragementThree=new fragment3();
//        fragments = new ArrayList<>();
//        fragments.add(fragementOne);
//        fragments.add(fragementTwo);
//        fragments.add(fragementThree);
        titlesList.add("第一页");
        titlesList.add("第2页");
        titlesList.add("第3页");
    }
    public class viewPageAdapter extends FragmentPagerAdapter{
        public viewPageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {

           return getNewFragement (position);

//            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titlesList.get(position);
        }
    }

    public Fragment getNewFragement (int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragementOne();
                break;
            case 1:
                fragment = new fragment2();
                break;
            case 2:
                fragment = new fragment3();
                break;
        }
        return fragment;
    }
}
