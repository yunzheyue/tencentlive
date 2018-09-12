package com.example.app6;

public interface ILoginView {
    // 登录成功
    void onLoginSDKSuccess();
    // 登录失败
    void onLoginSDKFailed(String module, int errCode, String errMsg);
}