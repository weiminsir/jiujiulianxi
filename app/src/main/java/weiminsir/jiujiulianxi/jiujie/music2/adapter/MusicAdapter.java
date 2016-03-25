package weiminsir.jiujiulianxi.jiujie.music2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import weiminsir.jiujiulianxi.R;
import weiminsir.jiujiulianxi.jiujie.music2.entity.Music;

/**
 * Created by Weimin on 2016/3/11.
 */
public class MusicAdapter extends BaseAdapter {
    private Context context;
    private List<Music> data;
    private LayoutInflater inflater;

    public MusicAdapter(Context context, List<Music> data) {
        setContext(context);
        setData(data);
        inflater = LayoutInflater.from(context);
    }

    public void setContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("参数Context不允许为null！！！");
        }
        this.context = context;
    }

    public void setData(List<Music> data) {
        if (data == null) {
            data = new ArrayList<Music>();
        }
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.music_item, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.tv_music_item_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Music music = data.get(position);

        holder.title.setText(music.getTitle());

        return convertView;
    }

    private class ViewHolder {
        TextView title;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
