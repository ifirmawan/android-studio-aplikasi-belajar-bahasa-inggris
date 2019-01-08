package com.example.derysudrajat.appsbbi;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatHolder> {
    Context c;
    ArrayList<Rwayat> rwayats;
    public RiwayatAdapter(Activity context, ArrayList<Rwayat> mriwayat) {
        c = context;
        rwayats = mriwayat;

    }

    @Override
    public RiwayatHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v= LayoutInflater.from(c).inflate(R.layout.activity_score_detail,parent,false);
        return new RiwayatHolder(v);
    }

    @Override
    public void onBindViewHolder(RiwayatHolder riwayatHolder, int i) {
        Rwayat rwayatItem = rwayats.get(i);
        riwayatHolder.progressBar.setProgress(rwayatItem.getmNilai());
        riwayatHolder.benar.setText(rwayatItem.getmNilaiBenar());
        riwayatHolder.salah.setText(rwayatItem.getmNilaiSalah());
        riwayatHolder.tanggal.setText(rwayatItem.getmTanggal());
        riwayatHolder.tingkat.setText(rwayatItem.getmTingkatKesulitan());
    }

    @Override
    public int getItemCount() {
        return rwayats.size();
    }
}
