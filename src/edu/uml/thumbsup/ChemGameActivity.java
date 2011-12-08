package edu.uml.thumbsup;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChemGameActivity extends Activity {
	/** Called when the activity is first created. */
	RelativeLayout gameUI;
	TextView scoreDisp;
	int inputKey[][];
	double score = 100;
	String diffSelection;
	int attempted= 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.chem_game);
		Bundle extras = getIntent().getExtras(); 
	    diffSelection = extras.getString("difficultySelection");
		setGUI(diffSelection);

	}
	
	public void submitHandler(View view) {
		boolean pass, passArray[];
		int i, answer, red, black;
		EditText temp;
		
		red = this.getResources().getColor(R.color.red);
		black = this.getResources().getColor(R.color.black);
		passArray= new boolean[inputKey.length];
		pass = true;
		attempted += 1;
		
		//check each individual editText for the correct answer
		for(i = 0; i < inputKey.length ; i++){
			temp = (EditText) gameUI.getChildAt(inputKey[i][0]);
			
			if ( temp.getText().toString().length() != 0){
				answer = Integer.parseInt(temp.getText().toString()); 	

				if(answer == inputKey[i][1]){
					//if the answer is correct, set the corresponding point in
					//passArray to tru
					passArray[i] = true;
				}
			}
		}
		
		for(i = 0; i < passArray.length; i++){
			temp = (EditText) gameUI.getChildAt(inputKey[i][0]);
			
			if( passArray[i] == false ){
				//if any individual node in passArray is false, do not pass
				//and set the corresponding text color to red.
				pass = false;
				temp.setTextColor(red);
			}else{
				temp.setTextColor(black);
			}
		}
		
		if(pass == true){
			
			Toast.makeText(this, "Good Job, Thumbs UP!" ,
					Toast.LENGTH_LONG).show();
			
			if(attempted == 0 ){
				score = 0;
			}
			
			if( diffSelection.compareTo("Hard") == 0 ){
				score = score * 1.3;
			}else if(diffSelection.compareTo("Medium") == 0 ){
				score = score * 1.2;
			}
			if(score > 100) score = 100;
			
			// code to pass score will go here
			finish();
			
		}else{
			Toast.makeText(this, "Not Quite, Try again",
					Toast.LENGTH_LONG).show();
			score = score * 0.9;
		}
		scoreDisp.setText("Score: " + score);
			return;
	}
	public void getHint(View view) {
		int guess;
		EditText temp;
		boolean done = false;
		int helpVal = 0;
		
		while(done == false ){
			//test to ensure not out of bounds
			if(helpVal < inputKey.length){				
				temp = (EditText) gameUI.getChildAt(inputKey[helpVal][0]);
				
				//test to see if a guess has been made
				if ( temp.getText().toString().length() != 0){
					guess = Integer.parseInt(temp.getText().toString()); 
					
					//test to see if left most guess is correct
					if(guess == inputKey[helpVal][1]){
						//if the guess is correct, move to the next slot
						helpVal +=1;
					}else{
						//incorrect guess has been made, give left most answer
						temp.setText( Integer.toString(inputKey[helpVal][1]));
						score = score * .8;
						scoreDisp.setText("Score: " + score);
						done = true;				 	
					}
				}else{	
					//no guess has been made, give left most answer
					temp.setText( Integer.toString(inputKey[helpVal][1]));
					score = score * .8;
					scoreDisp.setText("Score: " + score);
					done = true;
				}
			}else{
				//out of bounds, end loop
				done = true;
			}
		}
	return;
	}
	private boolean setGUI(String difficulty){
		int black = this.getResources().getColor(R.color.black);
		int keypos = 0;
		gameUI = (RelativeLayout) findViewById(R.id.userInterface);
		scoreDisp = (TextView) findViewById(R.id.scoreDisplay);
		
		scoreDisp.setText("Score: " + score);
		
		if(difficulty.compareTo("Easy") == 0){
			inputKey = new int[3][2];
			
			EditText et1 = new EditText(this);
			TextView tv1 = new TextView(this);
			TextView tv2 = new TextView(this);
			TextView tv3 = new TextView(this);
			TextView tv4 = new TextView(this);
			TextView tv5 = new TextView(this);
			TextView tv6 = new TextView(this);
			EditText et4 = new EditText(this);
			EditText et5 = new EditText(this);

			InputFilter[] FilterArray = new InputFilter[1];
			FilterArray[0] = new InputFilter.LengthFilter(2);
			
			LayoutParams defaultLayoutParams = new LayoutParams(
  					LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			
			RelativeLayout.LayoutParams et1lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et1lp.addRule(RelativeLayout.LEFT_OF, 
					gameUI.getId());
			et1lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getId());
			et1.setHint("X");
			et1.setId(6);
			et1.setTextSize(20);
			et1.setHeight(45);
			et1.setWidth(45);
			et1.setInputType(InputType.TYPE_CLASS_NUMBER);
			et1.setPadding(0, 0, 0, 0);
			et1.setGravity(Gravity.CENTER); 
			et1.setFilters(FilterArray);
			et1.setLayoutParams(et1lp);
			gameUI.addView(et1);
	
			inputKey[keypos][0] = 0;
			inputKey[keypos][1] = 1;
			keypos += 1;
			
			RelativeLayout.LayoutParams tv1lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv1lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(0).getId() );
			tv1lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getId());
			
			tv1.setText("Na");
			tv1.setId(1);
			tv1.setTextSize(30);
			tv1.setTextColor(black);
			tv1.setPadding(0, 0, 0, 0);
			tv1.setLayoutParams(tv1lp);
			gameUI.addView(tv1);			
			
			RelativeLayout.LayoutParams tv2lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv2lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(1).getId() );
			tv2lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getId());	
			tv2lp.setMargins(5, 0, 0, 0);
			
			tv2.setText("Cl");
			tv2.setId(2);
			tv2.setTextSize(30);
			tv2.setTextColor(black);
			tv2.setPadding(0, 0, 0, 0);
			tv2.setLayoutParams(tv2lp);
			gameUI.addView(tv2);
				
			RelativeLayout.LayoutParams tv6lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv6lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(1).getId() );
			tv6lp.addRule(RelativeLayout.BELOW, 
					gameUI.getChildAt(2).getId());
			tv6lp.setMargins(30, -10, 0, 0);
			
			tv6.setText("2");
			tv6.setId(8);
			tv6.setTextSize(30);
			tv6.setTextColor(black);
			tv6.setPadding(0, 0, 0, 0);
			tv6.setLayoutParams(tv6lp);
			gameUI.addView(tv6);			

			RelativeLayout.LayoutParams tv3lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv3lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(2).getId() );
			tv3lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getId());
			tv3lp.setMargins(10, 0, 10, 0);

			tv3.setText("=>");
			tv3.setId(3);
			tv3.setTextSize(30);
			tv3.setTextColor(black);
			tv3.setPadding(0, 0, 0, 0);
			tv3.setLayoutParams(tv3lp);
			gameUI.addView(tv3);		
			
			RelativeLayout.LayoutParams et4lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et4lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(4).getId() );
			et4lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getChildAt(4).getId() );
			
			et4.setHint("X");
			et4.setId(9);
			et4.setTextSize(20);
			et4.setInputType(InputType.TYPE_CLASS_NUMBER);
			et4.setHeight(45);
			et4.setWidth(45);
			et4.setPadding(0, 0, 0, 0);
			et4.setGravity(Gravity.CENTER); 
			et4.setFilters(FilterArray);
			et4.setLayoutParams(et4lp);
			gameUI.addView(et4);
	
			inputKey[keypos][0] = 5;
			inputKey[keypos][1] = 1;
			keypos += 1;		
		
			RelativeLayout.LayoutParams tv4lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv4lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(5).getId() );
			tv4lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getId());	
	
			tv4.setText("Na");
			tv4.setId(4);
			tv4.setTextSize(30);
			tv4.setTextColor(black);
			tv4.setPadding(0, 0, 0, 0);
			tv4.setLayoutParams(tv4lp);
			gameUI.addView(tv4);

			RelativeLayout.LayoutParams tv5lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv5lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(6).getId() );
			tv5lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getId() );
			tv5lp.setMargins(5, 0, 0, 0);
			
			tv5.setText("Cl");
			tv5.setId(5);
			tv5.setTextSize(30);
			tv5.setTextColor(black);
			tv5.setPadding(0, 0, 0, 0);
			tv5.setLayoutParams(tv5lp);
			gameUI.addView(tv5);		
		
			RelativeLayout.LayoutParams et5lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et5lp.addRule(RelativeLayout.ALIGN_LEFT, 
					gameUI.getChildAt(6).getId() );
			et5lp.addRule(RelativeLayout.BELOW, 
					gameUI.getChildAt(7).getId() );
			et5lp.setMargins(90, 0, 0, 0);
			
			et5.setHint("X");
			et5.setId(10);
			et5.setTextSize(20);
			et5.setHeight(45);
			et5.setWidth(45);
			et5.setGravity(Gravity.CENTER); 
			et5.setInputType(InputType.TYPE_CLASS_NUMBER);
			et5.setFilters(FilterArray);
			et5.setPadding(0, 0, 0, 0);
			et5.setLayoutParams(et5lp);
			gameUI.addView(et5);
	
			inputKey[keypos][0] = 8;
			inputKey[keypos][1] = 2;
			keypos += 1;

			
		}else if(difficulty.compareTo("Medium") == 0){
			
			inputKey = new int[4][2];
			
			EditText et1 = new EditText(this);
			TextView tv1 = new TextView(this);
			TextView tv2 = new TextView(this);
			EditText et2 = new EditText(this);
			TextView tv3 = new TextView(this);
			TextView tv4 = new TextView(this);
			TextView tv5 = new TextView(this);
			TextView tv6 = new TextView(this);
			TextView tv7 = new TextView(this);
			TextView tv8 = new TextView(this);
			TextView tv9 = new TextView(this);
			TextView tv10 = new TextView(this);
			TextView tv11 = new TextView(this);
			EditText et3 = new EditText(this);
			EditText et4 = new EditText(this);

			InputFilter[] FilterArray = new InputFilter[1];
			FilterArray[0] = new InputFilter.LengthFilter(2);
			
			LayoutParams defaultLayoutParams = new LayoutParams(
  					LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			
			RelativeLayout.LayoutParams et4lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et4lp.addRule(RelativeLayout.LEFT_OF, 
					gameUI.getId());
			et4lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getId());
			et4lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(1).getId()
			et4.setHint("X");
			et4.setId(15);
			et4.setTextSize(20);
			et4.setHeight(45);
			et4.setWidth(45);
			et4.setInputType(InputType.TYPE_CLASS_NUMBER);
			et4.setPadding(0, 0, 0, 0);
			et4.setGravity(Gravity.CENTER); 
			et4.setFilters(FilterArray);
			et4.setLayoutParams(et4lp);
			gameUI.addView(et4);
	
			inputKey[keypos][0] = 0;
			inputKey[keypos][1] = 1;
			keypos += 1;
			

			RelativeLayout.LayoutParams tv1lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv1lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(0).getId() );
			tv1lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getId());	
			tv1lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(1).getId()
			tv1.setText("H PO");
			tv1.setId(1);
			tv1.setTextSize(30);
			tv1.setTextColor(black);
			tv1.setPadding(0, 0, 0, 0);
			tv1.setLayoutParams(tv1lp);
			gameUI.addView(tv1);			


			RelativeLayout.LayoutParams tv2lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv2lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(0).getId() );
			tv2lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(0).getId());	
			tv2lp.setMargins(24, 38, 0, 0);
			
			//gameUI.getChildAt(2).getId()
			tv2.setText("3   4");
			tv2.setId(2);
			tv2.setTextSize(30);
			tv2.setTextColor(black);
			tv2.setPadding(0, 0, 0, 0);
			tv2.setLayoutParams(tv2lp);
			gameUI.addView(tv2);
			
			RelativeLayout.LayoutParams tv5lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv5lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(1).getId() );
			tv5lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(1).getId());	
			tv5lp.setMargins(5, 0, 5, 0);
			
			//gameUI.getChildAt(3).getId()
			tv5.setText("+");
			tv5.setId(6);
			tv5.setTextSize(30);
			tv5.setTextColor(black);
			tv5.setPadding(0, 0, 0, 0);
			tv5.setLayoutParams(tv5lp);
			gameUI.addView(tv5);

			RelativeLayout.LayoutParams et1lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et1lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(3).getId());
			et1lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getId());
			et1lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(4).getId()
			et1.setHint("X");
			et1.setId(3);
			et1.setTextSize(20);
			et1.setHeight(45);
			et1.setWidth(45);
			et1.setInputType(InputType.TYPE_CLASS_NUMBER);
			et1.setPadding(0, 0, 0, 0);
			et1.setGravity(Gravity.CENTER); 
			et1.setFilters(FilterArray);
			et1.setLayoutParams(et1lp);
			gameUI.addView(et1);
	
			inputKey[keypos][0] = 4;
			inputKey[keypos][1] = 5;
			keypos += 1;
			
			RelativeLayout.LayoutParams tv3lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv3lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(4).getId() );
			tv3lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getChildAt(1).getId());	
			tv3lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(5).getId()
			tv3.setText("HCl");
			tv3.setId(4);
			tv3.setTextSize(30);
			tv3.setTextColor(black);
			tv3.setPadding(0, 0, 0, 0);
			tv3.setLayoutParams(tv3lp);
			gameUI.addView(tv3);
			
			RelativeLayout.LayoutParams tv4lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv4lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(4).getId() );
			tv4lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(2).getId());	
			tv4lp.setMargins(18, 0, 0, 0);
			
			//gameUI.getChildAt(6).getId()
			tv4.setText("");
			tv4.setId(5);
			tv4.setTextSize(30);
			tv4.setTextColor(black);
			tv4.setPadding(0, 0, 0, 0);
			tv4.setLayoutParams(tv4lp);
			gameUI.addView(tv4);
			
			RelativeLayout.LayoutParams tv6lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv6lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(5).getId() );
			tv6lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getChildAt(5).getId());	
			tv6lp.setMargins(5, 0, 5, 0);
			
			//gameUI.getChildAt(7).getId()
			tv6.setText("=>");
			tv6.setId(7);
			tv6.setTextSize(30);
			tv6.setTextColor(black);
			tv6.setPadding(0, 0, 0, 0);
			tv6.setLayoutParams(tv6lp);
			gameUI.addView(tv6);
