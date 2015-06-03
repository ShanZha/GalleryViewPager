package it.moondroid.galleryviewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.galleryviewpagerlibrary.ReflectionTransformation;

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
    public Object instantiateItem(ViewGroup container, final int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.view_item_image, null);
        container.addView(view);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        Glide.with(context)
                .load(data.get(position))
                .bitmapTransform(new ReflectionTransformation(Glide.get(context).getBitmapPool()))
                .into(imageView);

        view.findViewById(R.id.image_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item " + position, Toast.LENGTH_SHORT).show();
            }
        });

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

