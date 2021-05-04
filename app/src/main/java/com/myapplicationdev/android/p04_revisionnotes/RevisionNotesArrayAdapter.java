package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	private Context context;
	private ArrayList<Note> notes;
	private int resource;
//	ImageView iv1, iv2, iv3, iv4, iv5;

	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
		this.context = context;
		this.notes = notes;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// Inflate View
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(resource, parent, false);

		// Views
		TextView noteTV = rowView.findViewById(R.id.revision_note_text_view);
		RatingBar ratingBar = rowView.findViewById(R.id.rating_bar);

		// Get Data
		Note note = notes.get(position);

		// Set Data of Views
		noteTV.setText(note.getNotesContent());
		ratingBar.setNumStars(note.getStars());

		//Check if the property for starts >= 5, if so, "light" up the stars
//		if (/*stars >= 5*/) {
//			iv5.setImageResource(android.R.drawable.btn_star_big_on);
//			iv4.setImageResource(android.R.drawable.btn_star_big_on);
//			iv3.setImageResource(android.R.drawable.btn_star_big_on);
//			iv2.setImageResource(android.R.drawable.btn_star_big_on);
//			iv1.setImageResource(android.R.drawable.btn_star_big_on);
//		}

		return rowView;
	}



}
