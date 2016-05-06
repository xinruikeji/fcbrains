package com.fcbrains.xinruikeji;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.fcbrains.xinruikeji.widget.MutiProgress;
import com.fcbrains.xinruikeji.widget.RadarView;

/**
 * Created by lizhanfeng on 2016/5/6.
 */
public class TestActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    private RadarView radar;
    private String[] m={"A型","B型","O型","AB型","其他"};
    private TextView textView;
    private int[] state = new int[]{1,0,1,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        radar = (RadarView) findViewById(R.id.radar);
        Button button = (Button) findViewById(R.id.button);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.text);
        MutiProgress mutiProgress = (MutiProgress) findViewById(R.id.mp);

        button.setOnClickListener(this);
        radar.setTextPaintColor(Color.RED);

        animater(radar);
        setSpinner(spinner);
        mutiProgress.setState(state);
        mutiProgress.setCurrNodeNO(3);
    }
    private void setSpinner(Spinner spinner) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);

        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //将adapter 添加到spinner中
        spinner.setAdapter(adapter);

        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(this);

        //设置默认值
//        spinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textView.setText(m[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void animater(RadarView radar) {
        AnimatorSet animatorSet = new AnimatorSet();//组合动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(radar, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(radar, "scaleY", 0f, 1f);
        ObjectAnimator rotationX = ObjectAnimator .ofFloat(radar, "rotationX", 180f, 0f);
        ObjectAnimator rotationY = ObjectAnimator .ofFloat(radar, "rotationY", 180f, 0f);

        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(scaleX).with(scaleY).with(rotationX).with(rotationY);//两个动画同时开始
//        animatorSet.play(rotationX).before(rotationX1);
//        animatorSet.play(rotationY).before(rotationY1);
        animatorSet.start();
    }

    @Override
    public void onClick(View v) {
        animater(radar);
    }
}
