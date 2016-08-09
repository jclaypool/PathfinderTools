package com.example.jake.pathfindertools;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EquipmentManager extends AppCompatActivity {
    public String returnText = "";
    public String headText = "";
    public String neckText = "";
    public String chestText = "";
    public String legsText = "";
    public String feetText = "";
    public String ring1Text = "";
    public String ring2Text = "";
    public String mainText = "";
    public String offhandText = "";
    public String backText = "";
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_manager);

        final Button headButton = (Button) findViewById(R.id.head);
        final Button neckButton = (Button) findViewById(R.id.neck);
        final Button chestButton = (Button) findViewById(R.id.chest);
        final Button legsButton = (Button) findViewById(R.id.legs);
        final Button feetButton = (Button) findViewById(R.id.feet);
        final Button mainButton = (Button) findViewById(R.id.main);
        final Button offhandButton = (Button) findViewById(R.id.offhand);
        final Button ring1Button = (Button) findViewById(R.id.ring1);
        final Button ring2Button = (Button) findViewById(R.id.ring2);
        final Button backButton = (Button) findViewById(R.id.back);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        headText = settings.getString("head","head");
        neckText = settings.getString("neck","neck");
        chestText = settings.getString("chest","chest");
        legsText = settings.getString("legs","legs");
        feetText = settings.getString("feet","feet");
        mainText = settings.getString("main","main");
        offhandText = settings.getString("offhand","offhand");
        ring1Text = settings.getString("ring1","ring1");
        ring2Text = settings.getString("ring2","ring2");
        backText = settings.getString("back","back");
        headButton.setText(headText);
        neckButton.setText(neckText);
        chestButton.setText(chestText);
        legsButton.setText(legsText);
        feetButton.setText(feetText);
        mainButton.setText(feetText);
        offhandButton.setText(offhandText);
        ring1Button.setText(ring1Text);
        ring2Button.setText(ring2Text);
        backButton.setText(backText);

        headButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                headText = setupTextEditor("head", headButton);
            }
        });

        neckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neckText = setupTextEditor("neck", neckButton);
            }
        });
        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                chestText = setupTextEditor("chest", chestButton);
            }
        });
        legsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                legsText = setupTextEditor("legs", legsButton);
            }
        });
        feetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                feetText = setupTextEditor("feet", feetButton);
            }
        });
        ring1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ring1Text = setupTextEditor("ring1", ring1Button);
            }
        });
        ring2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ring2Text = setupTextEditor("ring2", ring2Button);
            }
        });
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mainText = setupTextEditor("main", mainButton);
            }
        });
        offhandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                offhandText = setupTextEditor("offhand", offhandButton);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                offhandText = setupTextEditor("back", backButton);
            }
        });



    }

    private String setupTextEditor(final String typeText, final Button currentButton){
        returnText = "";
        AlertDialog.Builder builder = new AlertDialog.Builder(EquipmentManager.this);
        builder.setTitle(typeText);

        // Set up the input
        final EditText input = new EditText(EquipmentManager.this);
        // Specify the type of input expected
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                returnText = input.getText().toString();
                if (!returnText.equals("")){
                    currentButton.setBackgroundColor(Color.RED);
                }
                else{
                    currentButton.setBackgroundColor(Color.GRAY);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
        return returnText;

    }

    private String setUpItemViewer(final String typeText, final Button currentButton){
        Boolean editButton = false;
        AlertDialog.Builder itemDisplay = new AlertDialog.Builder(EquipmentManager.this);
        itemDisplay.setTitle(typeText);
        //want to show the text here
        itemDisplay.setMessage("sup chumps");
        //set up buttons to use
        itemDisplay.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        itemDisplay.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //editButton = true;
            }
        });

        if (editButton){
            return setupTextEditor(typeText, currentButton);
        }
        else{
            return "";
        }
    }
    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("head", headText);
        editor.putString("neck", neckText);
        editor.putString("chest", chestText);
        editor.putString("legs", legsText);
        editor.putString("feet", feetText);
        editor.putString("main", mainText);
        editor.putString("offhand", offhandText);
        editor.putString("ring1", ring1Text);
        editor.putString("ring2", ring2Text);
        editor.putString("back", backText);

        editor.commit();
    }
}