//important
			RelativeLayout.LayoutParams et2lp;
			
			if(getResources().getConfiguration().orientation == 1){
				//if layout is portrait do this
				et2lp = new RelativeLayout.LayoutParams(defaultLayoutParams);
				et2lp.addRule(RelativeLayout.RIGHT_OF, 
						gameUI.getChildAt(3).getId());
				et2lp.addRule(RelativeLayout.BELOW, 
						gameUI.getChildAt(2).getId());
				et2lp.setMargins(5, 0, 0, 0);
			}else{
				et2lp = new RelativeLayout.LayoutParams(defaultLayoutParams);
				et2lp.addRule(RelativeLayout.RIGHT_OF, 
						gameUI.getChildAt(7).getId());
				et2lp.addRule(RelativeLayout.ALIGN_TOP, 
						gameUI.getChildAt(7).getId());
				et2lp.setMargins(5, 0, 0, 0);
			}
			//gameUI.getChildAt(8).getId()
			et2.setHint("X");
			et2.setId(8);
			et2.setTextSize(20);
			et2.setHeight(45);
			et2.setWidth(45);
			et2.setInputType(InputType.TYPE_CLASS_NUMBER);
			et2.setPadding(0, 0, 0, 0);
			et2.setGravity(Gravity.CENTER); 
			et2.setFilters(FilterArray);
			et2.setLayoutParams(et2lp);
			gameUI.addView(et2);
	
			inputKey[keypos][0] = 8;
			inputKey[keypos][1] = 1;
			keypos += 1;
			
			RelativeLayout.LayoutParams tv7lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv7lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(8).getId() );
			tv7lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getChildAt(8).getId());	
			tv7lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(9).getId()
			tv7.setText("PCl");
			tv7.setId(9);
			tv7.setTextSize(30);
			tv7.setTextColor(black);
			tv7.setPadding(0, 0, 0, 0);
			tv7.setLayoutParams(tv7lp);
			gameUI.addView(tv7);
			
			RelativeLayout.LayoutParams tv8lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv8lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(8).getId() );
			tv8lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv8lp.setMargins(55, 38, 0, 0);
			
			//gameUI.getChildAt(10).getId()
			tv8.setText("5");
			tv8.setId(10);
			tv8.setTextSize(30);
			tv8.setTextColor(black);
			tv8.setPadding(0, 0, 0, 0);
			tv8.setLayoutParams(tv8lp);
			gameUI.addView(tv8);
			
			RelativeLayout.LayoutParams tv9lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv9lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(9).getId() );
			tv9lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv9lp.setMargins(5, 0, 5, 0);
			
			//gameUI.getChildAt(11).getId()
			tv9.setText("+");
			tv9.setId(11);
			tv9.setTextSize(30);
			tv9.setTextColor(black);
			tv9.setPadding(0, 0, 0, 0);
			tv9.setLayoutParams(tv9lp);
			gameUI.addView(tv9);

			
			RelativeLayout.LayoutParams et3lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et3lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(11).getId());
			et3lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());
			et3lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(12).getId()
			et3.setHint("X");
			et3.setId(12);
			et3.setTextSize(20);
			et3.setHeight(45);
			et3.setWidth(45);
			et3.setInputType(InputType.TYPE_CLASS_NUMBER);
			et3.setPadding(0, 0, 0, 0);
			et3.setGravity(Gravity.CENTER); 
			et3.setFilters(FilterArray);
			et3.setLayoutParams(et3lp);
			gameUI.addView(et3);
	
			inputKey[keypos][0] = 12;
			inputKey[keypos][1] = 4;
			keypos += 1;
			
			RelativeLayout.LayoutParams tv10lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv10lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(12).getId() );
			tv10lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv10lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(13).getId()
			tv10.setText("H O");
			tv10.setId(13);
			tv10.setTextSize(30);
			tv10.setTextColor(black);
			tv10.setPadding(0, 0, 0, 0);
			tv10.setLayoutParams(tv10lp);
			gameUI.addView(tv10);
			
			RelativeLayout.LayoutParams tv11lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv11lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(12).getId() );
			tv11lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv11lp.setMargins(25, 38, 0, 0);
			
			//gameUI.getChildAt(13).getId()
			tv11.setText("2");
			tv11.setId(14);
			tv11.setTextSize(30);
			tv11.setTextColor(black);
			tv11.setPadding(0, 0, 0, 0);
			tv11.setLayoutParams(tv11lp);
			gameUI.addView(tv11);
			
		}else if(difficulty.compareTo("Hard") == 0){
			
			inputKey = new int[4][2];
			
			EditText et1 = new EditText(this);
			TextView tv1 = new TextView(this);
			TextView tv2 = new TextView(this);
			EditText et2 = new EditText(this);
			TextView tv3 = new TextView(this);
			TextView tv4 = new TextView(this);
			TextView tv5 = new TextView(this);
			TextView tv6 = new TextView(this);
			TextView tv7 = new TextView(this);
			TextView tv8 = new TextView(this);
			TextView tv9 = new TextView(this);
			TextView tv10 = new TextView(this);
			TextView tv11 = new TextView(this);
			EditText et3 = new EditText(this);
			EditText et4 = new EditText(this);
		//	EditText et5 = new EditText(this);

			InputFilter[] FilterArray = new InputFilter[1];
			FilterArray[0] = new InputFilter.LengthFilter(2);
			
			LayoutParams defaultLayoutParams = new LayoutParams(
  					LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			
			RelativeLayout.LayoutParams et4lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et4lp.addRule(RelativeLayout.LEFT_OF, 
					gameUI.getId());
			et4lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getId());
			et4lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(1).getId()
			et4.setHint("X");
			et4.setId(15);
			et4.setTextSize(20);
			et4.setHeight(45);
			et4.setWidth(45);
			et4.setInputType(InputType.TYPE_CLASS_NUMBER);
			et4.setPadding(0, 0, 0, 0);
			et4.setGravity(Gravity.CENTER); 
			et4.setFilters(FilterArray);
			et4.setLayoutParams(et4lp);
			gameUI.addView(et4);
	
			inputKey[keypos][0] = 0;
			inputKey[keypos][1] = 2;
			keypos += 1;
			

			RelativeLayout.LayoutParams tv1lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv1lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(0).getId() );
			tv1lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getId());	
			tv1lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(1).getId()
			tv1.setText("C H O");
			tv1.setId(1);
			tv1.setTextSize(30);
			tv1.setTextColor(black);
			tv1.setPadding(0, 0, 0, 0);
			tv1.setLayoutParams(tv1lp);
			gameUI.addView(tv1);			


			RelativeLayout.LayoutParams tv2lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv2lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(0).getId() );
			tv2lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(0).getId());	
			tv2lp.setMargins(24, 38, 0, 0);
			
			//gameUI.getChildAt(2).getId()
			tv2.setText("6 6  2");
			tv2.setId(2);
			tv2.setTextSize(30);
			tv2.setTextColor(black);
			tv2.setPadding(0, 0, 0, 0);
			tv2.setLayoutParams(tv2lp);
			gameUI.addView(tv2);
			
			RelativeLayout.LayoutParams tv5lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv5lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(1).getId() );
			tv5lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(1).getId());	
			tv5lp.setMargins(5, 0, 5, 0);
			
			//gameUI.getChildAt(3).getId()
			tv5.setText("+");
			tv5.setId(6);
			tv5.setTextSize(30);
			tv5.setTextColor(black);
			tv5.setPadding(0, 0, 0, 0);
			tv5.setLayoutParams(tv5lp);
			gameUI.addView(tv5);

			RelativeLayout.LayoutParams et1lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et1lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(3).getId());
			et1lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getId());
			et1lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(4).getId()
			et1.setHint("X");
			et1.setId(3);
			et1.setTextSize(20);
			et1.setHeight(45);
			et1.setWidth(45);
			et1.setInputType(InputType.TYPE_CLASS_NUMBER);
			et1.setPadding(0, 0, 0, 0);
			et1.setGravity(Gravity.CENTER); 
			et1.setFilters(FilterArray);
			et1.setLayoutParams(et1lp);
			gameUI.addView(et1);
	
			inputKey[keypos][0] = 4;
			inputKey[keypos][1] = 13;
			keypos += 1;
			
			RelativeLayout.LayoutParams tv3lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv3lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(4).getId() );
			tv3lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getChildAt(1).getId());	
			tv3lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(5).getId()
			tv3.setText("O");
			tv3.setId(4);
			tv3.setTextSize(30);
			tv3.setTextColor(black);
			tv3.setPadding(0, 0, 0, 0);
			tv3.setLayoutParams(tv3lp);
			gameUI.addView(tv3);
			
			RelativeLayout.LayoutParams tv4lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv4lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(4).getId() );
			tv4lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(2).getId());	
			tv4lp.setMargins(18, 0, 0, 0);
			
			//gameUI.getChildAt(6).getId()
			tv4.setText("2");
			tv4.setId(5);
			tv4.setTextSize(30);
			tv4.setTextColor(black);
			tv4.setPadding(0, 0, 0, 0);
			tv4.setLayoutParams(tv4lp);
			gameUI.addView(tv4);
			
			RelativeLayout.LayoutParams tv6lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv6lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(5).getId() );
			tv6lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getChildAt(5).getId());	
			tv6lp.setMargins(5, 0, 5, 0);
			
			//gameUI.getChildAt(7).getId()
			tv6.setText("=>");
			tv6.setId(7);
			tv6.setTextSize(30);
			tv6.setTextColor(black);
			tv6.setPadding(0, 0, 0, 0);
			tv6.setLayoutParams(tv6lp);
			gameUI.addView(tv6);
