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

public class MateriFragment extends Fragment {

    String[] title={"Listening Section","Degree of Comparison","Noun and Pronoun"};
    String[] tema={"","",""};
    int[] img={R.drawable.listen,R.drawable.compare,R.drawable.noun};
    Class[] materi={IsiMateri1.class,IsiMateri2.class,IsiMateri3.class};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.main_fragment,container,false);
        RecyclerView rv= rootView.findViewById(R.id.mainRV);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        Glide.with(this).load(R.drawable.dropback).into((ImageView) getActivity().findViewById(R.id.backdrop));
        initCollapsingToolbar();
        MyAdapter adapter=new MyAdapter(this.getActivity(),title,tema,img,materi);
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
                    collapsingToolbar.setTitle("Materi");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

}
