package sportiveapp.compubase.com.sportiveapp.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import sportiveapp.compubase.com.sportiveapp.ui.fragment.ActivitiesFragment;
import sportiveapp.compubase.com.sportiveapp.ui.fragment.FamousFragment;
import sportiveapp.compubase.com.sportiveapp.ui.fragment.HomeFragment;

public class VP_HomeUser  extends FragmentPagerAdapter {

    Fragment[] fragments ={new HomeFragment(),new FamousFragment(),new ActivitiesFragment()};

    String title;

    public VP_HomeUser(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                title = "Home";
                break;
            case 1:
                title =  "Famous";
                break;
            case 2:
                title = "Activities";
                break;

        }
        return title;
    }
}
