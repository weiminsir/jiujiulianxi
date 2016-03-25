package weiminsir.jiujiulianxi.youlu.fragement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.demo.animation.SplashActivity;
/**
 * Created by Weimin on 2016/3/15.
 */
public class TestFragement extends BaseFragement {
//    @InjectView(R.id.btn_test)
    protected Button button;
//    onAttach(Activity ,
//            WICK﹕ onAttach,context
//             WICK﹕ onCreate,
//          WICK﹕ onCreateView,
//             WICK﹕ onViewCreated,
//             WICK﹕ onActivityCreated,
//             WICK﹕ onViewStateRestored,
//            WICK﹕ onStart,
//             WICK﹕ onResume,


    @Override
    public int getResourceId() {
        return R.layout.fragment_test;
    }

    public TestFragement() {
        super();
        Log.i("WICK", "TestFragement,");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("WICK", "onCreate,");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("WICK", "onCreateView,");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("WICK", "onViewCreated,");

//        setListener();


    }

    void setListener() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("WICK", "onActivityCreated,");
        button = (Button) mRootView.findViewById(R.id.btn_test);
//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, SplashActivity.class));
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("WICK", "onStart,");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("WICK", "onPause,");
    }

    @Override
    public void onResume() {
        Log.i("WICK", "onResume,");
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("WICK", "onStop,");
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        Log.i("WICK", "onDestroyView,");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("WICK", "onDestroy,");
    }


    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("WICK", "onViewStateRestored,");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("WICK", "onAttach,context");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i("WICK", "onAttach(Activity ,");
    }
}
