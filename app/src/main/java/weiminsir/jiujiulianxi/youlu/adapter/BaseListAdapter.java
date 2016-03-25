package weiminsir.jiujiulianxi.youlu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import weiminsir.jiujiulianxi.R;

/**
 * Created by Weimin on 2016/3/14.
 */
public class BaseListAdapter<T> extends BaseAdapter {
    protected List<T> dataList;
    protected LayoutInflater mLayoutInflater;
    protected Context context;

    public List<T> getDataList() {
        return dataList;
    }

    public BaseListAdapter(Context context) {
        if (context != null) {
            this.context = context;
            mLayoutInflater = LayoutInflater.from(context);
        }
    }

    public BaseListAdapter(Context context, List<T> dataList) {
        this(context);
        if (dataList != null) {
            this.dataList = dataList;
            notifyDataSetChanged();
        }
    }


    public void setDataList(List<T> dataList) {
        if (dataList != null) {
            this.dataList = dataList;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    protected int[] icons = {R.mipmap.icon_1,R.mipmap.icon_2,R.mipmap.icon_3,R.mipmap.icon_4,R.mipmap.icon_5,
            R.mipmap.icon_6,R.mipmap.icon_7,R.mipmap.icon_8,R.mipmap.icon_9,R.mipmap.icon_10};


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        return convertView;
    }
}
