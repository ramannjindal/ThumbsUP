package edu.uml.thumbsup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class game2 extends Activity{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game2);

		Button facts = (Button) findViewById(R.id.button01);
		facts.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), Facts.class);
				startActivityForResult(myIntent, 0);
			}

		});

		Button trivia = (Button) findViewById(R.id.button02);
		trivia.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(), Trivia.class);
				startActivityForResult(myIntent, 0);
			}

		});
	}
}
