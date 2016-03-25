package weiminsir.jiujiulianxi.jiujie.words;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

/**
 * Created by Weimin on 2016/3/12.
 */
public class WordAdapter extends BaseListAdapter<Word> {
    public WordAdapter(Context context,List<Word> dataList) {
        super(context,dataList);
    }
    @Override
    public View getView(int pos, View covertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (covertView == null) {
            covertView = mLayoutInflater.inflate(R.layout.word_item, viewGroup, false);
            holder = new ViewHolder(covertView);
            covertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)covertView.getTag();
        }
        holder.en.setText(getDataList().get(pos).getEn());
        holder.zh.setText(getDataList().get(pos).getZh());
        return covertView;
    }


    class ViewHolder {
        @InjectView(R.id.tv_word_item_en)
        TextView en;
        @InjectView(R.id.tv_word_item_zh)
        TextView zh;
        ViewHolder(View parent) {
            ButterKnife.inject(this, parent);
        }
    }
}
