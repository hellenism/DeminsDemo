
package com.example.deminsdemo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private LinearLayout mLyNewsContainer;
    private LinearLayout mLyDecorationContainer;
    private LinearLayout mLyNewsIntroArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colourful2);

        DisplayMetrics dm = getResources().getDisplayMetrics();

        // 强转是去尾法
        float testFloat = 0.6f;
        Log.d("liyasi", "testFloat:" + (int) testFloat);
        Log.d("liyasi", "screen width:" + dm.widthPixels);
        Log.d("liyasi", "screen height:" + dm.heightPixels);

        Log.d("liyasi", "MODEL:" + android.os.Build.MODEL);
        Log.d("liyasi", "BRAND:" + android.os.Build.BRAND);
        Log.d("liyasi", "DEVICE:" + android.os.Build.DEVICE);
        Log.d("liyasi", "PRODUCT:" + android.os.Build.PRODUCT);

        View view = findViewById(R.id.indicator_placeholder);
        ViewsUtils.setHeight(
                this,
                view,
                getResources().getDimensionPixelSize(
                        R.dimen.new_colourful_bottom_place_holder_height));

        mLyNewsIntroArea = (LinearLayout) findViewById(R.id.lly_news_intro_area);
        ViewsUtils.setMargins(this, mLyNewsIntroArea, 0, 0, 0, getResources()
                .getDimensionPixelSize(
                        R.dimen.new_colourful_intro_area_margin_bottom));

        ViewsUtils.setHeight(this, mLyNewsIntroArea,
                getResources().getDimensionPixelSize(R.dimen.new_colourful_intro_area_height));

        mLyDecorationContainer = (LinearLayout) findViewById(R.id.decoration_container);
        ViewsUtils.setMargins(this, mLyDecorationContainer, 0, getResources()
                .getDimensionPixelSize(
                        R.dimen.new_colourful_deco_image_margin_top), 0, 0);

        mLyNewsContainer = (LinearLayout) findViewById(R.id.news_container);
        ViewsUtils.setMargins(this, mLyNewsContainer, 0, getResources()
                .getDimensionPixelSize(
                        R.dimen.new_colourful_news_image_margin_top), 0, 0);

        Point newsContainerOfPoint = BitmapUtils.getBitmapWidthHeightByReferentSzie(this,
                R.drawable.colourful_news_1,
                720f, 1280f);
        mLyNewsContainer.getLayoutParams().height = newsContainerOfPoint.y;
        mLyNewsContainer.getLayoutParams().width = newsContainerOfPoint.x;

        Point decoContainerOfPoint = BitmapUtils.getBitmapWidthHeightByReferentSzie(this,
                R.drawable.col_deco_1, 720f, 1280f);
        mLyDecorationContainer.getLayoutParams().height = decoContainerOfPoint.y;
        mLyDecorationContainer.getLayoutParams().width = decoContainerOfPoint.x;
    }
}
