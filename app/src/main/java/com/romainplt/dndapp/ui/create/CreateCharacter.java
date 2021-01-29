package com.romainplt.dndapp.ui.create;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Character;
import com.romainplt.dndapp.model.Classe;
import com.romainplt.dndapp.model.Description;
import com.romainplt.dndapp.model.Race;

public class CreateCharacter extends AppCompatActivity {

    public CreateCharacter(){
        super(R.layout.create_character);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void onClick(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.createCharacterLayout, new RaceFragment());
        ft.commit();

    }

}
