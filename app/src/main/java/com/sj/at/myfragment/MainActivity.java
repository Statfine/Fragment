package com.sj.at.myfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sj.at.five.ViewPageFragment;
import com.sj.at.four.ViewPageTest;
import com.sj.at.one.FragmentMainActivity;
import com.sj.at.three.MainThreeActivity;
import com.sj.at.two.MainTwoActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button one_fragmnet,two_fragmnet,four_fragmnet,three_fragmnet,five_fragmnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    public void initLayout(){

        one_fragmnet = (Button) this.findViewById(R.id.one_fragmnet);
        two_fragmnet = (Button) this.findViewById(R.id.two_fragmnet);
        three_fragmnet = (Button) this.findViewById(R.id.three_fragmnet);
        four_fragmnet = (Button) this.findViewById(R.id.four_fragmnet);
        five_fragmnet = (Button) this.findViewById(R.id.five_fragmnet);

        one_fragmnet.setOnClickListener(this);
        two_fragmnet.setOnClickListener(this);
        three_fragmnet.setOnClickListener(this);
        four_fragmnet.setOnClickListener(this);
        five_fragmnet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.one_fragmnet:
                startActivity(new Intent(this, FragmentMainActivity.class));//底部点击切换
                break;
            case R.id.four_fragmnet:
                startActivity(new Intent(this, ViewPageTest.class));//底部点击手势切换
                break;
            case R.id.five_fragmnet:
                startActivity(new Intent(this, ViewPageFragment.class));//手势切换，顶部显示
                break;
            case R.id.two_fragmnet:
                /*
                *在一个Activity点击fragment跳转不同的Fragment，
                * 事件绑定在Activity中
                */
                startActivity(new Intent(this, MainTwoActivity.class));
                break;
            case R.id.three_fragmnet:
                //fragment事件通信
                startActivity(new Intent(this, MainThreeActivity.class));
                break;
            default:
        }
    }



}
