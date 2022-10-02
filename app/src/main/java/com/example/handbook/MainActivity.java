package com.example.handbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
        private DrawerLayout drawer;
        private ListView list;
        private String[] elementsArray;
        private ArrayAdapter<String> adapter;
        private Toolbar toolbar;
        private int categoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        elementsArray = getResources().getStringArray(R.array.mushroomsArray);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1
                , new ArrayList<String>(Arrays.asList(elementsArray)));
        list.setAdapter(adapter);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, TextContentActivity.class);
                intent.putExtra("category", categoryIndex);
                intent.putExtra("position", i);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.app_title);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_mushrooms) {
            fillArray("Грибы",R.string.mushrooms, R.array.mushroomsArray, 0);
        }
        else if (id == R.id.nav_flowers) {
            fillArray("Цветы", R.string.flowers, R.array.flowersArray, 1);
        }
        else if (id == R.id.nav_insects) {
            fillArray("Насекомые",R.string.insects, R.array.insectsArray,2);
        }
        else if (id == R.id.nav_animals) {
            fillArray("Животные",R.string.animals,R.array.animalsArray, 3);
        }
        else if (id == R.id.nav_recipes) {
            fillArray("Рецепты",R.string.recipes,R.array.recipesArray, 4);
        }
        else if (id == R.id.nav_advice) {
            fillArray("Советы", R.string.advice, R.array.adviceArray, 5);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void fillArray(String categoryText, int title, int arrayList, int index) {
        Toast.makeText(this, categoryText, Toast.LENGTH_SHORT).show();
        toolbar.setTitle(title);
        elementsArray = getResources().getStringArray(arrayList);
        adapter.clear();
        adapter.addAll(elementsArray);
        adapter.notifyDataSetChanged();
        categoryIndex = index;
    }
}