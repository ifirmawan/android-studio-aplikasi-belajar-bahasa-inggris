package com.example.derysudrajat.appsbbi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ScoreFragment extends Fragment {
    String[] title={"Quiz 1","Quiz 2","Quiz 3"};
    String[] score={"Score: 0","Score: 0","Score: 0",};
    int[] img={R.drawable.scoreasy,R.drawable.scormedium,R.drawable.scorhard};
    Class[] detail={RiwayatScoreFragment.class,RiwayatScoreFragment2.class,RiwayatScoreFragment3.class};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.main_fragment,container,false);
        RecyclerView rv= rootView.findViewById(R.id.mainRV);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        initCollapsingToolbar();
        MyAdapter adapter=new MyAdapter(this.getActivity(),title,score,img,detail);
        Glide.with(this).load(R.drawable.dropback).into((ImageView) getActivity().findViewById(R.id.backdrop));
        rv.setAdapter(adapter);

        return rootView;
    }
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = getActivity().findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = getActivity().findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);


        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Riwayat");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
