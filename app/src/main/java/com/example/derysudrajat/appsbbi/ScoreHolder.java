package com.example.derysudrajat.appsbbi;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreHolder extends RecyclerView.ViewHolder {
    TextView nametxt,qtyText;
    ImageView imageView;

    public ScoreHolder(View itemView) {
        super(itemView);
        nametxt= itemView.findViewById(R.id.nameTxt);
        qtyText= itemView.findViewById(R.id.nameTxt2);
        imageView = itemView.findViewById(R.id.imgVi);
    }
}
