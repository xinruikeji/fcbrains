package com.fcbrains.xinruikeji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginAcivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI() {
        Button mWeiXin = (Button) findViewById(R.id.bt_weixin);
        mWeiXin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
}
