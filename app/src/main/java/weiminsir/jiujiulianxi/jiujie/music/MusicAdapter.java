package weiminsir.jiujiulianxi.jiujie.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import weiminsir.jiujiulianxi.R;

/**
 * Created by Weimin on 2016/3/10.
 */
public class MusicAdapter extends BaseAdapter {
    private Context mContext;
    private List<Music> dataList;

    public MusicAdapter(Context context, List<Music> dataList) {
        mContext = context;
        this.dataList = dataList;

    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Music music = dataList.get(i);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.music_item, null);
        TextView title = (TextView) view.findViewById(R.id.tv_music_item_title);
        title.setText(music.getTitle());
        return view;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return dataList==null? 0:dataList.size();
    }
}
