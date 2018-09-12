package com.example.app6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tencent.ilivesdk.core.ILiveLoginManager;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private LoginHelper loginHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginHelper = new LoginHelper(this);
        Button bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginHelper.loginSDK("Android_trtc_01", "eJxlj0FPgzAAhe-8CsJVoy2llJl4cLgsU7ZBNjTh0lRaakcorFSDGv*7iksk8V2-L*-lfTiu63r7ZHfByrJ90Zbat0547pXrAe-8D3ad4pRZigz-B8XQKSMoq6wwI4QYYx*AqaO40FZV6mTcaG7a70ZrbEkBnIg9r*m49tsUAAARmYX*VFFyhOtFHq*yuLqzuWgy2S6PUb6ZR2KAj3qJutsjC-w8WBT9ULOnkBzSbCX3TZKqSmLD33vJLhG5l*0W1vG82JzNimiXguShOjxDsl1fTyatasTpGgoJIhijCX0VpletHgUfQAx9BH7iOZ-OF4VFYEU_");
            }
        });
    }

    @Override
    public void onLoginSDKSuccess() {
        ILiveLoginManager.getInstance().setUserStatusListener(StatusObservable.getInstance());
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onLoginSDKFailed(String module, int errCode, String errMsg) {

    }
}
