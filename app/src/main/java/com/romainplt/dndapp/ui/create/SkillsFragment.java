package com.romainplt.dndapp.ui.create;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Background;
import com.romainplt.dndapp.model.Race;
import com.romainplt.dndapp.model.Skills;

public class SkillsFragment extends Fragment {

    private SendSkills SS;
    private Skills skills;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private Button questionButton;
    private Button okButton;

    private CheckBox acrobatics ;
    private CheckBox animalHandling;
    private CheckBox arcana;
    private CheckBox athletics;
    private CheckBox deception;
    private CheckBox history;
    private CheckBox insight;
    private CheckBox intimidation;
    private CheckBox investigation;
    private CheckBox medicine;
    private CheckBox nature;
    private CheckBox perception;
    private CheckBox performance;
    private CheckBox persuasion;
    private CheckBox religion;
    private CheckBox sleightOfHand;
    private CheckBox stealth;
    private CheckBox survival;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.skills_layout, parent, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        skills = new Skills();

        acrobatics = getView().findViewById(R.id.acrobatics);
        animalHandling = getView().findViewById(R.id.animalHandling);
        arcana = getView().findViewById(R.id.arcana);
        athletics = getView().findViewById(R.id.athletics);
        deception = getView().findViewById(R.id.deception);
        history = getView().findViewById(R.id.history);
        insight = getView().findViewById(R.id.insight);
        intimidation = getView().findViewById(R.id.intimidation);
        investigation = getView().findViewById(R.id.investigation);
        medicine = getView().findViewById(R.id.medicine);
        nature = getView().findViewById(R.id.nature);
        perception = getView().findViewById(R.id.perception);
        performance = getView().findViewById(R.id.performance);
        persuasion = getView().findViewById(R.id.persuasion);
        religion = getView().findViewById(R.id.religion);
        sleightOfHand = getView().findViewById(R.id.sleightOfHand);
        stealth = getView().findViewById(R.id.stealth);
        survival = getView().findViewById(R.id.survival);

        nextButton = (ImageButton) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new RaceFragment());
                ft.commit();
            }
        });

        prevButton = (ImageButton) view.findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new GodFragment());
                ft.commit();
            }
        });


        questionButton = (Button) view.findViewById(R.id.quetionButton);
        questionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create(); //Read Update
                alertDialog.setTitle(R.string.background);
                alertDialog.setMessage("");

                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();
            }
        });

        okButton = getView().findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SS.sendData(skills);
            }
        });


    }


    interface SendSkills {
        void sendData(Skills skills);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SS = (SendSkills) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }



}
