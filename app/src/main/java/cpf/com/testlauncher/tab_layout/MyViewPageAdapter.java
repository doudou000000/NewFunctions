package cpf.com.testlauncher.tab_layout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */
public class MyViewPageAdapter extends FragmentPagerAdapter{

    List<Fragment> fragmentList;

    List<String> tabTitleList;

    public MyViewPageAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabTitleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabTitleList = tabTitleList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
}
