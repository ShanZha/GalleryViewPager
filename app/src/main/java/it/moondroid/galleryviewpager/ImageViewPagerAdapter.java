package it.moondroid.galleryviewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bwbuser on 21/05/2015.
 */
public class ImageViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<String> data = new ArrayList<>();

    public ImageViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.view_item_image, null);
        container.addView(view);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        Glide.with(context)
                .load(data.get(position))
                .into(imageView);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    public void setData(List<String> data){
        this.data = data;
        notifyDataSetChanged();
    }
}

