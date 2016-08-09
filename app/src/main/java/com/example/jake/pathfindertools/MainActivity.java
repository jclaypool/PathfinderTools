package com.example.jake.pathfindertools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toEquipmentManager = (Button) findViewById(R.id.toEquipmentManager);
        toEquipmentManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //goToEquipmentManager();
                //could also do it this way
                startActivity(new Intent(MainActivity.this, EquipmentManager.class));
            }
        });
    }

    private void goToEquipmentManager(){
        Intent intent = new Intent(this, EquipmentManager.class);
        startActivity(intent);
    }



}
