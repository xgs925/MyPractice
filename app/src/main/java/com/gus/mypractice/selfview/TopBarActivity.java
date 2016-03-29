package com.gus.mypractice.selfview;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;
import android.widget.Toast;

import com.gus.mypractice.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopBarActivity extends AppCompatActivity {
    @Bind(R.id.topbar)
    TopBar mTopBar;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Slide(Gravity.RIGHT));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar);
        ButterKnife.bind(this);
        mTopBar.setListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
                overridePendingTransition(0, R.anim.slide_out_right);
            }

            @Override
            public void rightClick() {
                Toast.makeText(TopBarActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
