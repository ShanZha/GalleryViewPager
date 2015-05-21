package it.moondroid.galleryviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by bwbuser on 21/05/2015.
 */
public class DummyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    public DummyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return DummyFragment.newInstance("Fragment "+i);
    }


    @Override
    public int getCount() {
        return 5;
    }

}
