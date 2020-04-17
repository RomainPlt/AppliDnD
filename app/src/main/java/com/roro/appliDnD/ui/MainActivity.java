package com.roro.appliDnD.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.roro.appliDnD.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void creerPerso(View view) {
        Intent intent = new Intent(this, CreerRaceActivity.class);
        startActivity(intent);

    }
}
