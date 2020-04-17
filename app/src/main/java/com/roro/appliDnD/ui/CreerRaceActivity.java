package com.roro.appliDnD.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.roro.appliDnD.R;
import com.roro.appliDnD.model.DemiElfe;
import com.roro.appliDnD.model.DemiOrc;
import com.roro.appliDnD.model.Elfe;
import com.roro.appliDnD.model.Gnome;
import com.roro.appliDnD.model.Humain;
import com.roro.appliDnD.model.Nain;
import com.roro.appliDnD.model.PersoRace;
import com.roro.appliDnD.model.Personnage;

public class CreerRaceActivity extends AppCompatActivity {

    public static final String EXTRA_RACE = "EXTRA_RACE";
    public static final String EXTRA_PERSO = "EXTRA_PERSO";



    public android.view.MenuItem race;
    Button bRace;
    TextView textRace;
    PersoRace pRace = null;
    TextView textBonus;
    ImageView imageRace;
    Button buttonNext;
    public Personnage perso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_race);
        textRace = findViewById(R.id.textRace);
        textRace.setMovementMethod(new ScrollingMovementMethod());
        textRace.bringToFront();
        bRace = findViewById(R.id.buttonRace);
        textBonus = findViewById(R.id.textViewBonus);
        imageRace = findViewById(R.id.imageRace);
        textBonus.bringToFront();
    }


    public void showPopupRace(View v) {

        PopupMenu popupR = new PopupMenu(this, v);
        MenuInflater inflaterR = popupR.getMenuInflater();
        inflaterR.inflate(R.menu.race_menu, popupR.getMenu());
        popupR.show();
        popupR.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                bRace.setText(item.getTitle());
                race = item;
                buttonNext = findViewById(R.id.buttonNext);
                buttonNext.setVisibility(buttonNext.VISIBLE);
                switch (race.getItemId()){
                    case (R.id.Humain):
                        pRace = new Humain();
                        imageRace.setImageDrawable(getResources().getDrawable(R.drawable.humain));
                        break;
                    case(R.id.Elfe):
                        pRace = new Elfe();
                        imageRace.setImageDrawable(getResources().getDrawable(R.drawable.elf));

                        break;
                    case(R.id.Nain):
                        pRace = new Nain();
                        imageRace.setImageDrawable(getResources().getDrawable(R.drawable.nain));

                        break;
                    case(R.id.Gnome):
                        pRace = new Gnome();
                        imageRace.setImageDrawable(getResources().getDrawable(R.drawable.gnome));

                        break;
                    case(R.id.Demi_Elfe):
                        pRace = new DemiElfe();
                        imageRace.setImageDrawable(getResources().getDrawable(R.drawable.halfelf));

                        break;
                    case(R.id.Demi_Orc):
                        pRace = new DemiOrc();
                        imageRace.setImageDrawable(getResources().getDrawable(R.drawable.halforc));

                        break;
                }
                textRace.setText(pRace.getText());
                textBonus.setText(pRace.getBonus());


                return false;
            }
        });


    }

    public void nextActivity(View v){

        perso = new Personnage(null,0,null,null, pRace);


        Intent intent = new Intent(this, CreerClasseActivity.class);
        //intent.putExtra(EXTRA_RACE, pRace);
        intent.putExtra(EXTRA_PERSO, perso);
        startActivity(intent);
    }





}
