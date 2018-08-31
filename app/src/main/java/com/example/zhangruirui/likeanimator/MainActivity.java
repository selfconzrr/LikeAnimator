package com.example.zhangruirui.likeanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ZhangRuirui：2018/08/31
 * 仿抖音视频详情页的点赞特效，自定义动画实现该效果
 */

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.btn)
  Button mBtn;

  @BindView(R.id.myView)
  View mView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }
}
