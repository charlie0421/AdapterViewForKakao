package com.ironlove.adapterviewforkakao;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.kakao_logo)
                .showImageOnFail(R.drawable.loading_fail)
                .showImageForEmptyUri(R.drawable.loading_fail)
                .cacheInMemory(false)
                .cacheOnDisk(false)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(options)
                .build();
        ImageLoader.getInstance().init(config);

    }
}
