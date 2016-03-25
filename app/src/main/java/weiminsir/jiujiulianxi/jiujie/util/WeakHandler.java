package weiminsir.jiujiulianxi.jiujie.util;

import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * Created by ken on 22/8/15.
 */
abstract public class WeakHandler<T> extends Handler {
    private WeakReference<T> mOwner;

    public WeakHandler(T owner) {
        mOwner = new WeakReference<T>(owner);
    }

    public T getOwner() {
        return mOwner.get();
    }
}
