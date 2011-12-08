package edu.uml.thumbsup;


import java.util.Random;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;

import android.media.MediaPlayer;

import android.os.Bundle;
import android.os.CountDownTimer;

import android.util.Log;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class game4 extends Activity {
	
	public static final String LOG_TAG = "CHECKING";
	MediaPlayer bgSong;
	private String[] color;;
	private static final Random myRandom = new Random();
	public String colorSelect;
	Vector<String> alreadyUsed = new Vector<String>();
	int count = 0; 
	long timer;
		
	public void repeat(){
	    Resources res = getResources();      
        //fetches values from the array in string.xml
	    color = res.getStringArray(R.array.colors);
       
	    // selects a random value out of color string array Ex: color[5], color[3]   	    
	    do{
		    colorSelect = color[myRandom.nextInt(color.length)];
	        } while(alreadyUsed.contains(colorSelect));
	        alreadyUsed.add(colorSelect);
     
	        
        TextView tv = (TextView)findViewById(R.id.generatecolor);
        tv.setText(colorSelect);
        
        if(alreadyUsed.size() == 12){
        	
        	int scorevalue = scores();
        	
	        Log.v(LOG_TAG, "size:" + alreadyUsed.size());
	        Log.v(LOG_TAG, "mistakes:" + count);
	        
	        // Create the alert box
            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
            // Set the message to display
            alertbox.setMessage("You Completed with a score = " + scorevalue);
            // Add a neutral button to the alert box and assign a click listener
            	alertbox.setNeutralButton("EXIT", new DialogInterface.OnClickListener() {
            		//Click listener on the neutral button of alert box
            		  public void onClick(DialogInterface arg0, int arg1) {
                      // The neutral button was clicked
                     Toast.makeText(getApplicationContext(), "'EXIT' button clicked", Toast.LENGTH_LONG).show();
                     //finish();
                     finish();
                     }
               });
            
            // show the alert box
            alertbox.show();
            Log.v(LOG_TAG, "size:" + alreadyUsed.size());
	        }	   
  }
	
	
	int scores(){
		int value;
		int[] score_array = getResources().getIntArray(R.array.scores);
		
		value = (((int)(timer) - (count*30))/10)*2;
		if(value >= score_array[3]){
			score_array[3]= value;
		}
		else{
			Context context = getApplicationContext();
			CharSequence text = "No the Highest Score";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
			toast.show();	
		}
		return value;
	}
	
	
	
	
	
	public class MyCount extends CountDownTimer{

		public MyCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			Log.v(LOG_TAG,"COUNTER DONE");
		}	

		@Override
		public void onTick(long millisUntilFinished) {
			timer = millisUntilFinished/1000;
		}
		
	}
	
	
	
	
	
	 	@Override
		public void onCreate(Bundle onsaveInstanceState){
			super.onCreate(onsaveInstanceState);
			setContentView(R.layout.game4);	
			Log.v(LOG_TAG, "XML WORKING FINE");
			
			bgSong = MediaPlayer.create(game4.this,R.raw.bgmusic) ;
	        MyCount counter = new MyCount(500000,1000);
	        counter.start();
	        
	        repeat();
	        
	        final ImageButton blackbutton = (ImageButton) findViewById(R.id.black);
	        final ImageButton bluebutton = (ImageButton) findViewById(R.id.blue);
	        final ImageButton brownbutton = (ImageButton) findViewById(R.id.brown);
	        final ImageButton greenbutton = (ImageButton) findViewById(R.id.green);
	        final ImageButton greybutton = (ImageButton) findViewById(R.id.grey);
	        final ImageButton orangebutton = (ImageButton) findViewById(R.id.orange);
	        final ImageButton pinkbutton = (ImageButton) findViewById(R.id.pink);
	        final ImageButton purplebutton = (ImageButton) findViewById(R.id.purple);
	        final ImageButton redbutton = (ImageButton) findViewById(R.id.red);
	        final ImageButton yellowbutton = (ImageButton) findViewById(R.id.yellow);
	        final ImageButton whitebutton = (ImageButton) findViewById(R.id.white);
	        
	     	        
	        blackbutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("BLACK")){
	                	blackbutton.setVisibility(View.INVISIBLE);  
	                  	repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        
	        bluebutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("BLUE")){
	                	bluebutton.setVisibility(View.INVISIBLE);
	                	repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        
	        brownbutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("BROWN")){
	                	brownbutton.setVisibility(View.INVISIBLE);
	                	repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        final ImageButton darkbluebutton = (ImageButton) findViewById(R.id.darkblue);
	        darkbluebutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("DARK BLUE")){
	                	darkbluebutton.setVisibility(View.INVISIBLE);
	                	repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	                
	        greenbutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("GREEN")){
	                	greenbutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        
	        greybutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("GREY")){
	                	greybutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });

	        
	        orangebutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("ORANGE")){
	                	orangebutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        
	        pinkbutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("PINK")){
	                	pinkbutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        

	        
	        purplebutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("PURPLE")){
	                	purplebutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        
	        redbutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("RED")){
	                	redbutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        
	        whitebutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("WHITE")){
	                	whitebutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	        
	        
	        yellowbutton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Log.v(LOG_TAG, "button clicked");
	                if(colorSelect.equals("YELLOW")){
	                	yellowbutton.setVisibility(View.INVISIBLE);
	                	 repeat();
	                }
	                else{
	                	count++;
	                }
	            }
	        });
	 
   }
}