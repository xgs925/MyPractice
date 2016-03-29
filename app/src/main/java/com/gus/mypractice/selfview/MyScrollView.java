package com.gus.mypractice.selfview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by gus on 2016/3/29.
 */
public class MyScrollView extends ViewGroup {
    Context context;

    public MyScrollView(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
       int mSreemHeight = wm.getDefaultDisplay().getHeight();
        mlp.height = mSreemHeight * childCount;
        setLayoutParams(mlp);
        for(int i=0;i<childCount;i++){
            View child=getChildAt(i);
            if(child.getVisibility()!=View.GONE){
                child.layout(l,i*mSreemHeight,r,(i+1)*mSreemHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
