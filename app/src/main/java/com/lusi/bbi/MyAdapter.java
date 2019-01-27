package  com.lusi.bbi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.lusi.bbi.R;
import com.lusi.bbi.MyHolder;
import com.lusi.bbi.R;

/**
 * Created by Oclemmy on 5/10/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    String[] title,qty,difficulty;
    int[] img;
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    Class[] destination;

    public MyAdapter(Context c, String[] title, String[] qty,int[] img, Class[] mdestination, String[] mdifficulty) {
        this.c = c;
        this.title = title;
        this.qty = qty;
        this.img = img;
        difficulty= mdifficulty;
        destination=mdestination;
    }
    public MyAdapter(Context c, String[] title, String[] qty,int[] img, Class[] mdestination) {
        this.c = c;
        this.title = title;
        this.qty = qty;
        this.img = img;
        destination=mdestination;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }


    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (difficulty!=null){
            final Class dDestination = destination[position];
            final String dDificult = difficulty[position];

            holder.nametxt.setText(title[position]);

            holder.qtyText.setText(qty[position]);
            Glide.with(c).load(img[position]).into(holder.imageView);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(c,dDestination);
                    i.putExtra(EXTRA_DIFFICULTY, dDificult);
                    c.startActivity(i);
                }
            });
        }else{
            final Class dDestination = destination[position];
            holder.nametxt.setText(title[position]);
            holder.qtyText.setText(qty[position]);
            Glide.with(c).load(img[position]).into(holder.imageView);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(c,dDestination);
                    c.startActivity(i);
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return title.length;
    }
}
