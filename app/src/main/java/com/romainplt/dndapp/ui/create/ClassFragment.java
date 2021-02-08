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
import com.romainplt.dndapp.model.Classe;
import com.romainplt.dndapp.model.Race;

public class ClassFragment extends Fragment {

    private Character character;
    private Race race;


    private RadioGroup rg1;
    private RadioGroup rg2;
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

    private Classe classe = new Classe();
    private Button okButton;
    private SendClass SC;


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
                ft.replace(R.id.createCharacterLayout, new DetailsFragment());
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

        rg1 = (RadioGroup) getView().findViewById(R.id.classRadioGroup1);
        rg2 = (RadioGroup) getView().findViewById(R.id.classRadioGroup2);
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
                SC.sendData(classe);
            }
        });



    }

    interface SendClass {
        void sendData(Classe classe);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SC = (SendClass) getActivity();
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
                okButton = getView().findViewById(R.id.okButton);
                okButton.setEnabled(true);
            }

            switch (checkedId) {

                case R.id.radioButton_Warrior:
                    classe.setClasseName("Warrior");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Thief:
                    classe.setClasseName("Thief");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Sorcerer:
                    classe.setClasseName("Sorcerer");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Magician:
                    classe.setClasseName("Magician");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Assassin:
                    classe.setClasseName("Assassin");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Monk:
                    classe.setClasseName("Monk");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Ranger:
                    classe.setClasseName("Ranger");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Priest:
                    classe.setClasseName("Priest");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Druid:
                    classe.setClasseName("Druid");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Barbarian:
                    classe.setClasseName("Barbarian");
                    classe.setHealthPointAdjustment(0);

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

                case R.id.radioButton_Warrior:
                    classe.setClasseName("Warrior");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Thief:
                    classe.setClasseName("Thief");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Sorcerer:
                    classe.setClasseName("Sorcerer");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Magician:
                    classe.setClasseName("Illusionist");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Assassin:
                    classe.setClasseName("Assassin");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Monk:
                    classe.setClasseName("Monk");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Ranger:
                    classe.setClasseName("Ranger");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Priest:
                    classe.setClasseName("Priest");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Druid:
                    classe.setClasseName("Druid");
                    classe.setHealthPointAdjustment(0);

                    break;
                case R.id.radioButton_Barbarian:
                    classe.setClasseName("Barbarian");
                    classe.setHealthPointAdjustment(0);

                    break;

            }
        }
    };

}

