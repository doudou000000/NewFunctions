package cpf.com.testlauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cpf.com.testlauncher.custom_view.TestPathActivity;

public class MainActivity extends AppCompatActivity {

    private List<ResolveInfo> apps;

    private GridView appGv;

    AppsAdapter appAdapter;

    Button btn,newFunctionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appGv = (GridView) findViewById(R.id.app_gv);
        btn = (Button)findViewById(R.id.button);
        newFunctionBtn = (Button)findViewById(R.id.test_android_new_function_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestPathActivity.class);
                startActivity(intent);
            }
        });
        appAdapter = new AppsAdapter();
        loadApps();
        appGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ResolveInfo info = apps.get(position);
                //包名
                String packageName = info.activityInfo.packageName;
                //类名
                String cls = info.activityInfo.name;
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(packageName,cls);
                intent.setComponent(componentName);
                //启动指定的程序
                startActivity(intent);
            }
        });
        newFunctionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestNewFunctionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadApps() {

        Intent intent = new Intent(Intent.ACTION_MAIN,null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        apps = getPackageManager().queryIntentActivities(intent,0);
        appGv.setAdapter(appAdapter);
    }


    public class AppsAdapter extends BaseAdapter {

        public AppsAdapter(){
        }

        @Override
        public int getCount() {
            return apps.size();
        }

        @Override
        public Object getItem(int i) {
            return apps.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if(view == null){
                holder = new ViewHolder();
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.gv_item_layout,null);
                holder.iv = (ImageView)view.findViewById(R.id.gv_item_iv);
                holder.tv = (TextView) view.findViewById(R.id.gv_item_tv);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            ResolveInfo info = apps.get(i);
            holder.tv.setText(info.loadLabel(getPackageManager()).toString());
            holder.iv.setImageDrawable(info.activityInfo.loadIcon(getPackageManager()));
            return view;
        }
    }

    class  ViewHolder{

        ImageView iv;
        TextView tv;

    }

}
