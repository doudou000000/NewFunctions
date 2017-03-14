package cpf.com.testlauncher;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/10.
 */
public class TestNavigationViewActivity extends AppCompatActivity{


    DrawerLayout dl;

    NavigationView nv;
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_navication_view_layout);

        tb = (Toolbar)findViewById(R.id.toolbar);

        tb.setTitle("");


        tb.setNavigationIcon(R.mipmap.navigat_menu_white);
        tb.inflateMenu(R.menu.test_toolbar_menu);
//        setSupportActionBar(tb);



        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_add:
                        Toast.makeText(TestNavigationViewActivity.this,"我是添加",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_search:
                        Toast.makeText(TestNavigationViewActivity.this,"我是搜索",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(TestNavigationViewActivity.this,"我是分享",Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

        dl = (DrawerLayout)findViewById(R.id.test_navigat_dl);



        nv = (NavigationView)findViewById(R.id.test_navigat_nv);

        nv.setItemIconTintList(null);

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.openDrawer(GravityCompat.START);
            }
        });

        View headerView = nv.getHeaderView(0);

        ImageView imageView = (ImageView)headerView.findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestNavigationViewActivity.this,"我是头部",Toast.LENGTH_SHORT).show();
            }
        });

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.open:
                        Toast.makeText(TestNavigationViewActivity.this,"打开",Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.close:
                        Toast.makeText(TestNavigationViewActivity.this,"关闭",Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
        dl.setDrawerListener(new DrawerLayout.DrawerListener() {
            /**
             * 当抽屉滑动状态改变的时候被调用
             * 状态值是STATE_IDLE（闲置--0）, STATE_DRAGGING（拖拽的--1）, STATE_SETTLING（固定--2）中之一。
             * 抽屉打开的时候，点击抽屉，drawer的状态就会变成STATE_DRAGGING，然后变成STATE_IDLE
             */
            @Override
            public void onDrawerStateChanged(int arg0) {
                Log.i("drawer", "drawer的状态：" + arg0);
            }
            /**
             * 当抽屉被滑动的时候调用此方法
             * arg1 表示 滑动的幅度（0-1）
             */
            @Override
            public void onDrawerSlide(View arg0, float arg1) {
                Log.i("drawer", arg1 + "");
            }
            /**
             * 当一个抽屉被完全打开的时候被调用
             */
            @Override
            public void onDrawerOpened(View arg0) {
                Log.i("drawer", "抽屉被完全打开了！");
            }
            /**
             * 当一个抽屉完全关闭的时候调用此方法
             */
            @Override
            public void onDrawerClosed(View arg0) {
                Log.i("drawer", "抽屉被完全关闭了！");
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.test_toolbar_menu, menu);
//        return true;
//    }
}
