package com.gus.mypractice.selfview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gus on 2016/3/29.
 */
public class CircleProgressView extends View {
    Paint paint = new Paint();

    private int length = 500;
    int mCircleXY = length / 2;
    float mRadius = (float) (length * 0.5 / 2);
    RectF mArcRectF = new RectF((float) (length * 0.1), (float) (length * 0.1), (float) (length * 0.9), (float) (length * 0.9));
    private int mSweepAngle = 180;
    private char[] mShowText = {'a', 'b', 'c'};

    public CircleProgressView(Context context) {
        super(context);

    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, paint);
        paint.setColor(Color.RED);
        canvas.drawArc(mArcRectF, 270, 100, true, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText(mShowText, 0, mShowText.length, mCircleXY, mCircleXY, paint);
    }
}
