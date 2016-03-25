package weiminsir.jiujiulianxi.jiujie.dayOne;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
/**
 * Created by Weimin on 2016/3/10.
 */
public abstract class BaseFragement extends Fragment {
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView!=null) {
            return mRootView;
        }
        mRootView = inflater.inflate(getResourceIds(), container, false);
        ButterKnife.inject(this.mRootView);
        return mRootView;
    }
    public abstract int getResourceIds();
}
