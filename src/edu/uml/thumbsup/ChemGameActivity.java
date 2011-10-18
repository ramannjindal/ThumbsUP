package edu.uml.thumbsup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChemGameActivity extends Activity {
	/** Called when the activity is first created. */
	LinearLayout gameUI;
	EditText editField1;
	EditText editField2;
	EditText editField3;
	EditText editField4;
	EditText editField5;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.chem_game);
		editField1 = (EditText) findViewById(R.id.editText1);
		editField2 = (EditText) findViewById(R.id.editText2);
		editField3 = (EditText) findViewById(R.id.editText3);
		editField4 = (EditText) findViewById(R.id.editText4);
		editField5 = (EditText) findViewById(R.id.editText5);
		
		editField1.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
		    	
			}
			
		    @Override
		    public void afterTextChanged(Editable s) {
		        // TODO Auto-generated method stub
		    	validate(editField1);
		    }
		    
		});
		
		//Bundle extras = getIntent().getExtras(); 
		//String diffSelection = extras.getString("difficultySelection");
		//setGUI(diffSelection);
	}
	
	public void submitHandler(View view) {

			if((editField1.getText().toString().compareTo("1") == 0) &&
					(editField2.getText().toString().compareTo("1") == 0) &&
					(editField3.getText().toString().compareTo("2") == 0) &&
					(editField4.getText().toString().compareTo("1") == 0) &&
					(editField5.getText().toString().compareTo("2") == 0)){
				
				Toast.makeText(this, "Good Job, Thumbs UP!",
						Toast.LENGTH_LONG).show();
				Intent returnStart = new Intent("edu.uml.chemgame.GAME3");
				//Intent passDifficulty = new Intent("edu.uml.chemgame.CHEMGAMEACTIVITY" );
				startActivity(returnStart);
			}else{
				Toast.makeText(this, "Not Quite, Try again",
						Toast.LENGTH_LONG).show();
			}
			
			return;
		
	}
	
	public boolean validate(EditText input) {
		/*
		switch (input.getId()) {
		case R.id.editText1:
			
			if(input.getText().toString().length() == 0){
				
			}else if(input.getText().toString().compareTo("1") == 0){
				input.setTextColor(R.color.green);
				//input.setEnabled(false);
			} else {
				input.setTextColor(R.color.red);
			}
			break;
			
		case R.id.editText2:
			if(input.getText().toString().length() == 0){
				
			}else if(input.getText().toString().compareTo("1") == 0){
				input.setTextColor(R.color.green);
			} else {
				input.setTextColor(R.color.red);
			}			
			break;
			
		case R.id.editText3:
			if(input.getText().toString().length() == 0){
				
			}else if(input.getText().toString().compareTo("2") == 0){
				input.setTextColor(R.color.green);
			} else {
				input.setTextColor(R.color.red);
			}
			break;
			
		case R.id.editText4:
			if(input.getText().toString().length() == 0){
				
			}else if(input.getText().toString().compareTo("1") == 0){
				input.setTextColor(R.color.green);
			} else {
				input.setTextColor(R.color.red);
			}
			break;
			
		case R.id.editText5:
			if(input.getText().toString().length() == 0){
				
			}else if(input.getText().toString().compareTo("2") == 0){
				input.setTextColor(R.color.green);
			} else {
				input.setTextColor(R.color.red);
			}
			break;
			
		}
		*/
		return true;
	}
	
	private boolean setGUI(String difficulty){
		gameUI = (LinearLayout) findViewById(R.id.userInterface);
	
		if(difficulty.compareTo("Easy") == 0){
			TextView tv1 = new TextView(this);
			TextView tv2 = new TextView(this);
			TextView tv3 = new TextView(this);
			TextView tv4 = new TextView(this);
			TextView tv5 = new TextView(this);
			LayoutParams params = new LayoutParams(
					LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			
			tv1.setText("Na");
			tv1.setId(1);
			tv1.setTextSize(30);
			tv1.setLayoutParams(params);
			gameUI.addView(tv1,0);			
			
			
			tv2.setText("Cl");
			tv2.setId(2);
			tv2.setTextSize(30);
			tv2.setLayoutParams(params);
			gameUI.addView(tv2,1);			
			
			tv3.setText(" => ");
			tv3.setId(3);
			tv3.setTextSize(30);
			tv3.setLayoutParams(params);
			gameUI.addView(tv3,2);					
			
			tv4.setText("Na");
			tv4.setId(4);
			tv4.setTextSize(30);
			tv4.setLayoutParams(params);
			gameUI.addView(tv4,3);

			tv5.setText("Cl");
			tv5.setId(5);
			tv5.setTextSize(30);
			tv5.setLayoutParams(params);
			gameUI.addView(tv5,4);			
			
		}else if(difficulty.compareTo("Medium") == 0){
			TextView valueTV = new TextView(this);
			valueTV.setText("in implementation");
			valueTV.setId(5);
			LayoutParams params = new LayoutParams(
					LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			valueTV.setLayoutParams(params);
			gameUI.addView(valueTV);
			
		}else if(difficulty.compareTo("Hard") == 0){
			TextView valueTV = new TextView(this);
			valueTV.setText("in implementation");
			valueTV.setId(5);
			LayoutParams params = new LayoutParams(
					LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			valueTV.setLayoutParams(params);
			gameUI.addView(valueTV);
		}
			
		return true;
	}

}