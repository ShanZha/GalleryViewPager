package it.moondroid.galleryviewpagerlibrary;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import it.moondroid.galleryviewpagerlibrary.transformer.ZoomOutSlideTransformer;

/**
 * PagerContainer: A layout that displays a ViewPager with its children that are outside
 * the typical pager bounds.
 */
public class GalleryViewPager extends LinearLayout implements ViewPager.OnPageChangeListener {

    private ViewPager mPager;
    boolean mNeedsRedraw = false;

    public GalleryViewPager(Context context) {
        super(context);
        init();
    }

    public GalleryViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GalleryViewPager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.galleryviewpager_layout, this);
        setWeightSum(3.0f);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);

        //Disable clipping of children so non-selected pages are visible
        setClipChildren(false);

        //Child clipping doesn't work with hardware acceleration in Android 3.x/4.x
        //You need to set this value here if using hardware acceleration in an
        // application targeted at these releases.
        //setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        setLayerType(View.LAYER_TYPE_HARDWARE, null);

        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setOnPageChangeListener(this);

        //Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        mPager.setOffscreenPageLimit(5);
        //A little space between pages
        mPager.setPageMargin(15);

        //If hardware acceleration is enabled, you should also remove
        // clipping on the pager for its children.
        mPager.setClipChildren(false);

        mPager.setPageTransformer(true, new ZoomOutSlideTransformer());
    }


    public ViewPager getViewPager() {
        return mPager;
    }

    public void setAdapter(PagerAdapter adapter){
        mPager.setAdapter(adapter);
    }

    private Point mCenter = new Point();

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCenter.x = w / 2;
        mCenter.y = h / 2;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //We capture any touches not already handled by the ViewPager
        // to implement scrolling from a touch outside the pager bounds.

        ev.setLocation(getXRelativeToPager(ev.getX()), ev.getY());

        return mPager.dispatchTouchEvent(ev);
    }

    private float getXRelativeToPager(float x){
        float pagerWidth = mPager.getWidth();
        float totalWidth = getWidth();
        float outsideWidth = (totalWidth - pagerWidth) / 2f;

        return x - outsideWidth;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //Force the container to redraw on scrolling.
        //Without this the outer pages render initially and then stay static
        if (mNeedsRedraw) invalidate();
    }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) {
        mNeedsRedraw = (state != ViewPager.SCROLL_STATE_IDLE);
    }
}