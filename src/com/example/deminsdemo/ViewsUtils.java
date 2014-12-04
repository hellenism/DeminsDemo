
package com.example.deminsdemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 用于做多分辨率适配
 * 
 * @author liyasi
 */
public class ViewsUtils {
    private static final float sDesignWidth = 720f;
    private static final float sDesignHeight = 1280f;

    /**
     * 设置宽
     * 
     * @param context
     * @param view
     * @param size
     */
    public static void setWidth(Context context, View view, int size)
    {
        ViewGroup.MarginLayoutParams lp = getLayoutParams(view);
        float scaleWidthRate = size / sDesignWidth;
        Log.d("liyasi", "scaleWidthRate:" + scaleWidthRate);
        lp.width = getTragetPxForScreenWidth(context, scaleWidthRate);
        view.setLayoutParams(lp);
    }

    /**
     * 设置高
     * 
     * @param context
     * @param view
     * @param size
     */
    public static void setHeight(Context context, View view, int size)
    {
        ViewGroup.MarginLayoutParams lp = getLayoutParams(view);
        float scaleHeightRate = size / sDesignHeight;
        Log.d("liyasi", "scaleHeightRate:" + scaleHeightRate);
        lp.height = getTragetPxForScreenHeight(context, scaleHeightRate);
        view.setLayoutParams(lp);
    }

    /**
     * 设置margins
     * 
     * @param context
     * @param view
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public static void setMargins(Context context, View view, int left, int top, int right,
            int bottom)
    {
        ViewGroup.MarginLayoutParams lp = getLayoutParams(view);

        float scaleLeft = left / sDesignWidth;
        float scaleRight = right / sDesignWidth;
        float scaleTop = top / sDesignHeight;
        float scaleBottom = bottom / sDesignHeight;

        int targetLeft = getTragetPxForScreenWidth(context, scaleLeft);
        int targetRight = getTragetPxForScreenWidth(context, scaleRight);
        int targetTop = getTragetPxForScreenHeight(context, scaleTop);
        int targetBottom = getTragetPxForScreenHeight(context, scaleBottom);

        lp.leftMargin = targetLeft;
        lp.rightMargin = targetRight;
        lp.topMargin = targetTop;
        lp.bottomMargin = targetBottom;
    }

    /**
     * 获取当前view的LayoutParams
     * 
     * @param view 当前View
     * @return
     */
    public static ViewGroup.MarginLayoutParams getLayoutParams(View view)
    {
        View parentView = (View) view.getParent();
        ViewGroup.MarginLayoutParams lp = null;
        if (parentView.getClass() == LinearLayout.class)
        {
            LinearLayout.LayoutParams source = (LinearLayout.LayoutParams) view.getLayoutParams();
            lp = source;
        }
        else if (parentView.getClass() == RelativeLayout.class)
        {
            RelativeLayout.LayoutParams source = (RelativeLayout.LayoutParams) view
                    .getLayoutParams();
            lp = source;
        }

        return lp;
    }

    public static int getTragetPxForScreenWidth(Context context, float rate)
    {
        int result = 0;
        int screenWidth = DeviceUtils.getAvailableScreenWidthPixels(context);;
        result = (int) (screenWidth * rate);
        // Log.d("liyasi", "getTragetPxForScreenWidth:" + result);
        return result;
    }

    public static int getTragetPxForScreenHeight(Context context, float rate)
    {
        int result = 0;
        int screenHeight = DeviceUtils.getAvailableScreenHeightPixels(context);// context.getResources().getDisplayMetrics().heightPixels;
        result = (int) (screenHeight * rate);
        // Log.d("liyasi", "getTragetPxForScreenHeight:" + result);
        return result;
    }
}
