package cpf.com.testlauncher.tab_layout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cpf.com.testlauncher.R;
import cpf.com.testlauncher.tab_layout.MyViewPageAdapter;
import cpf.com.testlauncher.tab_layout.TestTabFragment;

/**
 * Created by Administrator on 2017/2/10.
 */
public class TestTabLayoutActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager viewPager;

    MyViewPageAdapter myViewPageAdapter;

    List<Fragment> fragmentList;

    List<String> tabTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_tab_layout);
        try{
            initData();
            initView();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initData() {

        tabTitleList = new ArrayList<String>();
        tabTitleList.add("首页");
        tabTitleList.add("推荐");
        tabTitleList.add("新闻");

        fragmentList = new ArrayList<Fragment>();

        for(int i = 0; i < tabTitleList.size(); i++){
            fragmentList.add(TestTabFragment.newInstance(i));
        }
        myViewPageAdapter = new MyViewPageAdapter(getSupportFragmentManager(),fragmentList,tabTitleList);

    }

    private void initView() {

        tabLayout = (TabLayout)findViewById(R.id.test_tab_layout_tl);

        viewPager = (ViewPager)findViewById(R.id.test_tab_layout_vp);

        viewPager.setAdapter(myViewPageAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }
}
