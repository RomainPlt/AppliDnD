package com.romainplt.dndapp.ui.create;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.romainplt.dndapp.R;
import com.romainplt.dndapp.model.Advanturer;
import com.romainplt.dndapp.model.Classe;
import com.romainplt.dndapp.model.MyViewModel;
import com.romainplt.dndapp.model.Race;

import java.util.List;

public class CreateCharacter extends AppCompatActivity implements RaceFragment.SendRace, WelcomeLayout.Letsgo, ClassFragment.SendClass {

    public CreateCharacter(){
        super(R.layout.create_character);
    }

    private Advanturer advanturer = new Advanturer();

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
        raceTextView.setText(race.getRaceName());
        raceTextView.setAllCaps(true);
        raceTextView.setTextColor(Color.parseColor("#BA0303"));
        advanturer.setRace(race);

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
        classView.setText(classe.getClasseName());
        classView.setAllCaps(true);
        classView.setTextColor(Color.parseColor("#BA0303"));
        advanturer.setClasse(classe);
    }
}
