package com.romainplt.dndapp.ui.create;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Advanturer;
import com.romainplt.dndapp.model.HelpDialog;
import com.romainplt.dndapp.model.MyViewModel;
import com.romainplt.dndapp.model.Race;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RaceFragment extends Fragment {

    SendRace SR;

    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioButton radioButtonHuman;
    private RadioButton radioButtonDwarf;
    private RadioButton radioButtonElf;
    private RadioButton radioButtonHalfElf;
    private RadioButton radioButtonHalfOrc;
    private RadioButton radioButtonGnome;
    private RadioButton radioButtonTieflin;
    private TextView textRace;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private Button questionButton;
    private RadioButton checkedRadioButton;
    PopupWindow popUp;

    private MyViewModel viewModel;
    private Race race;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.race_layout, parent, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {


        Race race = new Race();

        popUp = new PopupWindow();
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        nextButton = (ImageButton) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new ClassFragment());
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
                ft.replace(R.id.createCharacterLayout, new ClassFragment());
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
                alertDialog.setTitle(R.string.race);
                alertDialog.setMessage("Your race will give you some special abilities and other advantages or disadvantages. " +
                        "This is the first thing you should imagine about your character.");

                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();
            }
        });

        rg1 = (RadioGroup) getView().findViewById(R.id.raceRadioGroup1);
        rg2 = (RadioGroup) getView().findViewById(R.id.raceRadioGroup2);
        rg1.clearCheck(); // this is so we can start fresh, with no selection on both RadioGroups
        rg2.clearCheck();


        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);

        int chkId1 = rg1.getCheckedRadioButtonId();
        int chkId2 = rg2.getCheckedRadioButtonId();
        int realCheck = chkId1 == -1 ? chkId2 : chkId1;

        SR.sendData(race);


    }




    interface SendRace {
        void sendData(Race race);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SR = (SendRace) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }


    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != -1) {
                    rg2.setOnCheckedChangeListener(null); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
                    rg2.clearCheck(); // clear the second RadioGroup!
                    rg2.setOnCheckedChangeListener(listener2); //reset the listener

                }
                switch (checkedId){

                    case R.id.radioButton_Half_Orc:
                        //race.setRaceName("Half-Orc");
                        race.setRaceName("Half-Orc");
                        race.setHealthPointAdjustment(0);
                        String[] hOrcLanguage = {"Common", "Orc", "Gobelin"};
                        race.setLanguages(hOrcLanguage);

                        break;
                    case R.id.radioButton_Tieflin:
                        //race.setRaceName("Tieflin");
                        race.setRaceName("Tieflin");
                        race.setHealthPointAdjustment(0);
                        String[] tieflinfLanguage = {"Common", "Tieflin"};
                        race.setLanguages(tieflinfLanguage);
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
                }
                switch (checkedId) {
                    case R.id.radioButton_Human:
                        //race.setRaceName("Human");
                        race.setRaceName("Human");
                        race.setHealthPointAdjustment(0);
                        String[] humanLanguage = {"Common"};
                        race.setLanguages(humanLanguage);

                        break;
                    case R.id.radioButton_Dwarf:
                        //race.setRaceName("Dwarf");
                        race.setRaceName("Dwarf");
                        race.setHealthPointAdjustment(0);
                        String[] dwarfLanguage = {"Common", "Dwarf"};
                        race.setLanguages(dwarfLanguage);
                        break;
                    case R.id.radioButton_Elf:
                        //race.setRaceName("Elf");
                        race.setRaceName("Elf");
                        race.setHealthPointAdjustment(0);
                        String[] elfLanguage = {"Common", "Elf"};
                        race.setLanguages(elfLanguage);
                        break;
                    case R.id.radioButton_Half_Elf:
                        //race.setRaceName("Half-Elf");
                        race.setRaceName("Half-Elf");
                        race.setHealthPointAdjustment(0);
                        String[] hElfLanguage = {"Common", "Elf"};
                        race.setLanguages(hElfLanguage);
                        break;
                    case R.id.radioButton_Gnome:
                        //race.setRaceName("Gnome");
                        race.setRaceName("Gnome");
                        race.setHealthPointAdjustment(0);
                        String[] gnomeLanguage = {"Common", "Dwarf", "Gnome"};
                        race.setLanguages(gnomeLanguage);
                        break;


                }
            }
        };


}



