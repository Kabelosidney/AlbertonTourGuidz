package com.mlab.kabelo.albertontourguid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class category extends AppCompatActivity {
    public Button mallBtn,entertainmentBtn,accomodationBtn,LionBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mallBtn=(Button)findViewById(R.id.button_malls);
        mallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        entertainmentBtn=(Button)findViewById(R.id.button_entertainment);
        entertainmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this, EntertainmentActivity.class);
                startActivity(intent);
            }
        });

        accomodationBtn=(Button)findViewById(R.id.button_accomodation);
        accomodationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this, AccomodationActivity.class);
                startActivity(intent);
            }
        });

    }


}
