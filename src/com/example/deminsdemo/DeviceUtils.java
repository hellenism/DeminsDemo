
package com.example.deminsdemo;

import android.content.Context;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

/**
 * 有些设备获取屏幕分辨率时，并非有效尺寸，所以使用DeviceUtils进行适配
 * 
 * @author Stephen Lee
 */
public class DeviceUtils {

    public static List<DeviceInfo> sSpecialDeviceList = new ArrayList<DeviceInfo>();
    public static DeviceInfo sDeviceInfo;

    static {
        sDeviceInfo = new DeviceInfo();
        sDeviceInfo.BRAND = android.os.Build.BRAND;
        sDeviceInfo.DEVICE = android.os.Build.DEVICE;
        sDeviceInfo.MODEL = android.os.Build.MODEL;
        sDeviceInfo.PRODUCT = android.os.Build.PRODUCT;
    }

    // ------ public ------
    
    /**
     * 获取屏幕的有效宽高
     * 
     * @param context
     * @return
     */
    public static int getAvailableScreenWidthPixels(Context context)
    {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕的有效宽高
     * 
     * @param context
     * @return
     */
    public static int getAvailableScreenHeightPixels(Context context)
    {
        int heightPixels = 0;
        heightPixels = getAvailableHeightPixelsFromDiffDevice(context);
        return heightPixels;
    }

    // ------ private ------
    /**
     * 是否为魅族MX2
     * 
     * @return
     */
    private static boolean isMeiZuMX2()
    {
        String meizuFlag = "meizu_mx2";
        boolean result = false;
        if (meizuFlag.equals(sDeviceInfo.PRODUCT))
        {
            result = true;
        }
        return result;
    }

    private static int getAvailableHeightPixelsFromDiffDevice(Context context)
    {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int heightPixels = dm.heightPixels;
        if (isMeiZuMX2())
        {
            heightPixels = heightPixels - (int) (dm.density * 48);
        }
        return heightPixels;
    }
}
