package edu.uml.thumbsup;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1s extends Activity{

    /** Called when the activity is first created. */
	
	int    score = 0;
	String s0 = "1/4";
	String s1 = "1/3";
	String s2 = "1/2";
	double a = .25;
	double b = .3;
	double c = .5;
	//Button continue1;
	Button sanswers0;
	Button sanswers1;
	Button sanswers2;
	TextView sdisplay;
	TextView displayScore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1s);
        
       // continue1 = (Button)findViewById(R.id.bContinue);
        sanswers0 = (Button) findViewById(R.id.bsAnswers0);
        sanswers1 = (Button) findViewById(R.id.bsAnswers1);
        sanswers2 = (Button) findViewById(R.id.bsAnswers2);
        displayScore = (TextView)findViewById(R.id.Score);
        sdisplay = (TextView)findViewById(R.id.tvsDisplay);
       
        
     
        sanswers0.setOnClickListener(new View.OnClickListener() {
        	
        
        	public void onClick(View v) {
		
        		func(a,s0);	
			}
		});
        
        sanswers1.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(b,s2);	
   			}  
   		});
        
        sanswers2.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				func(c,s1);	
   			}
   		});
  
    
        
}
   
    private void func(double z, String s) {
    	if(z == .25){
    	score += 100;
    	displayScore.setText("score " + score);
    	sdisplay.setText("you are correct " + s + " ");

    	
    	}
    	else{
    	sdisplay.setText("you are incorrect " + s + " ");
    	}
    	
    	 
		
	}
    }