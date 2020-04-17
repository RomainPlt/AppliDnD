package com.roro.appliDnD.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.roro.appliDnD.R;
import com.roro.appliDnD.model.PersoClass;
import com.roro.appliDnD.model.PersoRace;
import com.roro.appliDnD.model.Personnage;

public class PersoCaractActivity extends AppCompatActivity {

    public static final String EXTRA_ONE = "EXTRA_ONE";
    public static final String EXTRA_TWO = "EXTRA_TWO";
    public static final String EXTRA_THREE = "EXTRA_THREE";
    public static final String EXTRA_FOUR = "EXTRA_FOUR";
    public static final String EXTRA_FIVE = "EXTRA_FIVE";
    public static final String EXTRA_SIX = "EXTRA_SIX";
    public static final String EXTRA_RACE = "EXTRA_RACE";
    public static final String EXTRA_CLASSE = "EXTRA_CLASSE";
    public static final String EXTRA_SEX = "EXTRA_SEX";
    public static final String EXTRA_AGE = "EXTRA_AGE";
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_PERSO = "EXTRA_PERSO";




    PersoRace race;
    PersoClass classe;
    String name;
    String sex;
    int age;
    Button roll1;
    Button roll2;
    Button roll3;
    Button roll4;
    Button roll5;
    Button roll6;



    int n1;
    int n2;
    int n3;
    int n4;
    int n5;
    int n6;


    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    public Personnage perso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso_caract);
        //race = (PersoRace) getIntent().getSerializableExtra(PersoActivity.EXTRA_RACE);
        //classe = (PersoClass) getIntent().getSerializableExtra(PersoActivity.EXTRA_CLASSE);
        //name = (String) getIntent().getSerializableExtra(PersoActivity.EXTRA_NAME);
        //age = getIntent().getIntExtra(PersoActivity.EXTRA_AGE, 10);
        //sex = (String) getIntent().getSerializableExtra(PersoActivity.EXTRA_SEX);
        perso = (Personnage) getIntent().getSerializableExtra(PersoActivity.EXTRA_PERSO);

        //perso = new Personnage(name, age, sex, classe, race);
        //textVie = findViewById(R.id.textVie);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);

        /*
        force = perso.getForce();
        sagesse = perso.getSagesse();
        dexterite = perso.getDexterite();
        constitution = perso.getConstitution();
        intelligence = perso.getIntelligence();
        charisme = perso.getCharisme();*/

        /*textVie.setText("   PV : ");

        rollVie = findViewById(R.id.rollVie);
        rollVie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vie = ("   PV : " + perso.getPtVie());
                textVie.setText(vie);
                rollVie.setEnabled(false);
            }
        });*/

        roll1 = findViewById(R.id.roll1);
        //textF.setText("  FOR : ");
        roll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = (getRandomIntegerBetweenRange(1,6) + getRandomIntegerBetweenRange(1,6) +getRandomIntegerBetweenRange(1,6));
                String oneText = ("" + (n1));
                text1.setText(oneText);
                roll1.setEnabled(false);

            }
        });
        roll2 = findViewById(R.id.roll2);
        //textS.setText("  SAG : ");
        roll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n2 =(getRandomIntegerBetweenRange(1,6) + getRandomIntegerBetweenRange(1,6) +getRandomIntegerBetweenRange(1,6));
                String twoText = ("" + n2);
                text2.setText(twoText);
                roll2.setEnabled(false);
            }
        });
        roll3 = findViewById(R.id.roll3);
        //textD.setText("  DEX : ");
        roll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n3 = (getRandomIntegerBetweenRange(1,6) + getRandomIntegerBetweenRange(1,6) +getRandomIntegerBetweenRange(1,6));
                String threeText = ("" + n3);
                text3.setText(threeText);
                roll3.setEnabled(false);
            }
        });
        roll4 = findViewById(R.id.roll4);
        //textCo.setText("  CON : " );
        roll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n4 = (getRandomIntegerBetweenRange(1,6) + getRandomIntegerBetweenRange(1,6) +getRandomIntegerBetweenRange(1,6));
                String fourText = ("" + n4);
                text4.setText(fourText);
                roll4.setEnabled(false);
            }
        });
        roll5 = findViewById(R.id.roll5);
        //textI.setText("  INT : ");
        roll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n5 = (getRandomIntegerBetweenRange(1,6) + getRandomIntegerBetweenRange(1,6) +getRandomIntegerBetweenRange(1,6));
                String fiveText = ("" + n5);
                text5.setText(fiveText);
                roll5.setEnabled(false);
            }
        });
        roll6 = findViewById(R.id.roll6);
        //textCh.setText("  CHA : ");
        roll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n6 = (getRandomIntegerBetweenRange(1,6) + getRandomIntegerBetweenRange(1,6) +getRandomIntegerBetweenRange(1,6));
                String sixText = ("" + n6);
                text6.setText(sixText);
                roll6.setEnabled(false);
            }
        });

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);

    }


    public void nextActivity(View v) {

        Intent intent = new Intent(this, yourStatActivity.class);
        intent.putExtra(EXTRA_ONE, n1);
        intent.putExtra(EXTRA_TWO, n2);
        intent.putExtra(EXTRA_THREE, n3);
        intent.putExtra(EXTRA_FOUR, n4);
        intent.putExtra(EXTRA_FIVE, n5);
        intent.putExtra(EXTRA_SIX, n6);
        //intent.putExtra(EXTRA_NAME, name);
        //intent.putExtra(EXTRA_RACE, race);
        //intent.putExtra(EXTRA_CLASSE, classe);
        //intent.putExtra(EXTRA_AGE, age);
        // intent.putExtra(EXTRA_SEX, sex);
        intent.putExtra(EXTRA_PERSO, perso);
        startActivity(intent);

    }

    public static int getRandomIntegerBetweenRange(double min, double max){

        int x = (int) ((Math.random()*((max-min)+1))+min);

        return x;

    }
}
