package com.abigail.burgercaloriecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    // Task 1: Declare UI objects to be referenced
        private RadioGroup pattyRG;
        private CheckBox prosciuttoCBX;
        private RadioGroup cheeseRG;
        private SeekBar sauceSBR;
        private TextView caloriesTV;

    // Task 2: Declare variables for computing calories
        private Burger burger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // Task 4: Initialize UI objects and variables
            burger = new Burger();
            initialize();

        // Task 5: Register change listeners
            registerChangeListener();
    }

    private void initialize(){

        //Task 6: Get reference to each of the UI components
            pattyRG = (RadioGroup) findViewById(R.id.radioGroup);
            prosciuttoCBX = (CheckBox) findViewById(R.id.checkBox);
            cheeseRG = (RadioGroup) findViewById(R.id.radioGroup2);
            sauceSBR = (SeekBar) findViewById(R.id.seekBar);
            caloriesTV = (TextView) findViewById(R.id.textView3);

            displayCalories();
    }

    private void registerChangeListener(){

        pattyRG.setOnCheckedChangeListener(foodListner);
        prosciuttoCBX.setOnClickListener(baconListener);
        cheeseRG.setOnCheckedChangeListener(foodListner);
        sauceSBR.setOnSeekBarChangeListener(sauceListner);
    }

    private OnCheckedChangeListener foodListner = new
            OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {

                    switch (i){
                        case R.id.radioButton: // Beef patty
                            burger.setPattyCalories(Burger.Beef);
                            break;

                        case R.id.radioButton2: // Lamb patty
                            burger.setPattyCalories(Burger.Lamb);
                            break;

                        case R.id.radioButton3: // Ostrich patty
                            burger.setPattyCalories(Burger.Ostrich);
                            break;

                        case R.id.radioButton4: // Asiago cheese
                            burger.setCheeseCalories(Burger.Asiago);
                            break;

                        case R.id.radioButton5: // Creme Fraiche
                            burger.setCheeseCalories(Burger.Creme_Fraiche);
                    }
                    displayCalories();
                }
            };

    private OnClickListener baconListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (((CheckBox) view).isChecked())
                burger.setProsciuttoCalories(Burger.Prosciutto);
            else
                burger.clearProsciuttoCalories();

            displayCalories();
        }
    };

    private OnSeekBarChangeListener sauceListner = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void displayCalories(){
        // Construct an output string and display in the textview

        String calorieText = "Calories: " + burger.getTotalCalories();
        caloriesTV.setText(calorieText);
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in the AndroidManifest.xml.

           int id = item.getItemId();
           if (id == R.id.action_setting) {
               return true;
           }
           return super.onOptionsItemSelected(item);
        }
}
