package com.roro.appliDnD.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

import com.roro.appliDnD.R;
import com.roro.appliDnD.model.PersoClass;
import com.roro.appliDnD.model.Personnage;
import com.roro.appliDnD.model.Warrior;

import java.util.ArrayList;

public class CompetencesActivity extends AppCompatActivity {

    ArrayList<String> persoComp;
    Personnage perso;
    CheckBox acrobatie;
    CheckBox arcanes;
    CheckBox athletisme;
    CheckBox discretion;
    CheckBox dressage;
    CheckBox escamotage;
    CheckBox histoire;
    CheckBox intimidation;
    CheckBox investigation;
    CheckBox medecine;
    CheckBox nature;
    CheckBox perception;
    CheckBox perspicacite;
    CheckBox persuasion;
    CheckBox religion;
    CheckBox representation;
    CheckBox supercherie;
    CheckBox survie;

    ArrayList<CheckBox> competences = new ArrayList<CheckBox>(18);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competences);
        perso = (Personnage)getIntent().getSerializableExtra(HistoricActivity.EXTRA_PERSO);
        persoComp = (ArrayList) getIntent().getStringArrayListExtra(HistoricActivity.EXTRA_COMP);

        acrobatie = (CheckBox) findViewById(R.id.checkBox9);
        arcanes = (CheckBox) findViewById(R.id.checkBox3);
        athletisme = (CheckBox) findViewById(R.id.checkBox2);
        discretion = (CheckBox) findViewById(R.id.checkBox4);
        dressage= (CheckBox) findViewById(R.id.checkBox18);
        escamotage= (CheckBox) findViewById(R.id.checkBox);
        histoire= (CheckBox) findViewById(R.id.checkBox5);
        intimidation= (CheckBox) findViewById(R.id.checkBox13);
        investigation= (CheckBox) findViewById(R.id.checkBox7);
        medecine= (CheckBox) findViewById(R.id.checkBox12);
        nature= (CheckBox) findViewById(R.id.checkBox8);
        perception= (CheckBox) findViewById(R.id.checkBox10);
        perspicacite= (CheckBox) findViewById(R.id.checkBox11);
        persuasion= (CheckBox) findViewById(R.id.checkBox14);
        religion= (CheckBox) findViewById(R.id.checkBox19);
        representation= (CheckBox) findViewById(R.id.checkBox15);
        supercherie= (CheckBox) findViewById(R.id.checkBox16);
        survie= (CheckBox) findViewById(R.id.checkBox17);

        competences.add(0, acrobatie);
        competences.add(1, arcanes);
        competences.add(2, athletisme);
        competences.add(3, discretion);
        competences.add(4, dressage);
        competences.add(5, escamotage);
        competences.add(6, histoire);
        competences.add(7, intimidation);
        competences.add(8, investigation);
        competences.add(9, medecine);
        competences.add(10, nature);
        competences.add(11, perception);
        competences.add(12, perspicacite);
        competences.add(13, persuasion);
        competences.add(14, religion);
        competences.add(15, representation);
        competences.add(16, supercherie);
        competences.add(17, survie);




        switch (perso.getClasse().getName()){
            case("Warrior"):
                arcanes.setEnabled(false);
                discretion.setEnabled(false);
                dressage.setEnabled(false);
                escamotage.setEnabled(false);
                investigation.setEnabled(false);
                nature.setEnabled(false);
                religion.setEnabled(false);
                supercherie.setEnabled(false);
                break;
            case("Barbarian"):
                arcanes.setEnabled(false);
                discretion.setEnabled(false);
                escamotage.setEnabled(false);
                histoire.setEnabled(false);
                investigation.setEnabled(false);
                perspicacite.setEnabled(false);
                religion.setEnabled(false);
                representation.setEnabled(false);
                supercherie.setEnabled(false);
                break;
            case("Mage"):
                acrobatie.setEnabled(false);
                athletisme.setEnabled(false);
                discretion.setEnabled(false);
                dressage.setEnabled(false);
                escamotage.setEnabled(false);
                supercherie.setEnabled(false);
                survie.setEnabled(false);
                break;
            case("Ranger"):
                arcanes.setEnabled(false);
                intimidation.setEnabled(false);
                religion.setEnabled(false);
                representation.setEnabled(false);
                persuasion.setEnabled(false);
                break;
            case("Thief"):
                arcanes.setEnabled(false);
                dressage.setEnabled(false);
                histoire.setEnabled(false);
                nature.setEnabled(false);
                religion.setEnabled(false);
                persuasion.setEnabled(false);
                representation.setEnabled(false);
                break;


        }

        for (CheckBox chk : competences){
            for (String s : persoComp){
                if (s.equals(chk.getText())){
                    chk.setChecked(true);
                    chk.setEnabled(false);
                }
            }
        }

        

    }
}
