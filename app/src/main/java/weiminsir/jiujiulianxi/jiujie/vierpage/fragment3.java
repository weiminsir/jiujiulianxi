package weiminsir.jiujiulianxi.jiujie.vierpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class fragment3 extends Fragment implements View.OnClickListener {
    private View mMainView;
    @InjectView(R.id.btn_three)
    Button btnThree;
    Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        Log.v("huahua", "fragment3-->onCreateView()");
//		ViewGroup p = (ViewGroup) mMainView.getParent();
//        if (p != null) {
//            p.removeAllViewsInLayout();
//            Log.v("huahua", "fragment3-->�Ƴ��Ѵ��ڵ�View");
//        }
        if (mMainView != null) {
            return mMainView;
        }
        mMainView = inflater.inflate(R.layout.fragment3, container, false);

        ButterKnife.inject( this,mMainView);
        return mMainView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_three:
                Intent intent = new Intent(activity, AnotherActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.v("huahua", "fragment3-->onDestroy()");
    }
    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Log.v("huahua", "fragment3-->onPause()");
    }
    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.v("huahua", "fragment3-->onResume()");
    }
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Log.v("huahua", "fragment3-->onStart()");
    }
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.v("huahua", "fragment3-->onStop()");
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }


    
}

