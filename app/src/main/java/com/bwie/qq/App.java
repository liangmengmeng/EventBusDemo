package com.bwie.qq;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * autour: 梁萌萌
 * date: 2016/12/6 20:00 
 * update: 2016/12/6
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }

    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");


    }
}
