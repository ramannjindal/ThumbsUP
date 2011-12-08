package edu.uml.thumbsup;
//Developer Paul Gendreau

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1 extends Activity{

    /** Called when the activity is first created. */
	int []scores;
	int    score = 0;
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
        displayscore = (TextView)findViewById(R.id.gamescorehome);
        Adding = (Button) findViewById(R.id.bAdding);
        Subtracting = (Button) findViewById(R.id.bSubtracting);
        Reducing = (Button) findViewById(R.id.bReducing);
        Dividing = (Button) findViewById(R.id.bDividing);
        multiplying = (Button) findViewById(R.id.bmultiplying);
        helpmenu = (Button) findViewById(R.id.bHelp);
        
        displayscore.setText("high score "+Global.scores[0]);
        
        
        Reducing.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				Intent openGame1a = new Intent("edu.uml.thumbsup.GAME1R");
   				startActivity(openGame1a);
   			}
   		});
        
        Adding.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				Intent openGame1a = new Intent("edu.uml.thumbsup.GAME1A");
   				startActivity(openGame1a);
   				
   			}
   		});
        
        Subtracting.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				Intent openGame1a = new Intent("edu.uml.thumbsup.GAME1S");
   				startActivity(openGame1a);
   			}
   		});
        
        Dividing.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		Intent openGame1a = new Intent("edu.uml.thumbsup.GAME1D");
   				startActivity(openGame1a);
			}
		});
        
        multiplying.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				Intent openGame1a = new Intent("edu.uml.thumbsup.GAME1M");
   				startActivity(openGame1a);
   			}  
   		});
        
    
        helpmenu.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				Intent openGame1a = new Intent("edu.uml.thumbsup.GAME1HELP");
   				startActivity(openGame1a);
   			}
   		});
       
}	
}
    
