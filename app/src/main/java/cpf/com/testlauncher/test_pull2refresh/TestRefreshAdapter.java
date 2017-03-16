package cpf.com.testlauncher.test_pull2refresh;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/16.
 */

public class TestRefreshAdapter extends BaseAdapter{

    private List<String> list;

    private Context context;

    public TestRefreshAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setList(List<String> list){
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler = null;
        if(convertView == null){
            hodler = new ViewHodler();
            convertView = LayoutInflater.from(context).inflate(R.layout.test_pull2refresh_item_layout,null);
            hodler.textView = (TextView)convertView.findViewById(R.id.test_pull2refresh_item_tv);
            convertView.setTag(hodler);
        }else{
            hodler = (ViewHodler) convertView.getTag();
        }

        hodler.textView.setText(list.get(position));

        return convertView;
    }

    class ViewHodler{

        TextView textView;

    }

}
