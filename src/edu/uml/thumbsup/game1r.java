package edu.uml.thumbsup;
//Developer Paul Gendreau

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1r extends Activity{

    /** Called when the activity is first created. */
	int []scores;
	int    score = 0;
	String s0 = "1/4";
	String s1 = "1/3";
	String s2 = "1/2";
	double a = .25;
	double b = .3;
	double c = .5;
	//Button continue1;
	Button ranswers0;
	Button ranswers1;
	Button ranswers2;
	TextView rdisplay;
	TextView displayScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1r);
        
        rdisplay = (TextView)findViewById(R.id.tvrDisplay);
        displayScore = (TextView)findViewById(R.id.gameScore);
        ranswers0 = (Button) findViewById(R.id.brAnswers0);
        ranswers1 = (Button) findViewById(R.id.brAnswers1);
        ranswers2 = (Button) findViewById(R.id.brAnswers2);
       // continue1 = (Button) findViewById(R.id.bContinue);
       
        ranswers0.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
		
        		func(a , s0);	
			}
		});
        
        ranswers1.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(b,s2);	
   			}  
   		});
        
        ranswers2.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(c,s1);	
   			}
   		});
  
    
        
}
   
    private void func(double z, String s) {
    	if(z == .25){
    	score += 100;
    	displayScore.setText("score " + score);
    	rdisplay.setText("you are correct ");
    	if ( score >= Global.scores[0]){
  	      Global.scores[0] = score;
  		displayScore.setText("We have a new high score! "+ score);}
    	
    	}
    	else{
    	rdisplay.setText("you are incorrect ");
    	}
    		 
		
	}
    }