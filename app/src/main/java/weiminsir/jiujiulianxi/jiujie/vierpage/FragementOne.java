package weiminsir.jiujiulianxi.jiujie.vierpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import weiminsir.jiujiulianxi.R;

/**
 * Created by Weimin on 2016/3/9.
 */

public class FragementOne  extends Fragment implements View.OnClickListener{
    private TextView tv;
    private Button btn;
    View mainView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("wick", "初次创建");
        initview();
        btn.setOnClickListener(this);
    }
    public  void initview(){
        LayoutInflater inflater=getActivity().getLayoutInflater();
        mainView=inflater.inflate(R.layout.fragment1, (ViewGroup)getActivity().findViewById(R.id.viewpager), false);

        Log.v("huahua", "fragment1-->mainView");
        tv =(TextView) mainView.findViewById(R.id.tv1);
        btn = (Button) mainView.findViewById(R.id.btn1);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                tv.setText("hello,fragement显示字母");
                break;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup parent = (ViewGroup) mainView.getParent();
             if (parent!=null){
                 parent.removeAllViewsInLayout();
                 Log.v("huahua", "removeAllViewsInLayout");
             }
        return mainView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.v("huahua", "fragment1-->onDestroy()");
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Log.v("huahua", "fragment1-->onPause()");
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.v("huahua", "fragment1-->onResume()");
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Log.v("huahua", "fragment1-->onStart()");
    }
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.v("huahua", "fragment1-->onStop()");
    }
}
