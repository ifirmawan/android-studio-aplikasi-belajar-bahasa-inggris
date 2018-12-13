package com.example.derysudrajat.appsbbi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;

public class RiwayatHolder extends RecyclerView.ViewHolder {
    TextView benar, salah, tingkat;
    IconRoundCornerProgressBar progressBar;
    public RiwayatHolder(View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progresScore);
        benar = itemView.findViewById(R.id.tvBenar);
        salah = itemView.findViewById(R.id.tvSalah);
        tingkat = itemView.findViewById(R.id.tvTingkat);
    }
}
