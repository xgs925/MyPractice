package com.gus.mypractice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gus.mypractice.selfview.TopBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gus on 2016/3/29.
 */
public class MainViewFragment extends Fragment {
    @Bind(R.id.main_view_recycler)
    RecyclerView mRecyclerView;
    private MyRecyclerAdapter myRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_view, container, false);
        ButterKnife.bind(this, view);
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mData.add("TopBar");
        mData.add("test");
        mData.add("test");
        mData.add("test");
        mData.add("test");
        mData.add("test");
        mData.add("test");
        myRecyclerAdapter = new MyRecyclerAdapter(mData);
        mRecyclerView.setAdapter(myRecyclerAdapter);
        myRecyclerAdapter.setItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(final View view, int position) {
                switch (position) {
                    case 0:
                        getActivity().startActivity(new Intent(getActivity(), TopBarActivity.class), ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                        break;
                }
            }
        });
        return view;
    }
}
