package edu.uml.thumbsup;
//Paul Gendreau


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
	TextView displayhome;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1);
        
        Dividing = (Button) findViewById(R.id.bDividing);
        multiplying = (Button) findViewById(R.id.bmultiplying);
        Reducing = (Button) findViewById(R.id.bReducing);
        Adding = (Button) findViewById(R.id.bAdding);
        helpmenu = (Button) findViewById(R.id.bHelp);
        displayhome = (TextView)findViewById(R.id.tvDisplayhome);
        
        Dividing.setOnClickListener(new View.OnClickListener() {
        	
        //	@Override
        	public void onClick(View v) {
		//		Intent openGameh = new Intent("edu.uml.thumbsup.GAME1HELP");
		//		startActivity(openGameh);			
        //	}
        			
			}
		});
        
        multiplying.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   					
   			}  
   		});
        
        Reducing.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   				
   			}
   		});
        Adding.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   					
   			}
   		});
        helpmenu.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v) {
   				
   			 setContentView(R.layout.game1help);
   			}
   		});
        
}	
}
    