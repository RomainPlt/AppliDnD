package com.roro.appliDnD.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.roro.appliDnD.R;
import com.roro.appliDnD.model.Personnage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoricActivity extends AppCompatActivity {
    public android.view.MenuItem hist;
    Button histButton;
    Personnage perso;
    TextView textHisto;
    Button buttonNext;
    ArrayList<String> competences = new ArrayList<String>(2);
    public static final String EXTRA_PERSO = "EXTRA_PERSO";
    public static final String EXTRA_COMP = "EXTRA_COMP";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);
        histButton = findViewById(R.id.histButton);
        perso = (Personnage)getIntent().getSerializableExtra(yourStatActivity.EXTRA_PERSO);
        textHisto = findViewById(R.id.textHisto);
        textHisto.bringToFront();

        textHisto.setMovementMethod(new ScrollingMovementMethod());


    }

    public void showPopupHist(View v) {

        PopupMenu popupH = new PopupMenu(this, v);
        MenuInflater inflaterR = popupH.getMenuInflater();
        inflaterR.inflate(R.menu.historic_menu, popupH.getMenu());
        popupH.show();
        popupH.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                histButton.setText(item.getTitle());
                hist = item;
                switch (hist.getItemId()) {
                    case (R.id.Acolyte):
                        competences.add(0, "Perspicacité (SAG)");
                        competences.add(1, "Religion (INT)");

                        textHisto.setText("Compétences : Perspicacité, Religion \n \n Vous avez passé votre vie au service d'un temple dédié à un dieu " +
                                "particulier ou à un panthéon de dieux. ");
                        break;

                    case (R.id.Criminel):
                        competences.add(0, "Discrétion (DEX)");
                        competences.add(1, "Supercherie (CHA)");
                        textHisto.setText("Compétences : Discrétion, Supercherie \n \n Vous êtes un criminel habitué à enfreindre la loi. " +
                                "Vous avez des contacts dans le monde de la pègre.");
                        break;
                    case (R.id.Ermite):
                        competences.add(0, "Médecine (SAG)");
                        competences.add(1, "Religion (INT)");
                        textHisto.setText("Compétences : Médecine, Religion \n \n Vous avez vécu dans l'isolement pendant les années" +
                                "formatrices de votre vie. ");
                        break;
                    case (R.id.Soldat):
                        competences.add("Athlétisme (FOR)");
                        competences.add("Intimidation (CHA)");
                        textHisto.setText("Compétences : Athlétisme, Intimidation \n \n" +
                                "Aussi loin que remonte vos souvenirs, la guerre a toujours fait partie de votre vie. Dans votre jeunesse, " +
                                "vous vous êtes entraîné à maîtriser une arme et une armure et à maîtriser des techniques de survie de base.");
                        break;
                    case (R.id.Sauvageon):
                        competences.add(0, "Athlétisme (FOR=");
                        competences.add(1, "Survie (SAG)");
                        textHisto.setText("Compétences : Athlétisme, Survie \n \n " +
                                "Vous avez grandi dans les terres sauvages, loin de la civilisation et du confort des viles et de la " +
                                "technologie. Vous avez la vie sauvage dans le sang et vous comprenez le fonctionnement de la nature.");
                        break;
                }

                buttonNext = findViewById(R.id.buttonNext);
                buttonNext.setVisibility(buttonNext.VISIBLE);
                return false;

            }
        });
    }

    public void nextActivity(View v){

        perso.setHistoric(textHisto.getText().toString());
        perso.setCompetences(competences);

        Intent intent = new Intent(this, CompetencesActivity.class);
        //intent.putExtra(EXTRA_RACE, pRace);
        intent.putExtra(EXTRA_PERSO, perso);
        intent.putExtra(EXTRA_COMP, competences);
        startActivity(intent);
    }

    public static String[] addX(int n, String arr[], String x)
    {
        int i;

        // create a new ArrayList
        List<String> arrlist
                = new ArrayList<String>(Arrays.asList(arr));

        // Add the new element
        arrlist.add(x);

        // Convert the Arraylist to array
        arr = arrlist.toArray(arr);

        // return the array
        return arr;
    }


}
