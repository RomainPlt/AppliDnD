package com.romainplt.dndapp.ui.create;

import android.content.ClipData;
import android.os.Bundle;
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

public class CreateCharacter extends AppCompatActivity implements RaceFragment.SendRace{

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

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getRace().observe(this, item -> {

            // Perform an action with the latest item data
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
        advanturer.setRace(race);
    }

}
