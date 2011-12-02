package edu.uml.thumbsup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
//import android.widget.TextView;
//import android.widget.Toast;
import android.widget.Toast;


public class playGame extends Activity {

	private RadioButton rButtons[] = new RadioButton[12];

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		rButtons[1] = (RadioButton)findViewById(R.id.option1);
		rButtons[2] = (RadioButton)findViewById(R.id.option2);
		rButtons[3] = (RadioButton)findViewById(R.id.option3);
		rButtons[4] = (RadioButton)findViewById(R.id.option4);
		rButtons[5] = (RadioButton)findViewById(R.id.option5);
		rButtons[6] = (RadioButton)findViewById(R.id.option6);
		rButtons[7] = (RadioButton)findViewById(R.id.option7);
		rButtons[8] = (RadioButton)findViewById(R.id.option8);
		rButtons[9] = (RadioButton)findViewById(R.id.option9);
		rButtons[10] = (RadioButton)findViewById(R.id.option10);
		
				
		Button ansButton = (Button)findViewById(R.id.selected);

		ansButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int count = checkStates();		
				int ans = scores(count);	
				
		  //SINGLE LINE TOAST MESSAGE
				//Toast.makeText(getApplicationContext(),"Congratulations! Your Score is: "+ans+"/100" ,Toast.LENGTH_LONG).show();
		 
		 //MULTIPLE LINE TOAST MESSAGE
				Context context = getApplicationContext();
				CharSequence text = "Congratulations! Your Score is: "+ans+"/100";
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(context, text, duration);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.show();
				
				
				finish();
			}
			
			
			public int checkStates(){
				int val = 0;	 
				if(rButtons[2].isChecked() == true){
			    	val++;
				}
				if(rButtons[3].isChecked() == true){
			    	val++;
				}
				if(rButtons[6].isChecked() == true){
			    	val++;
				}
				if(rButtons[8].isChecked() == true){
			    	val++;
				}
				if(rButtons[9].isChecked() == true){
			    	val++;
				}
							
				return val;
			}
			
			
			public int scores(int count){
				int score = count * 20;
				return score;
			}
		});

	}

			
}


