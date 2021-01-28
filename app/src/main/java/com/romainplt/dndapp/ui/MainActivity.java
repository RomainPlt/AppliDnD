package com.romainplt.dndapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.ui.create.CreateCharacter;

public class MainActivity extends AppCompatActivity {

    private Button buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CreatePerso(View view){
        Intent intent = new Intent(this, CreateCharacter.class);
        startActivity(intent);

    }
}