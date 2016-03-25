package weiminsir.jiujiulianxi.youlu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Sms;

/**
 * Created by Weimin on 2016/3/15.
 */
public class SmsAdapter extends BaseListAdapter<Sms> {

   public SmsAdapter(Context context,List<Sms> smsList){
       super(context,smsList);

   }


    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        return super.getView(i, convertView, viewGroup);
    }
}
