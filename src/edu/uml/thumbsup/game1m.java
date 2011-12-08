package edu.uml.thumbsup;
//Paul Gendreau


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1m extends Activity{

    /** Called when the activity is first created. */
	
	int    score = 0;
	String s0 = "9/32";
	String s1 = "9/8";
	String s2 = "9/16";
	double a = .28;
	double b = .3;
	double c = .5;
	//Button continue1;
	Button manswers0;
	Button manswers1;
	Button manswers2;
	TextView mdisplay;
	TextView displayScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1m);
        
       // continue1 = (Button) findViewById(R.id.bContinue);
        mdisplay = (TextView)findViewById(R.id.tvmDisplay);
        displayScore = (TextView)findViewById(R.id.gameScore);
        manswers0 = (Button) findViewById(R.id.bmAnswers0);
        manswers1 = (Button) findViewById(R.id.bmAnswers1);
        manswers2 = (Button) findViewById(R.id.bmAnswers2);
       
        
     
        manswers0.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
		
        		func(a , s0);	
			}
		});
        
        manswers1.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(b,s2);	
   			}  
   		});
        
        manswers2.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(c,s1);	
   			}
   		});
   
}
   
    private void func(double z, String s) {
    	if(z == .28){
    	score += 100;
    	displayScore.setText("score " + score);
    	mdisplay.setText("you are correct ");

    	}
    	else{
    	mdisplay.setText("you are incorrect ");
    	}
    	
    	 
		
	}
    }