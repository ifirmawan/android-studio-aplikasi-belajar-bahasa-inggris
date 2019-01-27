package  com.lusi.bbi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.lusi.bbi.R;

public class About extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        b = findViewById(R.id.visit_website);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Belajar Bahasa Inggris ";
                String shareSub = "BBI";
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(intent, "Share Using"));

//                String url = "https://www.kvikesh800.wixsite.com/learner";
//                intent.setData(Uri.parse(url));
//                Intent chooser = Intent.createChooser(intent, "Open with");
//                startActivity(chooser);
            }
        });

    }
}
