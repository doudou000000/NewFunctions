package cpf.com.testlauncher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/10.
 */
public class TestCollapsingToolBarLayout extends AppCompatActivity{

    CollapsingToolbarLayout ctl;

    Toolbar tb;

    DrawerLayout dl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_collapsing_tool_bar_layout);
        tb = (Toolbar)findViewById(R.id.test_toolbar);
        dl = (DrawerLayout)findViewById(R.id.test_collapsing_navigat_dl);
        tb.setNavigationIcon(R.mipmap.navigat_menu_white);
        tb.inflateMenu(R.menu.test_toolbar_menu);
        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_add:
                        Toast.makeText(TestCollapsingToolBarLayout.this,"我是添加",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_search:
                        Toast.makeText(TestCollapsingToolBarLayout.this,"我是搜索",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(TestCollapsingToolBarLayout.this,"我是分享",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.openDrawer(Gravity.LEFT);
            }
        });
        ctl = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ctl.setTitle("cheeseName");
        //设置CollapsingToolbarLayout扩张时的标题颜色
        ctl.setExpandedTitleColor(Color.BLACK);
        //设置CollapsingToolbarLayout收缩时的标题颜色
        ctl.setCollapsedTitleTextColor(Color.WHITE);
    }
}
