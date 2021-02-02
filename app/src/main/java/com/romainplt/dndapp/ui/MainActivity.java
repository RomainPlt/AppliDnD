package com.romainplt.dndapp.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.ui.create.CreateCharacter;

public class MainActivity extends AppCompatActivity {

    private Button buttonCreate;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("D-Andy");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.dnd);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }


    public void CreatePerso(View v){
        Intent intent = new Intent(this, CreateCharacter.class);
        startActivity(intent);

    }
}