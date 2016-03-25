package weiminsir.jiujiulianxi.jiujie.words;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weimin on 2016/3/12.
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

    protected Context context;
    protected LayoutInflater mLayoutInflater;
    protected List<T> dataList;

    public BaseListAdapter(Context context, List<T> dataList) {
        if (context == null) {
            throw new IllegalArgumentException("参数context不能为空");
        }
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.dataList = dataList;
    }


    public List<T> getDataList() {
        return getDataList();
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }
}
