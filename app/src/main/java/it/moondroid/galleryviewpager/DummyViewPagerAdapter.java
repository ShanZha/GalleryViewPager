package it.moondroid.galleryviewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bwbuser on 21/05/2015.
 */
public class DummyViewPagerAdapter extends PagerAdapter {

    private Context context;

    public DummyViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView view = new TextView(context);
        view.setText("View " + position);
        view.setGravity(Gravity.CENTER);
        //view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));
        view.setBackgroundColor(Color.WHITE);
        view.setTextColor(context.getResources().getColor(android.R.color.darker_gray));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}

