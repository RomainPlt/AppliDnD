package com.roro.appliDnD.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;

import com.roro.appliDnD.R;
import com.roro.appliDnD.model.PersoClass;
import com.roro.appliDnD.model.PersoRace;
import com.roro.appliDnD.model.Personnage;

public class PersoActivity extends AppCompatActivity {

    public static final String EXTRA_CLASSE = "EXTRA_CLASSE";
    public static final String EXTRA_RACE = "EXTRA_RACE";
    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_SEX = "EXTRA_SEX";
    public static final String EXTRA_AGE = "EXTRA_AGE";
    public static final String EXTRA_PERSO = "EXTRA_PERSO";


    PersoRace race;
    PersoClass classe;
    EditText textName;
    TextView textAge;
    SeekBar simpleSeekBar;
    TextView viewAge;
    int age;
    Button buttonSex;
    Button buttonNext;
    String sex;
    Boolean isSexOn = false;
    public Personnage perso;

    private void setButtonNextOn(){
        buttonNext = findViewById(R.id.buttonNext);
        if ((age != 0) &&  (!textName.getText().toString().equals("")) && (isSexOn)){

            buttonNext.setVisibility(buttonNext.VISIBLE);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso);
        perso = (Personnage) getIntent().getSerializableExtra(CreerClasseActivity.EXTRA_PERSO);
        //race = (PersoRace) getIntent().getSerializableExtra(CreerClasseActivity.EXTRA_RACE);
        //classe = (PersoClass) getIntent().getSerializableExtra(CreerClasseActivity.EXTRA_CLASSE);

        textName = findViewById(R.id.textName);
        textName.bringToFront();

        textName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setButtonNextOn();
            }
        });


        textAge = findViewById(R.id.textAge);
        viewAge = findViewById(R.id.viewAge);
        buttonSex = findViewById(R.id.buttonSex);
        viewAge.bringToFront();
        textAge.bringToFront();
        simpleSeekBar = findViewById(R.id.seekBar);
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                viewAge.setText(progressChangedValue + " yo");
                age = progress;


            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                viewAge.setText(progressChangedValue + " yo");
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                viewAge.setText(progressChangedValue + " yo");
                setButtonNextOn();
            }
        });
    }

    public void showPopupSex(View v){
        PopupMenu popupS = new PopupMenu(this, v);
        MenuInflater inflaterS = popupS.getMenuInflater();
        inflaterS.inflate(R.menu.sex_menu, popupS.getMenu());
        popupS.show();
        popupS.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                isSexOn = true;
                buttonSex.setText(item.getTitle());
                sex = item.getTitle().toString();
                setButtonNextOn();
                return false;
            }
        });
    }

    public void nextActivity(View v) {
        String name = ((EditText)findViewById(R.id.textName)).getText().toString();

        perso.setName(name);
        perso.setAge(age);
        perso.setSex(sex);
        Intent intent = new Intent(this, PersoCaractActivity.class);
        //intent.putExtra(EXTRA_NAME, name);
        //intent.putExtra(EXTRA_SEX, sex);
        //intent.putExtra(EXTRA_AGE, age);
        //intent.putExtra(EXTRA_CLASSE, classe);
        //intent.putExtra(EXTRA_RACE, race);
        intent.putExtra(EXTRA_PERSO,perso);
        startActivity(intent);

    }

}
