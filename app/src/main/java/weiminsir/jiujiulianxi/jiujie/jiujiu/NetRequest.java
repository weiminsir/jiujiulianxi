package weiminsir.jiujiulianxi.jiujie.jiujiu;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

/**
 * Created by Weimin on 2015/11/18.
 */
public class NetRequest {
        public final static int UPLOAD_IMAGE_MAX_WIDTH = 48;//480
        public final static int UPLOAD_IMAGE_MAX_HEIGHT = 80;//800
        public final static String TEMP_UPLOAD_IMAGE_PREFIX = "tmp";
        public final static int IMAGE_SIZE_THRESHOLD = 400 * 1024;//400K
        private static final String VERSION = "2.0";
        //    public final static String BASE_URL = "http://jiujiu.ramytech.com";
        //public final static String BASE_URL = "http://dev.jiujiuapp.com";
        public final static String BASE_URL = "http://www.jiujiuapp.com";
        //public  final  static  String BASE_URL="http://192.168.1.120:8000";
        public final static APIClient APIInstance;
        private static Cache cache;
        static {
            OkHttpClient okHttpClient = new OkHttpClient();
            try {
                cache = new Cache(KinkApplication.context.getExternalCacheDir(), 1 * 1024 * 1024);
                okHttpClient.setCache(cache);
            } catch (Exception e) {
                e.printStackTrace();
            }
            okHttpClient.setConnectTimeout(40, TimeUnit.SECONDS);
//            okHttpClient.interceptors().add(new CacheInterceptor());
            RestAdapter.Builder builder = new RestAdapter.Builder();
            builder.setClient(new OkClient(okHttpClient));
            builder.setEndpoint(BASE_URL);
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addQueryParam("version", VERSION);
                }
            });
            builder.setLogLevel(RestAdapter.LogLevel.FULL)
                    .setLog(new AndroidLog("Retrofit"));
            APIInstance = builder.build().create(APIClient.class);
        }
    }
