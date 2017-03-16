package cpf.com.testlauncher.test_pull2refresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/16.
 */

public class TestPull2RefreshActivity extends Activity{

    private PullToRefreshListView listView;

    private List<String> list;

    private TestRefreshAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_pull2refresh_layout);
        listView = (PullToRefreshListView)findViewById(R.id.test_pull2refresh);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        list = new ArrayList<String>();
        init();
        adapter = new TestRefreshAdapter(list,TestPull2RefreshActivity.this);
        listView.setAdapter(adapter);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                updataList(0);
                new Handler().postDelayed(new Runnable(){

                    public void run() {
                        listView.onRefreshComplete();
                    }
                }, 1000);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                updataList(1);
                new Handler().postDelayed(new Runnable(){

                    public void run() {

                        listView.onRefreshComplete();

                    }
                }, 1000);
            }
        });
    }

    private void init() {
        ILoadingLayout startLabels = listView
                .getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
        startLabels.setRefreshingLabel("正在载入...");// 刷新时
        startLabels.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示

        ILoadingLayout endLabels = listView.getLoadingLayoutProxy(
                false, true);
        endLabels.setPullLabel("上拉刷新...");// 刚下拉时，显示的提示
        endLabels.setRefreshingLabel("正在载入...");// 刷新时
        endLabels.setReleaseLabel("放开刷新...");// 下来达到一定距离时，显示的提示

    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {//ViewPager中设置listener,当滑动到该页面时调用onResume方法
            @Override
            public void run() {
                listView.setRefreshing();
//                intData();
            }
        }, 500);

    }

    private void updataList(int i) {

        if(i == 0){
            list.add("26");
            list.add("27");
            list.add("28");
            list.add("29");
            list.add("30");
        }else{
            list.add("36");
            list.add("37");
            list.add("38");
            list.add("39");
            list.add("40");
        }
        adapter.setList(list);
        adapter.notifyDataSetChanged();


    }

    private void intData() {

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }
}
