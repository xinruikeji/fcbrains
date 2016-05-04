package com.fcbrains.xinruikeji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterLogin();
    }

    private void enterLogin() {
        Intent intent = new Intent(this, LoginAcivity.class);
        startActivity(intent);
        finish();
    }
}
