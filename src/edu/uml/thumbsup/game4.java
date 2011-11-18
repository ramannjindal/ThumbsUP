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
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
                     bgSong.release();
                     finish();
                     }
               });
            
            // show the alert box
            alertbox.show();
            Log.v(LOG_TAG, "size:" + alreadyUsed.size());
	        }	   
  }
	
	int scores(){
		return 0;
	}
	
	
	
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.game4);	
			Log.v(LOG_TAG, "XML WORKING FINE");
		
		}
}