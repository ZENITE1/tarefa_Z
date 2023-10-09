package ao.znt.tarefasz.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ao.znt.tarefasz.fragment.TextFrag;

public class FragAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    public FragAdapter(FragmentManager fm){
        super(fm);
    }

    public void add(Fragment fragment, String title){
        this.fragments.add(fragment);
        this.titles.add(title);

    }
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
