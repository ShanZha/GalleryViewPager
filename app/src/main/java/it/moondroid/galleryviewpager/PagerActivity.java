/*
 * Copyright (c) 2012 Wireless Designs, LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package it.moondroid.galleryviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.galleryviewpagerlibrary.GalleryViewPager;

/**
 * PagerActivity: A Sample Activity for PagerContainer
 */
public class PagerActivity extends AppCompatActivity {

    private static List<String> items = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            items.add("http://lorempixel.com/500/500/animals/" + i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GalleryViewPager pager = (GalleryViewPager) findViewById(R.id.gallery);

        //FragmentStatePagerAdapter adapter = new DummyFragmentPagerAdapter(getSupportFragmentManager());
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter(this);
        adapter.setData(items);

        pager.setAdapter(adapter);
    }

}