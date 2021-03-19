package com.romainplt.dndapp.ui.create;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Adventurer;
import com.romainplt.dndapp.model.Background;
import com.romainplt.dndapp.model.Classe;
import com.romainplt.dndapp.model.Description;
import com.romainplt.dndapp.model.God;
import com.romainplt.dndapp.model.MyViewModel;
import com.romainplt.dndapp.model.Race;
import com.romainplt.dndapp.model.Skills;

import java.util.List;

public class CreateCharacter extends AppCompatActivity implements RaceFragment.SendRace, WelcomeLayout.Letsgo,
        ClassFragment.SendClass, DetailsFragment.SendDescription, BackgroundFragment.SendBackground, GodFragment.SendGod,
        SkillsFragment.SendSkills{

    public CreateCharacter(){
        super(R.layout.create_character);
    }

    private Adventurer advanturer = new Adventurer();

    private Boolean letsGo;
    private Button next;
    private Button prev;

    private Spinner spinner;
    private List<String> mNavigationItems;
    private ArrayAdapter<CharSequence> mArrayAdapter;

    private MyViewModel viewModel;

    private TextView raceTextView;
    private Button finishButton;
    private Button characButton;
    private Button skillButton;
    private Button detailButton;
    private TextView nameView;
    private TextView classView;
    private TextView godView;
    private TextView backgroundView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.createCharacterLayout, new WelcomeLayout());
        ft.commit();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_black_18dp);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.dnd);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        myToolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_18dp);
        myToolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.baseline_menu_black_18dp));

        raceTextView = findViewById(R.id.raceView);

        finishButton = findViewById(R.id.finalButton);
        characButton = findViewById(R.id.characteristicsButton);
        skillButton = findViewById(R.id.buttonSkills);
        detailButton = findViewById(R.id.buttonDetails);
        nameView = findViewById(R.id.nameView);
        classView = findViewById(R.id.classView);
        godView = findViewById(R.id.godView);
        backgroundView = findViewById(R.id.backgroundView);


        detailButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                AlertDialog alertDialog = new AlertDialog.Builder(CreateCharacter.this).create(); //Read Update
                alertDialog.setTitle(R.string.details);
                alertDialog.setMessage("\n"
                + "Age : " + advanturer.getDescription().getAge() + " \n"
                + "Sex : " + advanturer.getDescription().getSex() + " \n"
                + "Eye color : " + advanturer.getDescription().getEyeColor() + " \n"
                + "Hair color : " + advanturer.getDescription().getHairColor() + " \n"
                + "Skin color : " + advanturer.getDescription().getSkinColor() + " \n"
                + "Height : " + advanturer.getDescription().getHeight() + " \n"
                + "Weight : " + advanturer.getDescription().getWeight() + " \n"
                + "Alignment : " + advanturer.getDescription().getAlignment());





                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();

            }


        });

        skillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(CreateCharacter.this).create(); //Read Update
                alertDialog.setTitle(R.string.skills);
                alertDialog.setMessage("\n"
                        + "Acrobatics :    " + advanturer.getSkills().getAcrobatics() + " | Animal Handling : " + advanturer.getSkills().getAnimalHandling() + " \n"
                        + "Arcana :          " + advanturer.getSkills().getArcana() +     " | Athletics : " + advanturer.getSkills().getAthletics() + " \n"
                        + "Deception :     " + advanturer.getSkills().getDeception() +  " | History : " + advanturer.getSkills().getHistory() + " \n"
                        + "Insight :          " + advanturer.getSkills().getInsight() +    " | Intimidation : " + advanturer.getSkills().getIntimidation() + " \n"
                        + "Investigation : " + advanturer.getSkills().getInvestigation() + " | Medicine : " + advanturer.getSkills().getMedicine() + " \n"
                        + "Nature   :        " + advanturer.getSkills().getNature() + " | Perception : " + advanturer.getSkills().getPerception() + " \n"
                        + "Performance  :" + advanturer.getSkills().getPerformance() + " | Persuasion : " + advanturer.getSkills().getPersuasion() + " \n"
                        + "Religion :        " + advanturer.getSkills().getReligion() + " | Sleight of hand : " + advanturer.getSkills().getSleightOfHand() + " \n"
                        + "Stealth  :        " + advanturer.getSkills().getStealth() + " | Survival : " + advanturer.getSkills().getSurvival() + " \n");

                alertDialog.setButton("OK !", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_item, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            //Back button

            case R.id.go_to_class:
                //addfav (heart icon) was clicked, Insert your after click code here.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void sendData(Race race) {
        if (race != null){
            raceTextView.setText(race.getRaceName());
            raceTextView.setAllCaps(true);
            raceTextView.setTextColor(Color.parseColor("#BA0303"));
            advanturer.setRace(race);
        }


    }

    @Override
    public void sendOK() {
        raceTextView.setVisibility(View.VISIBLE);
        finishButton.setVisibility(View.VISIBLE);
        characButton.setVisibility(View.VISIBLE);
        skillButton.setVisibility(View.VISIBLE);
        detailButton.setVisibility(View.VISIBLE);
        nameView.setVisibility(View.VISIBLE);
        classView.setVisibility(View.VISIBLE);
        godView.setVisibility(View.VISIBLE);
        backgroundView.setVisibility(View.VISIBLE);

    }

    @Override
    public void sendData(Classe classe) {
        if (classe != null) {
            classView.setText(classe.getClasseName());
            classView.setAllCaps(true);
            classView.setTextColor(Color.parseColor("#BA0303"));
            advanturer.setClasse(classe);
        }
    }

    @Override
    public void sendData(Description description) {
        detailButton.setTextColor(Color.parseColor("#BA0303"));
        detailButton.setEnabled(true);
        advanturer.setDescription(description);

    }

    @Override
    public void sendData(Background background) {
        if (background != null){
            backgroundView.setText(background.getName());
            backgroundView.setAllCaps(true);
            backgroundView.setTextColor(Color.parseColor("#BA0303"));
            advanturer.setBackground(background);
        }
    }

    @Override
    public void sendData(God god) {
        if (god.getName().equals("")){
            godView.setText("Atheist");
            god.setName("Atheist");
            god.setDescription("Fucking Atheist");
            god.setDomain("Atheist");
            god.setAlignment("Atheist");
        } else {
            godView.setText(god.getName());
        }
        godView.setTextColor(Color.parseColor("#BA0303"));
        godView.setAllCaps(true);
        advanturer.setGod(god);
    }

    @Override
    public void sendData(Skills skills) {
        skillButton.setTextColor(Color.parseColor("#BA0303"));
        advanturer.setSkills(skills);
        skillButton.setEnabled(true);
    }
}
