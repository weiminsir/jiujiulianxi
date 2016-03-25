package weiminsir.jiujiulianxi.demo.customview;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * Created by Weimin on 2016/1/17.
 */
public class DragLayout extends FrameLayout {
    public static final String TAG = "tag";

    private ViewDragHelper dragHelper;
    private ViewGroup mLeftContent;
    private ViewGroup mainContent;
    private int width;

    public DragLayout(Context context) {
        this(context, null);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //最小敏感范围，只越小越敏感。传感器 。
        //第一步  得到引用
        dragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                //  child  当前被唾液的view
                // 区分多点触摸的ID
                return child == mainContent;
                //true  允许被托追，根据返回值进行是否已经捕获
            }

            @Override
            public void onViewCaptured(View capturedChild, int activePointerId) {
                Log.d(TAG, "onViewCaptured" + capturedChild);
                //当capturedChild  被捕获时候
                super.onViewCaptured(capturedChild, activePointerId);
            }

            @Override
            //返回托追范围  不进行真正的限制
            public int getViewHorizontalDragRange(View child) {
                return width;
            }

            @Override
            public void onViewDragStateChanged(int state) {
                super.onViewDragStateChanged(state);
            }

            @Override
            //根据建议值讲移动到位置 辞职没有发生移动
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                //child  view  left:新的建议值，dx 变化量
                //left=旧的只加上ＤＸ
                Log.d(TAG, "clampViewPositionHorizontal" + child.getWidth());
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                super.onViewPositionChanged(changedView, left, top, dx, dy);
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
            }
        });



    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    //传递触摸时间
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return dragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dragHelper.processTouchEvent(event);
//持续接收事件
        return true;
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) {
            throw new IllegalStateException("sgsgs");
        }
        if (getChildAt(0) instanceof ViewGroup && getChildAt(1) instanceof ViewGroup) {
            throw new IllegalArgumentException("sdsdgsgfsg");

        }
        mLeftContent = (ViewGroup) getChildAt(0);
        mainContent = (ViewGroup) getChildAt(1);
    }

    @Override
    //measure 之后执行，尺寸变化时候调用
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        width = (int)(measuredWidth * 0.6f);
    }
}
