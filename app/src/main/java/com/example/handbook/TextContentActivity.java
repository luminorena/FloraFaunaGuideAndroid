package com.example.handbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    private TextView textContent;
    private int category = 0;
    private int position = 0;
    private ImageView imageContent;
    private Typeface typeFace;
    private int []arrayMushrooms = {R.string.girolle, R.string.boletus};
    private int[] arrayImageMushrooms = {R.drawable.girolle, R.drawable.boletus};
    private int []arrayFlowers = {R.string.rose, R.string.mimosa};
    private int []arrayImageFlowers = {R.drawable.rose, R.drawable.mimose};
    private int[] arrayInsects = {R.string.butterflies, R.string.bugs};
    private int[] arrayImageInsects = {R.drawable.butterflies, R.drawable.bugs};
    private int [] arrayAnimals = {R.string.mice, R.string.eventoed};
    private int[] arrayImageAnimals = {R.drawable.mice, R.drawable.eventoed};
    private int[] arrayRecipes = {R.string.pupmkinporridge, R.string.marrowpancakes};
    private int[] arrayImageRecipes = {R.drawable.pumpkinporridge, R.drawable.marrowpancakes};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        receiveIntent();
    }
    private void receiveIntent() {
        Intent intent = getIntent();
        if (intent != null){
            category = intent.getIntExtra("category", 0);
            position = intent.getIntExtra("position", 0);
        }
        switch (category) {
            case 0:
                imageContent.setImageResource(arrayImageMushrooms[position]);
                textContent.setText(arrayMushrooms[position]);
                break;
            case 1:
                imageContent.setImageResource(arrayImageFlowers[position]);
                textContent.setText(arrayFlowers[position]);
                break;
            case 2:
                imageContent.setImageResource(arrayImageInsects[position]);
                textContent.setText(arrayInsects[position]);
                break;
            case 3:
                imageContent.setImageResource(arrayImageAnimals[position]);
                textContent.setText(arrayAnimals[position]);
                break;
            case 4:
                imageContent.setImageResource(arrayImageRecipes[position]);
                textContent.setText(arrayRecipes[position]);
                break;
        }

    }
    private void init() {
        textContent = findViewById(R.id.textMainContent);
        imageContent = findViewById(R.id.imageContent);
        typeFace = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Medium.ttf");
        textContent.setTypeface(typeFace);

    }


}
