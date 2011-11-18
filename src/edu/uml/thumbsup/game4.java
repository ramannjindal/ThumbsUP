package edu.uml.thumbsup;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
               //      bgSong.release();
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
		value = (((int)(timer) - (count*30))/10)*2;
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
	
	
	
	
	
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.game4);	
			Log.v(LOG_TAG, "XML WORKING FINE");
			
		//	bgSong = MediaPlayer.create(game4.this,R.raw.bgmusic) ;
	        MyCount counter = new MyCount(500000,1000);
	        counter.start();
	        
	    //  bgSong.start();
	        repeat();
	        
	        
	        final ImageButton blackbutton = (ImageButton) findViewById(R.id.black);
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
	        
	        final ImageButton bluebutton = (ImageButton) findViewById(R.id.blue);
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
	        
	        
	        final ImageButton brownbutton = (ImageButton) findViewById(R.id.brown);
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
	        
	        final ImageButton greenbutton = (ImageButton) findViewById(R.id.green);
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
	        
	        final ImageButton greybutton = (ImageButton) findViewById(R.id.grey);
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

	        final ImageButton orangebutton = (ImageButton) findViewById(R.id.orange);
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
	        
	        final ImageButton pinkbutton = (ImageButton) findViewById(R.id.pink);
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
	        
	        final ImageButton purplebutton = (ImageButton) findViewById(R.id.purple);
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
	        
	        final ImageButton redbutton = (ImageButton) findViewById(R.id.red);
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
	        
	        final ImageButton whitebutton = (ImageButton) findViewById(R.id.white);
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
	        
	        final ImageButton yellowbutton = (ImageButton) findViewById(R.id.yellow);
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