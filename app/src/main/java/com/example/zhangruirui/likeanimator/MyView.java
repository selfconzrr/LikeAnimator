package com.example.zhangruirui.likeanimator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自定义 View 我们大部分时候只需重写两个函数：onMeasure()、onDraw()。
 * onMeasure 负责对当前 View 的尺寸进行测量，onDraw 负责把当前这个 View 绘制出来。
 * 当然了，还得写至少写2个构造函数：1参和2参的
 */
public class MyView extends View {

  public MyView(Context context) {
    super(context);
  }

  public MyView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    Log.e("zhangrr", "onMeasure() called with: measureHeight = [" + getMeasuredHeight() + " height = " + getHeight());
//    int width = getMySize(100, widthMeasureSpec);
//    int height = getMySize(100, heightMeasureSpec);
//
//    if (width < height) {
//      height = width;
//    } else {
//      width = height;
//    }
//
//    setMeasuredDimension(width, height);
  }

  @Override
  protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
    Log.e("zhangrr", "onLayout() called with: measureHeight = [" + getMeasuredHeight() + " height = " + getHeight());
  }

  @Override
  protected void onDraw(Canvas canvas) {
    // 调用父 View 的 onDraw 函数，因为 View 这个类帮我们实现了一些
    // 基本的绘制功能，比如绘制背景颜色、背景图片等
    super.onDraw(canvas);

    int r = getMeasuredWidth() / 2;
    // 圆心的横坐标为当前的 View 的左边起始位置+半径
    int centerX = getLeft() + r;
    // 圆心的纵坐标为当前的 View 的顶部起始位置+半径
    int centerY = getTop() + r;

    Paint paint = new Paint();
    paint.setColor(Color.GREEN);
    canvas.drawCircle(centerX, centerY, r, paint);
  }

  private int getMySize(int defaultSize, int measureSpec) {
    int mySize = defaultSize;

    int mode = MeasureSpec.getMode(measureSpec);
    int size = MeasureSpec.getSize(measureSpec);

    switch (mode) {
      case MeasureSpec.UNSPECIFIED: { // 如果没有指定大小，就设置为默认大小
        mySize = defaultSize;
        break;
      }
      case MeasureSpec.AT_MOST: { // 如果测量模式是最大取值为 size
        // 我们将大小取最大值,你也可以取其他值
        mySize = size;
        break;
      }
      case MeasureSpec.EXACTLY: { // 如果是固定的大小，那就不要去改变它
        mySize = size;
        break;
      }
    }
    return mySize;
  }
}
