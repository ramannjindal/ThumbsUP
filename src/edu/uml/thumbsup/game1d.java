package edu.uml.thumbsup;
//Paul Gendreau


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1d extends Activity{

    /** Called when the activity is first created. */
	
	int    score = 0;
	String s0 = "5/8";
	String s1 = "5/7";
	String s2 = "2/3";
	double a = .25;
	double b = .66;
	double c = .5;
	Button continue1;
	Button danswers0;
	Button danswers1;
	Button danswers2;
	TextView ddisplay;
	TextView displayScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1d);
        
       // continue1 = (Button) findViewById(R.id.bContinue);
        ddisplay = (TextView)findViewById(R.id.tvdDisplay);
        displayScore = (TextView)findViewById(R.id.gameScore);
        danswers0 = (Button) findViewById(R.id.bdAnswers0);
        danswers1 = (Button) findViewById(R.id.bdAnswers1);
        danswers2 = (Button) findViewById(R.id.bdAnswers2);
       
        
     
        danswers0.setOnClickListener(new View.OnClickListener() {
        	
        
        	public void onClick(View v) {
		
        		func(a , s0);	
			}
		});
        
        danswers1.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(b,s2);	
   			}  
   		});
        
        danswers2.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(c,s1);	
   			}
   		});
     
}
   
    private void func(double z, String s) {
    	if(z == .66){
    	score += 100;
    	displayScore.setText("score " + score);
    	ddisplay.setText("you are correct ");
    	
    	}
    	else{
    	ddisplay.setText("you are incorrect ");
    	}
    	
    	 
		
	}
    }