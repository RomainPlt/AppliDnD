package com.romainplt.dndapp.ui.create;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Background;
import com.romainplt.dndapp.model.God;

import java.util.Objects;

public class GodFragment extends Fragment {

    private SendGod SG;
    private God god;
    private TextInputEditText name;
    private TextInputEditText description;
    private TextInputEditText alignment;
    private TextInputEditText domain;


    private ImageButton nextButton;
    private ImageButton prevButton;
    private Button questionButton;
    PopupWindow popUp;
    private Button okButton;
    private Button atheist;
    private Button erase;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.god_layout, parent, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        god = new God();
        name = getView().findViewById(R.id.godInput);
        description = getView().findViewById(R.id.godDescription);
        alignment = getView().findViewById(R.id.godAlignment);
        domain = getView().findViewById(R.id.godDomain);
        atheist = getView().findViewById(R.id.atheistButton);
        erase = getView().findViewById(R.id.eraseButton);

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
                ft.replace(R.id.createCharacterLayout, new BackgroundFragment());
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
                alertDialog.setTitle(R.string.god);
                alertDialog.setMessage("You can worship any god from your imagination. But you can also " +
                        "stay an evil atheist that probably think that he is better than all the Gods. Be careful " +
                        "not to vex them up, they could get angry.");

                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();
            }
        });

        atheist.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                alignment.setText("Atheist");
                name.setText("Atheist");
                domain.setText("Atheist");
                description.setText("Fucking Atheist");

                okButton.setEnabled(true);

            }
        });

        erase.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                alignment.setText("");
                name.setText("");
                domain.setText("");
                description.setText("");

            }
        });

        okButton = getView().findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                god.setAlignment((alignment.getText()).toString());
                god.setDescription((description.getText()).toString());
                god.setDomain((domain.getText()).toString());
                god.setName((name.getText()).toString());

                SG.sendData(god);
            }
        });



    }

    interface SendGod {
        void sendData(God god);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SG = (SendGod) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

}
