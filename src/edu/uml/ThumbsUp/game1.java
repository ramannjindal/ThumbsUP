package edu.uml.thumbsup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1 extends Activity{

    /** Called when the activity is first created. */
	
	int score = 0;
	String  s0 = "1/4";
	String  s1 = "1/3";
	String  s2 = "1/2";
	double a = .25;
	double b = .3;
	double  c = .5;
	Button answers0;
	Button answers1;
	Button answers2;
	TextView display;
	TextView displayScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1);
        
        answers0 = (Button) findViewById(R.id.bAnswers0);
        answers1 = (Button) findViewById(R.id.bAnswers1);
        answers2 = (Button) findViewById(R.id.bAnswers2);
        display = (TextView)findViewById(R.id.tvDisplay);
        displayScore = (TextView)findViewById(R.id.tvDisplayScore);
       // display.setText("your right " + s + " is equal to 4/16");
        
         
        answers0.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				func(a,s0);	
			}
		});
        
        answers1.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(b,s1);	
   			}
   		});
        
        answers2.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(c,s2);	
   			}
   		});
        
}
   
    private void func(double z, String s) {
    	if(z == .25){
    	score += 100;
    	displayScore.setText("score " + score);
    	display.setText("your right " + s + " is equal to 4/16");
    	
    	}
    	else{
    	display.setText("your answer is wrong " + s + " is not equal to 4/16");
    	}
		
		
	}
    }