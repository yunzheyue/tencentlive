package com.example.app6;

import android.app.Application;
import android.provider.SyncStateContract;

import com.tencent.ilivesdk.ILiveSDK;
import com.tencent.ilivesdk.core.ILiveRoomConfig;
import com.tencent.ilivesdk.core.ILiveRoomManager;
import com.tencent.qalsdk.sdk.MsfSdkUtils;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 判断仅在主线程进行初始化
        if (MsfSdkUtils.isMainProcess(this)) {
            // 初始化iLiveSDK
//            ILiveSDK.getInstance().initSdk(this, SyncStateContract.Constants.SDKAPPID, SyncStateContract.Constants.ACCOUNTTYPE);
            ILiveSDK.getInstance().initSdk(this, 1400137962, 38390);
            // 初始化iLiveSDK房间管理模块
            ILiveRoomManager.getInstance().init(new ILiveRoomConfig());
        }
    }
}
