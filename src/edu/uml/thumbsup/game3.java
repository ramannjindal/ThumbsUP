package edu.uml.thumbsup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class game3 extends Activity {
	/** Called when the activity is first created. */
	Spinner s1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game3);
		
		  s1 = (Spinner) findViewById(R.id.diffSpinner); 
		  ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( 
				  this, 
				  R.array.difficulty,
				  android.R.layout.simple_spinner_item);
		  adapter.setDropDownViewResource(
				  android.R.layout.simple_spinner_dropdown_item);
		  s1.setAdapter(adapter);
		  
	}

	public void myClickHandler(View view) {

		switch (view.getId()) {
		case R.id.startButton:
			Intent startGame = new Intent("edu.uml.thumbsup.CHEMGAMEACTIVITY");
			startGame.putExtra(
					"difficultySelection", 
					s1.getSelectedItem().toString()
					);
			startActivity(startGame);

			return;
		}
	}
}