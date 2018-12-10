package com.example.derysudrajat.appsbbi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oclemmy on 5/10/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class MyHolder extends RecyclerView.ViewHolder {


    TextView nametxt,qtyText;
    ImageView imageView;

    public MyHolder(View itemView) {
        super(itemView);

        nametxt= itemView.findViewById(R.id.nameTxt);
        qtyText= itemView.findViewById(R.id.nameTxt2);
        imageView = itemView.findViewById(R.id.imgVi);    }

}
