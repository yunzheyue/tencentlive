package com.example.app6;

import com.tencent.ilivesdk.ILiveCallBack;
import com.tencent.ilivesdk.core.ILiveLoginManager;

public class LoginHelper {
    private ILoginView loginView;

    public LoginHelper(ILoginView view){
        loginView = view;
    }

    public void loginSDK(String userId, String userSig){
        ILiveLoginManager.getInstance().iLiveLogin(userId, userSig, new ILiveCallBack() {
            @Override
            public void onSuccess(Object data) {
                loginView.onLoginSDKSuccess();
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                loginView.onLoginSDKFailed(module, errCode, errMsg);
            }
        });
    }
}