package com.roro.appliDnD.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.roro.appliDnD.R;
import com.roro.appliDnD.model.Barbarian;
import com.roro.appliDnD.model.Clerc;
import com.roro.appliDnD.model.Mage;
import com.roro.appliDnD.model.PersoClass;
import com.roro.appliDnD.model.PersoRace;
import com.roro.appliDnD.model.Personnage;
import com.roro.appliDnD.model.Ranger;
import com.roro.appliDnD.model.Thief;
import com.roro.appliDnD.model.Warrior;

public class CreerClasseActivity extends AppCompatActivity {

    public android.view.MenuItem classe;
    public static final String EXTRA_CLASSE = "EXTRA_CLASSE";
    public static final String EXTRA_RACE = "EXTRA_RACE";
    public static final String EXTRA_PERSO = "EXTRA_PERSO";

    PersoRace race; //Pas utile sur cette activité, à passer à la suivante
    Button bClass;
    TextView textClass;
    PersoClass pClass = null;
    TextView textBonus;
    ImageView imageClass;
    Button buttonNext;
    public Personnage perso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_classe);

        perso = (Personnage)getIntent().getSerializableExtra(CreerRaceActivity.EXTRA_PERSO);

        //race = (PersoRace) getIntent().getSerializableExtra(CreerRaceActivity.EXTRA_RACE);

        bClass = findViewById(R.id.buttonClass);
        textClass = findViewById(R.id.textClass);
        textClass.setMovementMethod(new ScrollingMovementMethod());
        textClass.bringToFront();
        textBonus = findViewById(R.id.textViewBonus);
        imageClass = findViewById(R.id.imageClass);
        textBonus.bringToFront();
    }


    public void showPopupClass(View v) {

        PopupMenu popupC = new PopupMenu(this, v);
        MenuInflater inflaterR = popupC.getMenuInflater();
        inflaterR.inflate(R.menu.class_menu, popupC.getMenu());
        popupC.show();
        popupC.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                bClass.setText(item.getTitle());
                classe = item;
                buttonNext = findViewById(R.id.buttonNext);
                buttonNext.setVisibility(buttonNext.VISIBLE);
                switch (classe.getItemId()){
                    case (R.id.Warrior):
                        pClass = new Warrior();
                        imageClass.setImageDrawable(getResources().getDrawable(R.drawable.warrior));
                        break;
                    case(R.id.Mage):
                        pClass = new Mage();
                        imageClass.setImageDrawable(getResources().getDrawable(R.drawable.mage));

                        break;
                    case(R.id.Thief):
                        pClass = new Thief();
                        imageClass.setImageDrawable(getResources().getDrawable(R.drawable.thief));

                        break;
                    case(R.id.Ranger):
                        pClass = new Ranger();
                        imageClass.setImageDrawable(getResources().getDrawable(R.drawable.ranger));

                        break;
                    case(R.id.Clerc):
                        pClass = new Clerc();
                        imageClass.setImageDrawable(getResources().getDrawable(R.drawable.clerc));

                        break;
                    case(R.id.Barbarian):
                        pClass = new Barbarian();
                        imageClass.setImageDrawable(getResources().getDrawable(R.drawable.barbarian));

                        break;
                }
                textClass.setText(pClass.getText());
                textBonus.setText(pClass.getBonus());
                return false;
            }
        });
    }

    public void nextActivity(View v){

        perso.setClasse(pClass);
        Intent intent = new Intent(this, PersoActivity.class);
        //intent.putExtra(EXTRA_CLASSE, pClass);
        //intent.putExtra(EXTRA_RACE, race);
        intent.putExtra(EXTRA_PERSO, perso);
        startActivity(intent);
    }
}
