package com.romainplt.dndapp.ui.create;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Race;


public class WelcomeLayout extends Fragment {

    private Letsgo go;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.welcome_create_character, parent, false);
        Button button = (Button) view.findViewById(R.id.goButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                go.sendOK();

                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.createCharacterLayout, new RaceFragment());
                ft.commit();
            }
        });
        return view;
    }

    public void onViewCreated(android.view.View view, Bundle savedInstanceState) {

    }

    interface Letsgo {
        void sendOK();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            go = (Letsgo) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
