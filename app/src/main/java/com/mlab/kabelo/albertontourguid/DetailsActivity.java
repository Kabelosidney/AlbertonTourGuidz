package com.mlab.kabelo.albertontourguid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.CollationElementIterator;

import static com.mlab.kabelo.albertontourguid.R.id.nam;
import static com.mlab.kabelo.albertontourguid.R.id.name;

public class DetailsActivity extends AppCompatActivity {
    //https://www.youtube.com/watch?v=dClm5lKzcgM

    private String mPost_key = null;
    private DatabaseReference myRef;

    private ImageView mBlogSingleImage;
    private TextView mBlogSingleName;
    private TextView mBlogSingleAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        myRef = FirebaseDatabase.getInstance().getReference().child("blog");

        mPost_key = getIntent().getExtras().getString("blog");

        mBlogSingleName = (TextView)findViewById(nam);
        mBlogSingleImage = (ImageView)findViewById(R.id.imageview);
        mBlogSingleAddress = (TextView)findViewById(R.id.address);


       // Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();

        myRef.child(mPost_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
