package com.romainplt.dndapp.ui.create;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Race;

public class ClassFragment extends Fragment {

    private Character character;
    private Race race;

    private RadioGroup radioGroupClass;
    private RadioButton radioButtonWarrior;
    private RadioButton radioButtonThief;
    private RadioButton radioButtonSorcerer;
    private RadioButton radioButtonAssassin;
    private RadioButton radioButtonMonk;
    private RadioButton radioButtonRanger;
    private RadioButton radioButtonPriest;
    private RadioButton radioButtonIllusionist;
    private RadioButton radioButtonBarbarian;
    private RadioButton radioButtonDruid;
    private TextView textClass;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private Button questionButton;
    PopupWindow popUp;


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.class_layout, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        popUp = new PopupWindow();


        nextButton = (ImageButton) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new ClassFragment());
                ft.commit();
            }
        });

        prevButton = (ImageButton) view.findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new RaceFragment());
                ft.commit();
            }
        });

        questionButton = (Button) view.findViewById(R.id.questionButton);
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create(); //Read Update
                alertDialog.setTitle(R.string.classe);
                alertDialog.setMessage("Your class is like your job: what are your specialities, what " +
                        "are your powers, what can you wear or use, etc. Choose it wisely as it will " +
                        "have a lot of influence on your gameplay. ");

                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();
            }
        });

    }
}

