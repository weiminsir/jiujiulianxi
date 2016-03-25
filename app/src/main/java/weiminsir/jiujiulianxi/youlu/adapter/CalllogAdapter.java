package weiminsir.jiujiulianxi.youlu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.entity.Calllog;
import weiminsir.jiujiulianxi.youlu.util.ImageLoader;

/**
 * Created by Weimin on 2016/3/14.
 */
public class CalllogAdapter extends BaseListAdapter<Calllog>{

    private ImageLoader imageLoader;
    public CalllogAdapter(Context context) {
        super(context);
//        this.imageLoader = new ImageLoader(context, listView);
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_lv_calllog, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
//        //给holder中持有的控件赋值
//        Calllog log =(Calllog) getItem(position);
//        //设置头像
//        imageLoader.displayImage(holder.ivPhoto, log.getPhotoId(), position);
//        //设置名字
//        holder.tvName.setText(log.getName()==null ? "未知号码":log.getName());
//        //设置名字的颜色
//        if(log.getType() == CallLog.Calls.MISSED_TYPE){
//            holder.tvName.setTextColor(Color.RED);
//        }else{
//            holder.tvName.setTextColor(Color.BLACK);
//        }
//        //设置是否显示icon
//        if(log.getType() == CallLog.Calls.OUTGOING_TYPE){
//            holder.ivIcon.setVisibility(View.VISIBLE);
//        }else{
//            holder.ivIcon.setVisibility(View.INVISIBLE);
//        }
        //设置电话号码
        holder.tvNumber.setText("13611909778");
        //设置时间
//        holder.tvDate.setText(DateUtils.parse(log.getDate()));
        holder.tvDate.setText("北京时间  ");
        holder.ivIcon.setImageResource(icons.length);
        return convertView;
    }

    class ViewHolder{
        @InjectView(R.id.ivPhoto)
        ImageView ivPhoto;
        @InjectView(R.id.ivIcon)
        ImageView ivIcon;
        @InjectView(R.id.tvName)
        TextView tvName;
        @InjectView(R.id.tvNumber)
        TextView tvNumber;
        @InjectView(R.id.tvDate)
        TextView tvDate;
        ViewHolder(View parent) {
            ButterKnife.inject(this, parent);
        }
    }

}
