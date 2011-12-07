package edu.uml.thumbsup;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1 extends Activity{

    /** Called when the activity is first created. */
	
	int    score = 0;
	String s0 = "1/4";
	String s1 = "1/3";
	String s2 = "1/2";
	double a = .25;
	double b = .3;
	double c = .5;
	Button Dividing;
	Button multiplying;
	Button Reducing;
	Button Adding;
	Button helpmenu;
	Button Subtracting;
	TextView displayhome;
	TextView displayscore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1);
        
        displayhome = (TextView)findViewById(R.id.tvDisplayhome);
//        displayscore = (TextView)findViewById(R.id.Score);
        Adding = (Button) findViewById(R.id.bAdding);
        Subtracting = (Button) findViewById(R.id.bSubtracting);
        Reducing = (Button) findViewById(R.id.bReducing);
        Dividing = (Button) findViewById(R.id.bDividing);
        multiplying = (Button) findViewById(R.id.bmultiplying);
        helpmenu = (Button) findViewById(R.id.bHelp);
        
        
        
        Reducing.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				setContentView(R.layout.game1r);
   			}
   		});
        
        Adding.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				Intent openGame1a = new Intent("edu.uml.thumbsup.GAME1A");
   				startActivity(openGame1a);
   				//setContentView(R.layout.game1a);
   			}
   		});
        
        Subtracting.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				setContentView(R.layout.game1s);	
   			}
   		});
        
        Dividing.setOnClickListener(new View.OnClickListener() {
        	
       
        	public void onClick(View v) {
		
        		setContentView(R.layout.game1d);
			}
		});
        
        multiplying.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				setContentView(R.layout.game1m);
   			}  
   		});
        
    
        helpmenu.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   			 setContentView(R.layout.game1help);
   			}
   		});
        
}	
}
    
