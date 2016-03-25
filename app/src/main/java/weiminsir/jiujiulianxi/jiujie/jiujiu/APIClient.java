package weiminsir.jiujiulianxi.jiujie.jiujiu;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by ken on 16/7/15.
 */
public interface APIClient {
    @GET("/api/kink/public/hot/")
    Observable<NKinkList> getHotKinkList();
}

