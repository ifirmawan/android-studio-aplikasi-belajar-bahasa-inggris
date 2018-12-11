package com.example.derysudrajat.appsbbi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreHolder> {
    Context c;
    String[] title,qty;
    int[] img;
    Class[] destination;
    public ScoreAdapter (Context c, String[] title, String[] qty,int[] img, Class[] mdestination){
        this.c = c;
        this.title = title;
        this.qty = qty;
        this.img = img;
        destination=mdestination;
    }
    @Override
    public ScoreHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model,viewGroup,false);
        return new ScoreHolder(v);
    }

    @Override
    public void onBindViewHolder(ScoreHolder scoreHolder, int i) {
        final Class dDestination = destination[i];
        scoreHolder.nametxt.setText(title[i]);
        scoreHolder.qtyText.setText(qty[i]);
        Glide.with(c).load(img[i]).into(scoreHolder.imageView);
        scoreHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,dDestination);
                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}
