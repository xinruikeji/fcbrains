package com.fcbrains.xinruikeji;

import android.app.Application;
import android.util.DisplayMetrics;

import com.fcbrains.xinruikeji.uitls.ScreenUtils;

/**
 * Created by lizhanfeng on 2016/5/5.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        screenSize();
    }
    private void screenSize() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        ScreenUtils.screenWidth = dm.widthPixels;
        ScreenUtils.screenHeight = dm.heightPixels;
    }
}
