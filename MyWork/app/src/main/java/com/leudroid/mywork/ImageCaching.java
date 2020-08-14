package com.leudroid.mywork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class ImageCaching extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_image_loading);
        imageView = (ImageView) findViewById(R.id.showImage);

        final String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR875YqYv-yBApF1M6Ba22AH7qX4s3rcMNVNg&usqp=CAU";

        Picasso.get().load(url).networkPolicy(NetworkPolicy.OFFLINE).into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                Picasso.get().load(url).into(imageView);
            }
        });
    }
}