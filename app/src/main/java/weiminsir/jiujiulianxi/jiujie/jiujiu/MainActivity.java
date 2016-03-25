package weiminsir.jiujiulianxi.jiujie.jiujiu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import weiminsir.jiujiulianxi.R;

public class MainActivity extends Activity {

    MyAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        ListView listView = (ListView) findViewById(R.id.list);
        NetRequest.APIInstance.getHotKinkList().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<NKinkList>() {
            @Override
            public void call(NKinkList nKinkList) {
                adapter.setDataList(nKinkList.results);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
            }
        });
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter {
        private List<NKink> mDataList;

        public void setDataList(List<NKink> dataList) {
            mDataList = dataList;
            notifyDataSetChanged();
        }

        public List<NKink> getDataList() {
            return mDataList;
        }

        @Override
        public int getCount() {
            return mDataList == null ? 0 : mDataList.size();
        }

        @Override
        public Object getItem(int position) {
            return position + ":position";
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_listview, parent, false);
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.content1 = (TextView) convertView.findViewById(R.id.content1);
                holder.content2 = (TextView) convertView.findViewById(R.id.content2);
                holder.content3 = (TextView) convertView.findViewById(R.id.content3);
                holder.content4 = (TextView) convertView.findViewById(R.id.content4);
                holder.display1 = (ImageView) convertView.findViewById(R.id.dispaly1);
                holder.display2 = (ImageView) convertView.findViewById(R.id.dispaly2);
                holder.display3 = (ImageView) convertView.findViewById(R.id.dispaly3);
                holder.display4 = (ImageView) convertView.findViewById(R.id.dispaly4);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            NKink kink = mDataList.get(position);
            holder.title.setText(kink.kink_content);
//            if (kink.kink_questions != null && kink.kink_questions.size() > 0 &&
//                    !TextUtils.isEmpty(kink.kink_questions.get(0).question_picture)) {
//                Picasso.with(listViewTest.this).load(kink.kink_questions.get(0).question_picture_min).into(holder.display1);
//            }
//            if (kink.kink_questions != null && kink.kink_questions.size() > 0 && !TextUtils.isEmpty(kink.kink_questions.get(1).question_picture)) {
//                Picasso.with(listViewTest.this).load(kink.kink_questions.get(1).question_picture_min).into(holder.display2);
//            }
//            if (kink.kink_questions != null && kink.kink_questions.size() > 0 && !TextUtils.isEmpty(kink.kink_questions.get(2).question_picture)) {
//                Picasso.with(listViewTest.this).load(kink.kink_questions.get(2).question_picture_min).into(holder.display3);
//            }
//            if (kink.kink_questions != null && kink.kink_questions.size() > 0 && !TextUtils.isEmpty(kink.kink_questions.get(3).question_picture)) {
//                Picasso.with(listViewTest.this).load(kink.kink_questions.get(3).question_picture_min).into(holder.display4);
//            }
            return convertView;
        }

        class ViewHolder {
            TextView title;
            TextView content1;
            TextView content2;
            TextView content3;
            TextView content4;
            ImageView display1;
            ImageView display2;
            ImageView display3;
            ImageView display4;
        }
    }
}
