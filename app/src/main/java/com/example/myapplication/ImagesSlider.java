package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class ImagesSlider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_slider);
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.item5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.item8, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.item9, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.item10, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

    }
}