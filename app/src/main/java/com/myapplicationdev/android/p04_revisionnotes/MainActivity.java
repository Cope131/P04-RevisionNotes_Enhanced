package com.myapplicationdev.android.p04_revisionnotes;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonInsertNote, buttonShowList;
    EditText editTextNote;
    RadioGroup radioGroupStars;
    RadioButton radioGroupStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsertNote = findViewById(R.id.buttonInsertNote);
        buttonShowList = findViewById(R.id.buttonShowList);
        editTextNote = findViewById(R.id.editTextNote);
        radioGroupStars = findViewById(R.id.radioGroupStars);

        buttonInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroupStar = findViewById(radioGroupStars.getCheckedRadioButtonId());
                DBHelper db = new DBHelper(MainActivity.this);
                if(Integer.valueOf(radioGroupStar.getText().toString()) > 0 && !editTextNote.getText().toString().isEmpty()){
                    db.insertNote(editTextNote.getText().toString(), Integer.valueOf(radioGroupStar.getText().toString()));
                    Log.d("Insert Database", "added into database");
                }else{
                    Log.d("Insert Database", "failed");
                }
            }
        });

        buttonShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
