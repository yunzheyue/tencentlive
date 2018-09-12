package com.example.app6;

import com.tencent.ilivesdk.ILiveCallBack;
import com.tencent.ilivesdk.core.ILiveRoomManager;
import com.tencent.ilivesdk.core.ILiveRoomOption;
import com.tencent.ilivesdk.view.AVRootView;

public class RoomHelper implements ILiveRoomOption.onExceptionListener, ILiveRoomOption.onRoomDisconnectListener {
    private IRoomView roomView;

    public RoomHelper(IRoomView view){
        roomView = view;
    }
    // 设置渲染控件
    public void setRootView(AVRootView avRootView){
        ILiveRoomManager.getInstance().initAvRootView(avRootView);
    }
    // 创建房间
    public int createRoom(int roomId){
        ILiveRoomOption option = new ILiveRoomOption()
                .privateMapKey("123")   // 进房票据
                .imsupport(false)       // 不需要IM功能
                .exceptionListener(this)  // 监听异常事件处理
                .roomDisconnectListener(this)   // 监听房间中断事件
                .controlRole("user")    // 使用user角色
                .autoCamera(true)       // 进房间后自动打开摄像头并上行
                .autoMic(true);         // 进房间后自动要开Mic并上行

        return ILiveRoomManager.getInstance().createRoom(roomId, option, new ILiveCallBack() {
            @Override
            public void onSuccess(Object data) {
                roomView.onEnterRoom();
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                roomView.onEnterRoomFailed(module, errCode, errMsg);
            }
        });
    }
    // 退出房间
    public int quitRoom(){
        return ILiveRoomManager.getInstance().quitRoom(new ILiveCallBack() {
            @Override
            public void onSuccess(Object data) {
                roomView.onQuitRoomSuccess();
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                roomView.onQuitRoomFailed(module, errCode, errMsg);
            }
        });
    }

    // 处理Activity事件
    public void onPause(){
        ILiveRoomManager.getInstance().onPause();
    }
    public void onResume(){
        ILiveRoomManager.getInstance().onResume();
    }

    @Override
    public void onException(int exceptionId, int errCode, String errMsg) {
        //处理异常事件
    }

    @Override
    public void onRoomDisconnect(int errCode, String errMsg) {
        // 处理房间中断(一般为断网或长时间无长行后台回收房间)
    }
}