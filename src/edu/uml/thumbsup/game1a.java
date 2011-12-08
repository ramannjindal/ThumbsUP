package edu.uml.thumbsup;
//Paul Gendreau

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1a extends Activity{

	 /** Called when the activity is first created. */

	//    int []score_array = getResources().getIntArray(R.array.scores);

		int    score = 0;
		String s0 = "3/4";
		String s1 = "1/3";
		String s2 = "1/2";
		double a = .75;
		double b = .3;
		double c = .5;
		//Button continue1;
		Button aanswers0;
		Button aanswers1;
		Button aanswers2;
		TextView adisplay;
		TextView displayScore;
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.game1a);
	        
	        adisplay = (TextView)findViewById(R.id.tvaDisplay);
	        displayScore = (TextView)findViewById(R.id.gameScore);
	        aanswers0 = (Button) findViewById(R.id.baAnswers0);
	        aanswers1 = (Button) findViewById(R.id.baAnswers1);
	        aanswers2 = (Button) findViewById(R.id.baAnswers2);
	      
	      
	       
	        
	     
	        aanswers0.setOnClickListener(new View.OnClickListener() {
	        	
	        
	        	public void onClick(View v) {
			
	        		func(a,s0);	
				}
			});
	        
	        aanswers1.setOnClickListener(new View.OnClickListener() {
	   			public void onClick(View v) {
	   				
	   				func(b,s2);	
	   			}  
	   		});
	        
	        aanswers2.setOnClickListener(new View.OnClickListener() {
	   			public void onClick(View v) {
	   				
	   				func(c,s1);	
	   			}
	   		});
	  
	    
	        
	}
	   
	    private void func(double z, String s) {
	    	if(z == .75){
	    	score += 100;
	    	displayScore.setText("score " + score);
	    	adisplay.setText("you are correct ");
	    	//if ( score >= Global.score[0]){
	    	//      Global.score[0] = score;
	    	//	displayScore.setText("We have a new high score!"+ score);}
	    	    

	    	
	    	
	    	}
	    	else{
	    	adisplay.setText("you are incorrect ");
	    	}
	    	
	    	 
			
		}
	    }