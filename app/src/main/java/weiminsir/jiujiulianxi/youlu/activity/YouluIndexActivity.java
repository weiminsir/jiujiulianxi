package weiminsir.jiujiulianxi.youlu.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.fragement.TestFragement;

public class YouluIndexActivity extends FragmentActivity {

    @InjectView(R.id.rb1)
    protected RadioButton rb1;
    @InjectView(R.id.rb2)
    protected RadioButton rb2;
    @InjectView(R.id.rb3)
    protected RadioButton rb3;
    @InjectView(R.id.rb4)
    protected RadioButton rb4;
    @InjectView(R.id.radioGroup)
    protected RadioGroup radioGroup;
    @InjectView(R.id.vp_contact_index)
    protected ViewPager viewPager;

    private ArrayList<Fragment> fragments;
    private MyPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youlu_index);
        Log.i("WICK", "activity onActivityCreated");
        ButterKnife.inject(this);
        setAdapter();
        setListener();
//        EventBus.getDefault().register(this);
    }

    public void setAdapter() {
        fragments = new ArrayList<Fragment>();
//        fragments.add(new ContactFragement());
//        fragments.add(new CalllogFragement());
//        fragments.add(new ConversationFragment());
        fragments.add(new TestFragement());
        fragments.add(new TestFragement());
        fragments.add(new TestFragement());
        fragments.add(new TestFragement());

        adapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    public void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb1.setChecked(true);
                        break;
                    case 1:
                        rb2.setChecked(true);
                        break;
                    case 2:
                        rb3.setChecked(true);
                        break;
                    case 3:
                        rb4.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {

                switch (checkId) {
                    case R.id.rb1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    class MyPageAdapter extends FragmentPagerAdapter {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
