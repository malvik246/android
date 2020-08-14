package com.leudroid.mywork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoImageLoading extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_image_loading);
        imageView = (ImageView) findViewById(R.id.showImage);

        String url = "https://github.com/square/picasso/raw/master/website/static/sample.png";

        Picasso.get().load(url).into(imageView);
    }
}