//important

			RelativeLayout.LayoutParams et2lp;
			
			if(getResources().getConfiguration().orientation == 1){
				//if layout is portrait do this
				et2lp = new RelativeLayout.LayoutParams(defaultLayoutParams);
				et2lp.addRule(RelativeLayout.RIGHT_OF, 
						gameUI.getChildAt(3).getId());
				et2lp.addRule(RelativeLayout.BELOW, 
						gameUI.getChildAt(2).getId());
				et2lp.setMargins(5, 0, 0, 0);
			}else{
				et2lp = new RelativeLayout.LayoutParams(defaultLayoutParams);
				et2lp.addRule(RelativeLayout.RIGHT_OF, 
						gameUI.getChildAt(7).getId());
				et2lp.addRule(RelativeLayout.ALIGN_TOP, 
						gameUI.getChildAt(7).getId());
				et2lp.setMargins(5, 0, 0, 0);
			}
			
			//gameUI.getChildAt(8).getId()
			et2.setHint("X");
			et2.setId(8);
			et2.setTextSize(20);
			et2.setHeight(45);
			et2.setWidth(45);
			et2.setInputType(InputType.TYPE_CLASS_NUMBER);
			et2.setPadding(0, 0, 0, 0);
			et2.setGravity(Gravity.CENTER); 
			et2.setFilters(FilterArray);
			et2.setLayoutParams(et2lp);
			gameUI.addView(et2);
	
			inputKey[keypos][0] = 8;
			inputKey[keypos][1] = 12;
			keypos += 1;
			
			RelativeLayout.LayoutParams tv7lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv7lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(8).getId() );
			tv7lp.addRule(RelativeLayout.ALIGN_BASELINE, 
					gameUI.getChildAt(8).getId());	
			tv7lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(9).getId()
			tv7.setText("CO");
			tv7.setId(9);
			tv7.setTextSize(30);
			tv7.setTextColor(black);
			tv7.setPadding(0, 0, 0, 0);
			tv7.setLayoutParams(tv7lp);
			gameUI.addView(tv7);
			
			RelativeLayout.LayoutParams tv8lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv8lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(8).getId() );
			tv8lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv8lp.setMargins(50, 38, 0, 0);
			
			//gameUI.getChildAt(10).getId()
			tv8.setText("2");
			tv8.setId(10);
			tv8.setTextSize(30);
			tv8.setTextColor(black);
			tv8.setPadding(0, 0, 0, 0);
			tv8.setLayoutParams(tv8lp);
			gameUI.addView(tv8);
			
			RelativeLayout.LayoutParams tv9lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv9lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(9).getId() );
			tv9lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv9lp.setMargins(5, 0, 5, 0);
			
			//gameUI.getChildAt(11).getId()
			tv9.setText("+");
			tv9.setId(11);
			tv9.setTextSize(30);
			tv9.setTextColor(black);
			tv9.setPadding(0, 0, 0, 0);
			tv9.setLayoutParams(tv9lp);
			gameUI.addView(tv9);

			
			RelativeLayout.LayoutParams et3lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			et3lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(11).getId());
			et3lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());
			et3lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(12).getId()
			et3.setHint("X");
			et3.setId(12);
			et3.setTextSize(20);
			et3.setHeight(45);
			et3.setWidth(45);
			et3.setInputType(InputType.TYPE_CLASS_NUMBER);
			et3.setPadding(0, 0, 0, 0);
			et3.setGravity(Gravity.CENTER); 
			et3.setFilters(FilterArray);
			et3.setLayoutParams(et3lp);
			gameUI.addView(et3);
	
			inputKey[keypos][0] = 12;
			inputKey[keypos][1] = 6;
			keypos += 1;
			
			RelativeLayout.LayoutParams tv10lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv10lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(12).getId() );
			tv10lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv10lp.setMargins(0, 0, 0, 0);
			
			//gameUI.getChildAt(13).getId()
			tv10.setText("H O");
			tv10.setId(13);
			tv10.setTextSize(30);
			tv10.setTextColor(black);
			tv10.setPadding(0, 0, 0, 0);
			tv10.setLayoutParams(tv10lp);
			gameUI.addView(tv10);
			
			RelativeLayout.LayoutParams tv11lp = 
					new RelativeLayout.LayoutParams(defaultLayoutParams);
			tv11lp.addRule(RelativeLayout.RIGHT_OF, 
					gameUI.getChildAt(12).getId() );
			tv11lp.addRule(RelativeLayout.ALIGN_TOP, 
					gameUI.getChildAt(8).getId());	
			tv11lp.setMargins(25, 38, 0, 0);
			
			//gameUI.getChildAt(13).getId()
			tv11.setText("2");
			tv11.setId(14);
			tv11.setTextSize(30);
			tv11.setTextColor(black);
			tv11.setPadding(0, 0, 0, 0);
			tv11.setLayoutParams(tv11lp);
			gameUI.addView(tv11);

		}
			
		return true;
	}

}