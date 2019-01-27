package com.lusi.bbi.Quiz;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lusi.bbi.R;
import com.lusi.bbi.Quiz.Model.Penjelasan;
import com.lusi.bbi.R;

import java.util.ArrayList;

public class penjelasanAdpater extends ArrayAdapter<Penjelasan> {
    private ArrayList<Penjelasan> dataSet;
    Context mContext;

   private static class ViewHolder{
       TextView soal, jawab, uraian;

   }
    public penjelasanAdpater(ArrayList<Penjelasan> data,Context context) {
        super(context, R.layout.model_penjelasan, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Penjelasan penjelasan = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.model_penjelasan, parent, false);
            viewHolder.soal = convertView.findViewById(R.id.tvSoal);
            viewHolder.jawab = convertView.findViewById(R.id.tvJawab);
            viewHolder.uraian = convertView.findViewById(R.id.tvPenjelasan);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.soal.setText(penjelasan.getSoal());
        viewHolder.jawab.setText(penjelasan.getJawab());
        viewHolder.uraian.setText(penjelasan.getUraian());
        // Return the completed view to render on screen
        return convertView;
    }
}
