package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.support.v7.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ArrayAdapter aa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		DBHelper db = new DBHelper(this);

		ListView listView = findViewById(R.id.lv);

		ArrayList<Note> notes = db.getAllNotes();
		aa = new RevisionNotesArrayAdapter(this, R.layout.row, notes);
		listView.setAdapter(aa);
	}


}
