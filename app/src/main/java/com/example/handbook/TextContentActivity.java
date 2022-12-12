package com.example.handbook;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class TextContentActivity extends AppCompatActivity {
    private TextView textContent;
    private int category = 0;
    private int position = 0;
    private ImageView imageContent;
    private final int []arrayMushrooms = {R.string.girolle, R.string.boletus};
    private final int[] arrayImageMushrooms = {R.drawable.girolle, R.drawable.boletus};
    private final int []arrayFlowers = {R.string.rose, R.string.mimosa};
    private final int []arrayImageFlowers = {R.drawable.rose, R.drawable.mimose};
    private final int[] arrayInsects = {R.string.butterflies, R.string.bugs};
    private final int[] arrayImageInsects = {R.drawable.butterflies, R.drawable.bugs};
    private final int [] arrayAnimals = {R.string.mice, R.string.eventoed};
    private final int[] arrayImageAnimals = {R.drawable.mice, R.drawable.eventoed};
    private final int[] arrayRecipes = {R.string.pupmkinporridge, R.string.marrowpancakes};
    private final int[] arrayImageRecipes = {R.drawable.pumpkinporridge, R.drawable.marrowpancakes};
    private final int[] arrayImageAdvice = {R.drawable.potatobug, R.drawable.time_seeding};
    private final int[] arrayAdvice = {R.string.potatoBugElimination, R.string.bestTimeForSeeding};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        receiveIntent();
    }
    private void receiveIntent() {
        Intent intent = getIntent();
        Objects.requireNonNull(getSupportActionBar()).hide();
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
            case 5:
                imageContent.setImageResource(arrayImageAdvice[position]);
                textContent.setText(arrayAdvice[position]);
        }

    }
    private void init() {
        textContent = findViewById(R.id.textMainContent);
        imageContent = findViewById(R.id.imageContent);
        Typeface typeFace = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Medium.ttf");
        textContent.setTypeface(typeFace);

    }


}
