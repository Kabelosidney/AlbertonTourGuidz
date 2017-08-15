package com.mlab.kabelo.albertontourguid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference myRef;

   // https://www.youtube.com/watch?v=0QnvFYsKl4U
    //https://www.youtube.com/watch?v=sbsuYCiBJvk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myRef = FirebaseDatabase.getInstance().getReference().child("/blog");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter<Blog,BlogViewHolder> adapter =new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(
                Blog.class,
                R.layout.individual_row,
                BlogViewHolder.class,
                myRef
        ) {

            @Override
            public void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {

                final String post_key = getRef(position).getKey();
                viewHolder.setName(model.getName());
                viewHolder.setAddress(model.getAddress());
                viewHolder.setImage(model.getImage());

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent kb = new Intent(HomeActivity.this, DetailsActivity.class);
                        kb.putExtra("blog", post_key);
                        startActivity(kb);
                    }
                });


            }

        };




        recyclerView.setAdapter(adapter);

    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView text_name,text_address;
        ImageView imageview;


        public BlogViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
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

        @Override
        public void onClick(View view) {

        }
    }
}










