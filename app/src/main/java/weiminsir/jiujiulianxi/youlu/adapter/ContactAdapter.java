package weiminsir.jiujiulianxi.youlu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.youlu.entity.Contact;

/**
 * Created by Weimin on 2016/3/14.
 */
public class ContactAdapter extends BaseListAdapter<Contact> {
//    private ImageLoader imageLoader;
    public ContactAdapter(Context context,List<Contact> contactList) {
        super(context,contactList);
//        imageLoader = new ImageLoader(context, gridView);
    }




    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_gv_contact, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        if (position == 0) {
            holder.ivPhoto.setImageResource(R.drawable.img02_07);
            holder.tvName.setText("添加联系人");
            return convertView;
        }
//        Contact contact = (Contact)getItem(position);
        holder.tvName.setText("姓名");
        holder.ivPhoto.setImageResource(icons[position]);
//        imageLoader.displayImage(holder.ivPhoto, contact.getPhotoId(), position);
        return convertView;
    }

    class ViewHolder{
        @InjectView(R.id.ivPhoto)
        ImageView ivPhoto;
        @InjectView(R.id.tvName)
        TextView tvName;
        ViewHolder(View parent){
            ButterKnife.inject(this,parent);
        }
    }
}
