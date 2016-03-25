package weiminsir.jiujiulianxi.jiujie.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Weimin on 2016/3/10.
 */
public class CircleImageView extends ImageView{
    public CircleImageView(Context context) {
        super(context);
    }



    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public Bitmap getSourceBitmap(Drawable drawable){
        if (drawable instanceof Drawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            return bitmapDrawable.getBitmap();
        }else {
            Bitmap bitmap = Bitmap.createBitmap(
                    drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight(),
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas();
            drawable.draw(canvas);
            return bitmap;
        }
    }

    public Paint paint = new Paint();
    @Override
    public void onDraw(Canvas canvas) {
        Bitmap src = getSourceBitmap(getDrawable());
        BitmapShader shader = new BitmapShader(src, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        int size = src.getWidth() > src.getHeight() ? src.getHeight() : src.getWidth();
        canvas.drawCircle(size/2,size/2,size/2,paint);
    }



}
