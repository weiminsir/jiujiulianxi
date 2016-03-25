package weiminsir.jiujiulianxi.demo.fresco;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class DraweeImgTestActivity extends Activity {

    @InjectView(R.id.image_fresco)
    SimpleDraweeView simpleDraweeView;
    @InjectView(R.id.piasso)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_drawee_img_test);
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {
        //创建SimpleDraweeView对象
        //创建将要下载的图片的URI
        Uri imageUri = Uri.parse("http://e.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sig" +
                "n=b4776feaafc3793169658e7b8aaddc20/11385343fbf2b2115f9428a2ca8065380dd78ea0.jpg");
        //开始下载


        ControllerListener listener = new BaseControllerListener() {
            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
            }

            @Override
            public void onIntermediateImageSet(String id, Object imageInfo) {
                super.onIntermediateImageSet(id, imageInfo);
            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {
                super.onIntermediateImageFailed(id, throwable);
            }

            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
            }
        };

        //创建DraweeController
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                //加载的图片URI地址
                .setUri(imageUri)
                        //设置点击重试是否开启
                .setTapToRetryEnabled(true)
                        //设置旧的Controller
                .setOldController(simpleDraweeView.getController())
                .setControllerListener(listener)
                        //构建
                .build();

        //设置DraweeController
        simpleDraweeView.setController(controller);

        Picasso.with(this).load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1458053966&di=a736e3b79e4586713d94f15a99c9b971&src=http://b" +
                ".zol-img.com.cn/sjbizhi/images/" +
                "6/320x510/1385979183583.jpg").into(imageView);
    }
}


