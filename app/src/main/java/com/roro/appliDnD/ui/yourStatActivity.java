package com.roro.appliDnD.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.roro.appliDnD.R;
import com.roro.appliDnD.model.PersoClass;
import com.roro.appliDnD.model.PersoRace;
import com.roro.appliDnD.model.Personnage;

public class yourStatActivity extends AppCompatActivity {

    public static final String EXTRA_PERSO = "EXTRA_PERSO";
    private TextView option1, option2, option3, option4, option5, option6, choice1, choice2, choice3, choice4, choice5, choice6;
    public CharSequence dragData;

    int n1;
    int n2;
    int n3;
    int n4;
    int n5;
    int n6;
    
    int force;
    int sag;
    int dex;
    int con;
    int intel;
    int cha;
    

    Button buttonNext;

    PersoRace race;
    PersoClass classe;
    String name;
    String sex;
    int age;
    Personnage perso;

    TextView textFor;
    TextView textSag;
    TextView textDex;
    TextView textCon;
    TextView textInt;
    TextView textCha;

    public ImageView img;


    String msg;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_stat);
        n1 = (int) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_ONE);
        n2 = (int) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_TWO);
        n3 = (int) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_THREE);
        n4 = (int) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_FOUR);
        n5 = (int) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_FIVE);
        n6 = (int) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_SIX);
        //classe = (PersoClass) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_CLASSE);
        //race = (PersoRace) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_RACE);
        //name = (String) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_NAME);
        //sex = (String) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_SEX);
        //age = (int) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_AGE);
        perso = (Personnage) getIntent().getSerializableExtra(PersoCaractActivity.EXTRA_PERSO);

        //img = findViewById(R.id.myImage);

        buttonNext = findViewById(R.id.buttonNext);

        textFor = findViewById(R.id.textFor);
        int f = perso.getClasse().getBonusForce() + perso.getRace().getBonusForce();
        textFor.setText("Vous avez un bonus de + (" + f + ")");
        textSag = findViewById(R.id.textSag);
        int s = perso.getClasse().getBonusSagesse() + perso.getRace().getBonusSagesse();
        textSag.setText("Vous avez un bonus de + (" + s + ")");
        textDex = findViewById(R.id.textDex);
        int d = perso.getClasse().getBonusDexterite() + perso.getRace().getBonusDexterite();
        textDex.setText("Vous avez un bonus de + (" + d + ")");

        textCon = findViewById(R.id.textCon);
        int co = perso.getClasse().getBonusConstitution() + perso.getRace().getBonusConstitution();
        textCon.setText("Vous avez un bonus de + (" + co + ")");

        textInt = findViewById(R.id.textInt);
        int intel = perso.getClasse().getBonusIntelligence() + perso.getRace().getBonusIntelligence();
        textInt.setText("Vous avez un bonus de + (" + intel + ")");

        textCha = findViewById(R.id.textCha);
        int ch = perso.getClasse().getBonusCharisme() + perso.getRace().getBonusCharisme();
        textCha.setText("Vous avez un bonus de + (" + ch + ")");



        option1 = (TextView)findViewById(R.id.option_1);
        option2 = (TextView)findViewById(R.id.option_2);
        option3 = (TextView)findViewById(R.id.option_3);
        option4 = (TextView)findViewById(R.id.option_4);
        option5 = (TextView)findViewById(R.id.option_5);
        option6 = (TextView)findViewById(R.id.option_6);


        String forceText = "" + String.valueOf((n1));
        option1.setText(forceText);
        String sagesseText = "" + String.valueOf((n2));
        option2.setText(sagesseText);
        String dexText = "" + String.valueOf((n3));
        option3.setText(dexText);
        String conText = "" + String.valueOf((n4));
        option4.setText(conText);
        String intText = "" + String.valueOf((n5));
        option5.setText(intText);
        String chaText = "" + String.valueOf((n6));
        option6.setText(chaText);


        //views to drop onto
        choice1 = (TextView)findViewById(R.id.choice_1);
        choice2 = (TextView)findViewById(R.id.choice_2);
        choice3 = (TextView)findViewById(R.id.choice_3);
        choice4 = (TextView)findViewById(R.id.choice_4);
        choice5 = (TextView)findViewById(R.id.choice_5);
        choice6 = (TextView)findViewById(R.id.choice_6);

        //set touch listeners
        option1.setOnTouchListener(new ChoiceTouchListener());
        option2.setOnTouchListener(new ChoiceTouchListener());
        option3.setOnTouchListener(new ChoiceTouchListener());
        option4.setOnTouchListener(new ChoiceTouchListener());
        option5.setOnTouchListener(new ChoiceTouchListener());
        option6.setOnTouchListener(new ChoiceTouchListener());

        //set drag listeners
        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());
        choice5.setOnDragListener(new ChoiceDragListener());
        choice6.setOnDragListener(new ChoiceDragListener());

    }

    /**
     * ChoiceTouchListener will handle touch events on draggable views
     *
     */
    private final class ChoiceTouchListener implements View.OnTouchListener {
        @SuppressLint("NewApi")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                /*
                 * Drag details: we only need default behavior
                 * - clip data could be set to pass data as part of drag
                 * - shadow can be tailored
                 */
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * DragListener will handle dragged views being dropped on the drop area
     * - only the drop action will have processing added to it as we are not
     * - amending the default behavior for other parts of the drag process
     *
     */
    @SuppressLint("NewApi")
    private class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:

                    //handle the dragged view being dropped over a drop view
                    View view = (View) event.getLocalState();
                    //view dragged item is being dropped on
                    TextView dropTarget = (TextView) v;
                    //view being dragged and dropped
                    TextView dropped = (TextView) view;

                    //stop displaying the view where it was before it was dragged
                    //view.setVisibility(View.INVISIBLE);
                    view.setEnabled(false);
                    view.setBackgroundResource(R.drawable.parcho);

                    //update the text in the target view to reflect the data being dropped
                    dropTarget.setText(dropped.getText().toString());
                    //make it bold to highlight the fact that an item has been dropped
                    dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
                    //dropTarget.setTypeface(Typeface.SERIF);
                    //if an item has already been dropped here, there will be a tag
                    Object tag = dropTarget.getTag();
                    //if there is already an item here, set it back visible in its original place
                    if(tag!=null)
                    {
                        //the tag is the view id already dropped here
                        int existingID = (Integer)tag;
                        //set the original view visible again
                        findViewById(existingID).setVisibility(View.VISIBLE);
                    }
                    //set the tag in the target view being dropped on - to the ID of the view being dropped
                    dropTarget.setTag(dropped.getId());
                    //remove setOnDragListener by setting OnDragListener to null, so that no further drag & dropping on this TextView can be done
                    dropTarget.setOnDragListener(null);


                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    areAllPointsDistributed();

                    break;
                default:
                    break;
            }
            return true;
        }
    }

    public void areAllPointsDistributed(){
        if ((choice1.getTag() != null) && (choice2.getTag() != null)
        && (choice3.getTag() != null) && (choice4.getTag() != null)
        && (choice5.getTag() != null) && (choice6.getTag() != null)){
            buttonNext.setVisibility(buttonNext.VISIBLE);
        }
    }

    public void reset(View view)
    {
        buttonNext.setVisibility(buttonNext.GONE);
        option1.setVisibility(TextView.VISIBLE);
        option2.setVisibility(TextView.VISIBLE);
        option3.setVisibility(TextView.VISIBLE);
        option4.setVisibility(TextView.VISIBLE);
        option5.setVisibility(TextView.VISIBLE);
        option6.setVisibility(TextView.VISIBLE);

        String forceText = "" + String.valueOf((n1));
        option1.setText(forceText);
        option1.setEnabled(true);
        String sagesseText = "" + String.valueOf((n2));
        option2.setText(sagesseText);
        option2.setEnabled(true);
        String dexText = "" + String.valueOf((n3));
        option3.setText(dexText);
        option3.setEnabled(true);
        String conText = "" + String.valueOf((n4));
        option4.setText(conText);
        option4.setEnabled(true);
        String intText = "" + String.valueOf((n5));
        option5.setText(intText);
        option5.setEnabled(true);
        String chaText = "" + String.valueOf((n6));
        option6.setText(chaText);
        option6.setEnabled(true);


        choice1.setText("FOR");
        choice2.setText("SAG");
        choice3.setText("DEX");
        choice4.setText("CON");
        choice5.setText("INT");
        choice6.setText("CHA");

        choice1.setTag(null);
        choice2.setTag(null);
        choice3.setTag(null);
        choice4.setTag(null);
        choice5.setTag(null);
        choice6.setTag(null);

        choice1.setTypeface(Typeface.DEFAULT);
        choice2.setTypeface(Typeface.DEFAULT);
        choice3.setTypeface(Typeface.DEFAULT);
        choice4.setTypeface(Typeface.DEFAULT);
        choice5.setTypeface(Typeface.DEFAULT);
        choice6.setTypeface(Typeface.DEFAULT);

        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());
        choice5.setOnDragListener(new ChoiceDragListener());
        choice6.setOnDragListener(new ChoiceDragListener());
    }



    public void nextActivity(View v){

        force = Integer.valueOf((String) choice1.getText());
        sag = Integer.valueOf((String) choice2.getText());
        dex = Integer.valueOf((String) choice3.getText());
        con = Integer.valueOf((String) choice4.getText());
        intel = Integer.valueOf((String) choice5.getText());
        cha = Integer.valueOf((String) choice6.getText());

        perso.setForce(force);
        perso.setSagesse(sag);
        perso.setDexterite(dex);
        perso.setConstitution(con);
        perso.setIntelligence(intel);
        perso.setCharisme(cha);
        

        Intent intent = new Intent(this, HistoricActivity.class);
        //intent.putExtra(EXTRA_RACE, pRace);
        intent.putExtra(EXTRA_PERSO, perso);
        startActivity(intent);
    }



}


