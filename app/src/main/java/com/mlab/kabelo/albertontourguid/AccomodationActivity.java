package com.mlab.kabelo.albertontourguid;

import android.content.Intent;
import android.service.voice.VoiceInteractionService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class AccomodationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        myRef = FirebaseDatabase.getInstance().getReference().child("/blog1");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter<Blog,AccomodationActivity.BlogViewHolder> adapter =new FirebaseRecyclerAdapter<Blog, AccomodationActivity.BlogViewHolder>(
                Blog.class,
                R.layout.individual_row,
                AccomodationActivity.BlogViewHolder.class,
                myRef
        ) {
            @Override
            protected void populateViewHolder(AccomodationActivity.BlogViewHolder viewHolder, Blog model, int position) {
                final String post_key = getRef(position).getKey();
                viewHolder.setName(model.getName());
                viewHolder.setAddress(model.getAddress());
                viewHolder.setImage(model.getImage());

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent kb = new Intent(AccomodationActivity.this, DetailsActivity.class);
                        kb.putExtra("blog", post_key);
                        startActivity(kb);
                    }
                });

            }
        };


        recyclerView.setAdapter(adapter);

    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        TextView text_name,text_address;
        ImageView imageview;
        public BlogViewHolder(View itemView) {
            super(itemView);
            text_name=(TextView)itemView.findViewById(R.id.name);
            text_address=(TextView)itemView.findViewById(R.id.address);
            imageview=(ImageView)itemView.findViewById(R.id.imageview);
        }



        public void setName(String name) {
            text_name.setText(name);
        }

        public void setAddress(String address) {
            text_address.setText(address);
        }

        public void setImage(String image) {
            Picasso.with(itemView.getContext())
                    .load(image)
                    .resize(500, 500)
                    .centerCrop()
                    .into(imageview);

        }
    }
}
