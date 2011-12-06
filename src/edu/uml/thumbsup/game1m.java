package edu.uml.thumbsup;
//Paul Gendreau


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1m extends Activity{

    /** Called when the activity is first created. */
	
	int    score = 0;
	String s0 = "1/4";
	String s1 = "1/3";
	String s2 = "1/2";
	double a = .25;
	double b = .3;
	double c = .5;
	Button continue1;
	Button answers0;
	Button answers1;
	Button answers2;
	TextView display;
	TextView displayScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1);
        
       // continue1 = (Button) findViewById(R.id.bContinue);
      
       
        
     
        answers0.setOnClickListener(new View.OnClickListener() {
        	
        //	@Override
        	public void onClick(View v) {
		//		Intent openGameh = new Intent("edu.uml.thumbsup.GAME1H");
		//		startActivity(openGameh);			
        //	}
        		func(a , s0);	
			}
		});
        
        answers1.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(b,s2);	
   			}  
   		});
        
        answers2.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(c,s1);	
   			}
   		});
  
    
        
}
   
    private void func(double z, String s) {
    	if(z == .25){
    	score += 100;
    	displayScore.setText("score " + score);
    	display.setText("you are correct " + s + " is equal to 4/16");

			Intent openGameHelp = new Intent("edu.uml.thumbsup.game1help");
			startActivity(openGameHelp);			
    	
    	
    	
    	}
    	else{
    	display.setText("you are incorrect " + s + " is not equal to 4/16");
    	}
    	
    	 
		
	}
    }