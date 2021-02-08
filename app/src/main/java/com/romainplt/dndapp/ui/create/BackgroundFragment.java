package com.romainplt.dndapp.ui.create;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.romainplt.dndapp.model.Background;
import com.romainplt.dndapp.model.Race;
import com.romainplt.dndapp.model.Skills;

public class BackgroundFragment extends Fragment {

    private SendBackground SB;

    private RadioGroup rg1;
    private RadioGroup rg2;

    private ImageButton nextButton;
    private ImageButton prevButton;
    private Button questionButton;
    private RadioButton checkedRadioButton;
    PopupWindow popUp;

    private Background background = new Background();
    private Button okButton;
    private Skills skills = new Skills();


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.background_layout, parent, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {


        popUp = new PopupWindow();
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
                ft.replace(R.id.createCharacterLayout, new DetailsFragment());
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
                alertDialog.setMessage("Your character background is a description of what he was doing before" +
                        " becoming an adventurer. This will give you special abilities like if you were a " +
                        "soldier in the army you will be able to use more weapons than a church boy, no shit.  ");

                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();
            }
        });

        rg1 = (RadioGroup) getView().findViewById(R.id.backgroundRadioGroup1);
        rg2 = (RadioGroup) getView().findViewById(R.id.backgroundRadioGroup2);
        rg1.clearCheck(); // this is so we can start fresh, with no selection on both RadioGroups
        rg2.clearCheck();
        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);
        okButton = getView().findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SB.sendData(background);
            }
        });


    }


    interface SendBackground {
        void sendData(Background background);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SB = (SendBackground) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }


    String[] language = new String[]{};

    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg2.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                rg2.clearCheck(); // clear the second RadioGroup!
                rg2.setOnCheckedChangeListener(listener2); //reset the listener
                okButton = getView().findViewById(R.id.okButton);
                okButton.setEnabled(true);
            }

            switch (checkedId) {

                case R.id.radioButton_Acolyte:
                    skills = new Skills();
                    background.setName("Acolyte");
                    background.setDescription("");
                    skills.setInsight(2);
                    skills.setReligion(2);
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Artist:
                    skills = new Skills();
                    background.setName("Artist");
                    skills.setAcrobatics(2);
                    skills.setPerformance(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Charlatan:
                    skills = new Skills();
                    background.setName("Charlatan");
                    skills.setSleightOfHand(2);
                    skills.setDeception(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_StreetBoi:
                    skills = new Skills();
                    background.setName("Street Boy");
                    skills.setStealth(2);
                    skills.setSleightOfHand(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Crafter:
                    skills = new Skills();
                    background.setName("Guild Crafter");
                    skills.setPersuasion(2);
                    skills.setInsight(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Criminal:
                    skills = new Skills();
                    background.setName("Criminal");
                    skills.setStealth(2);
                    skills.setDeception(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Soldier:
                    skills = new Skills();
                    background.setName("Soldier");
                    skills.setAthletics(2);
                    skills.setIntimidation(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;

            }

        }
    };

    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg1.setOnCheckedChangeListener(null);
                rg1.clearCheck();
                rg1.setOnCheckedChangeListener(listener1);
                okButton = getView().findViewById(R.id.okButton);
                okButton.setEnabled(true);
            }

            switch (checkedId) {

                case R.id.radioButton_Ermit:
                    background.setName("Ermit");
                    skills = new Skills();
                    skills.setMedicine(2);
                    skills.setReligion(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Hero:
                    background.setName("Hero");
                    skills = new Skills();
                    skills.setAnimalHandling(2);
                    skills.setSurvival(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Sailor:
                    background.setName("Sailor");
                    skills = new Skills();
                    skills.setAthletics(2);
                    skills.setPerception(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);

                    break;
                case R.id.radioButton_Noble:
                    background.setName("Noble");
                    skills = new Skills();
                    skills.setHistory(2);
                    skills.setPersuasion(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Wise:
                    background.setName("Wise");
                    skills = new Skills();
                    skills.setArcana(2);
                    skills.setHistory(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_Wildling:
                    background.setName("wildling");
                    skills = new Skills();
                    skills.setAthletics(2);
                    skills.setSurvival(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;
                case R.id.radioButton_ChurchBoi:
                    background.setName("Church Boy");
                    skills = new Skills();
                    skills.setReligion(2);
                    skills.setSurvival(2);
                    background.setDescription("");
                    background.setBackgroundSkills(skills);
                    language = new String[]{"", ""};
                    background.setBackgroundLanguages(language);
                    break;

            }
        }
    };



}
