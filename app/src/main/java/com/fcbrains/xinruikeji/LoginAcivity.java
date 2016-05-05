package com.fcbrains.xinruikeji;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;


public class LoginAcivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MyLogUtils.syso("进入LogActivity");
        initUI();
    }
    private void initUI() {

        Button mWeiXin = (Button) findViewById(R.id.bt_weixin);
        mWeiXin.setOnClickListener(this);
        findViewById(R.id.bt_weibo).setOnClickListener(this);
        findViewById(R.id.bt_qq).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_weibo:

                break;
            case R.id.bt_weixin:
                //shardSdk微信登入
                Platform wechat= ShareSDK.getPlatform(BaseApplication.getContext(), Wechat.NAME);
                wechat.SSOSetting(false);
                wechat.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Toast.makeText(BaseApplication.getContext(), "授权成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                        Toast.makeText(BaseApplication.getContext(), "授权失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {
                        Toast.makeText(BaseApplication.getContext(), "取消微信授权", Toast.LENGTH_SHORT).show();
                    }
                });
                wechat.authorize();

                break;
            case R.id.bt_qq:
                enterByQQ();
                break;
            default:
                break;
        }
    }

    private void enterByQQ() {
        //shardSdkQQ登入
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        qq.SSOSetting(false);  //设置false表示使用SSO授权方式
        qq.setPlatformActionListener(new PlatformActionListener() {

            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                System.out.println("ssssssssssssssssssssssssssssssss");
            }

            @Override
            public void onCancel(Platform arg0, int arg1) {
                // TODO Auto-generated method stub

            }
        }); // 设置分享事件回调
        qq.authorize();
    }

}
