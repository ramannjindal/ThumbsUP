package edu.uml.thumbsup;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;


import android.app.Activity;
import android.content.Context;
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

public class game4 extends Activity {
	
	public static final String LOG_TAG = "CHECKING";
	MediaPlayer bgSong;
	private String[] color;;
	private static final Random myRandom = new Random();
	public String colorSelect;
	Vector<String> alreadyUsed = new Vector<String>();
	int count = 0; 
	long timer;
	
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.game4);	
			Log.v(LOG_TAG, "XML WORKING FINE");
		
		}
}