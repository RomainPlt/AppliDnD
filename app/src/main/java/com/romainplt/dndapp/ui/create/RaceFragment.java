package com.romainplt.dndapp.ui.create;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.romainplt.dndapp.R;

public class RaceFragment extends Fragment {

    private RadioGroup radioGroupRace;
    private RadioButton radioButtonHuman;
    private RadioButton radioButtonDwarf;
    private RadioButton radioButtonElf;
    private RadioButton radioButtonHalfElf;
    private RadioButton radioButtonHalfOrc;
    private RadioButton radioButtonGnome;
    private RadioButton radioButtonTieflin;
    private TextView textRace;


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.race_layout, parent, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        textRace = getView().findViewById(R.id.descriptionRace);
        textRace.setMovementMethod(new ScrollingMovementMethod());
        textRace.bringToFront();
    }








}
