package com.example.app6;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tencent.TIMManager;
import com.tencent.av.sdk.AVContext;
import com.tencent.ilivesdk.ILiveSDK;
import com.tencent.ilivesdk.view.AVRootView;

public class MainActivity extends AppCompatActivity implements IRoomView {
    private RoomHelper roomHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roomHelper = new RoomHelper(this);
// 获取渲染控件
        AVRootView avRootView = findViewById(R.id.av_root_view);
// 设置没有渲染时的背景色为蓝色(注意不支持在布局中直接设置)
        avRootView.getVideoGroup().setBackgroundColor(Color.BLUE);
// 设置渲染控件
        roomHelper.setRootView(avRootView);

       Button bt_create = findViewById(R.id.bt_create);
        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomHelper.createRoom(1234);
            }
        });
    }

    @Override
    public void onEnterRoom() {

    }

    @Override
    public void onEnterRoomFailed(String module, int errCode, String errMsg) {

    }

    @Override
    public void onQuitRoomSuccess() {

    }

    @Override
    public void onQuitRoomFailed(String module, int errCode, String errMsg) {

    }

    @Override
    public void onRoomDisconnect(String module, int errCode, String errMsg) {

    }
}
