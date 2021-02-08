package com.romainplt.dndapp.ui.create;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.InputDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Classe;
import com.romainplt.dndapp.model.Description;
import com.romainplt.dndapp.model.Race;

import java.util.Objects;

public class DetailsFragment extends Fragment {

    private Character character;
    private Description description;

    private TextView textClass;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private Button questionButton;
    PopupWindow popUp;

    private RadioButton radioSex;
    private RadioGroup rg;
    private SeekBar ageBar;
    private SeekBar heightBar;
    private SeekBar weightBar;
    private TextView weightView;
    private TextView heightView;
    private TextView ageView;
    private TextView alignmentView;
    private TextInputLayout hair;
    private TextInputLayout eye;
    private TextInputLayout skin;
    private TableLayout alignmentTable;
    private Button LG;
    private Button LN;
    private Button LE;
    private Button NG;
    private Button NN;
    private Button NE;
    private Button CG;
    private Button CN;
    private Button CE;

    private String hairColor;
    private String eyeColor;
    private String skinColor;
    private String age;
    private String alignment;
    private String height;
    private String weight;
    private String sex;

    private RadioButton male;
    private RadioButton female;
    private Boolean[] ischecked;



    private Button okButton;
    private SendDescription SD;


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.details_layout, parent, false);
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        ischecked = new Boolean[8];
        ischecked[0] = false;
        ischecked[1] = false;
        ischecked[2] = false;
        ischecked[3] = false;
        ischecked[4] = false;
        ischecked[5] = false;
        ischecked[6] = false;
        ischecked[7] = false;


        description = new Description();

        alignmentView = getView().findViewById(R.id.alignmentView);

        ageBar = getView().findViewById(R.id.ageBar);
        ageBar.setMax(2);
        ageBar.setProgress(1);

        ageView = getView().findViewById(R.id.ageView);
        skin = getView().findViewById(R.id.inputSkin);
        eye = getView().findViewById(R.id.inputEye);
        hair = getView().findViewById(R.id.inputHair);

        ageBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            // When Progress value changed.
            @Override public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                ischecked[0] = true;
                switch (progress) {
                    case 0:
                        ageView.setText("Young");
                        break;

                    case 1:
                        ageView.setText("Normal");
                        break;
                    case 2:
                        ageView.setText("Old");
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        weightBar = getView().findViewById(R.id.weightBar);
        weightBar.setMax(6);
        weightBar.setProgress(3);
        heightBar = getView().findViewById(R.id.heightBar);
        heightBar.setMax(8);
        heightBar.setProgress(4);
        heightView = getView().findViewById(R.id.heightView);
        weightView = getView().findViewById(R.id.weightView);


        weightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            // When Progress value changed.
            @Override public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                ischecked[1] = true;
                switch (progress) {
                    case 0:
                        weightView.setText("Squeletton");
                        break;

                    case 1:
                        weightView.setText("Thin");
                        break;
                    case 2:
                        weightView.setText("Fit");
                        break;
                    case 3:
                        weightView.setText("Normal");
                        break;
                    case 4:
                        weightView.setText("Chubby");
                        break;
                    case 5:
                        weightView.setText("Fat");
                        break;
                    case 6:
                        weightView.setText("Musclor");
                        break;

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        heightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            // When Progress value changed.
            @Override public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                ischecked[2] = true;
                switch (progress) {
                    case 0:
                        heightView.setText("Tiny");
                        break;

                    case 1:
                        heightView.setText("Very Small");
                        break;
                    case 2:
                        heightView.setText("Small");
                        break;
                    case 3:
                        heightView.setText("Not very tall");
                        break;
                    case 4:
                        heightView.setText("Normal");
                        break;
                    case 5:
                        heightView.setText("Taller than normal");
                        break;
                    case 6:
                        heightView.setText("Tall");
                        break;
                    case 7:
                        heightView.setText("Very tall");
                        break;
                    case 8:
                        heightView.setText("Gigantic");
                        break;


                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        popUp = new PopupWindow();
        nextButton = (ImageButton) view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new BackgroundFragment());
                ft.commit();
            }
        });

        prevButton = (ImageButton) view.findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new ClassFragment());
                ft.commit();
            }
        });

        questionButton = (Button) view.findViewById(R.id.questionButton);
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create(); //Read Update
                alertDialog.setTitle(R.string.details);
                alertDialog.setMessage("Here you can enter every details you want about your character. " +
                        "Customize your imagination ! ");

                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();
            }
        });

        rg = (RadioGroup) getView().findViewById(R.id.radioGroupSex);
        int checkedID = rg.getCheckedRadioButtonId();

        male = getView().findViewById(R.id.male);
        female = getView().findViewById(R.id.female);

        okButton = getView().findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                if (male.isChecked()){
                    description.setSex(male.getText().toString());
                }
                if (female.isChecked()){
                    description.setSex(female.getText().toString());
                }
                description.setAlignment(alignmentView.getText().toString());
                description.setAge(ageView.getText().toString());
                description.setSkinColor(Objects.requireNonNull(skin.getEditText()).getText().toString());

                System.out.println(description.getSex());
                description.setHairColor(Objects.requireNonNull(hair.getEditText()).getText().toString());
                description.setEyeColor(Objects.requireNonNull(eye.getEditText()).getText().toString());
                description.setHeight(heightView.getText().toString());
                description.setWeight(weightView.getText().toString());
                SD.sendData(description);

            }


        });

        LG = getView().findViewById(R.id.LG);
        LG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Loyal Good");
                ischecked[3] = true;

            }
        });
        LN = getView().findViewById(R.id.LN);
        LN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Loyal Neutral");
                ischecked[3] = true;
            }
        });
        LE = getView().findViewById(R.id.LE);
        LE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Loyal Evil");
                ischecked[3] = true;
            }
        });
        NG = getView().findViewById(R.id.NG);
        NG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Neutral Good");
            }
        });
        NN = getView().findViewById(R.id.NN);
        NN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("True Neutral");
                ischecked[3] = true;
            }
        });
        NE = getView().findViewById(R.id.NE);
        NE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Neutral Evil");
                ischecked[3] = true;
            }
        });
        CG = getView().findViewById(R.id.CG);
        CG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Chaotic Good");
                ischecked[3] = true;
            }
        });
        CN = getView().findViewById(R.id.CN);
        CN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Chaotic Neutral");
                ischecked[3] = true;
            }
        });
        CE = getView().findViewById(R.id.CE);
        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alignmentView.setText("Chaotic Evil");
                ischecked[3] = true;
            }
        });

    }







    interface SendDescription {
        void sendData(Description description);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SD = (SendDescription) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

}

