package edu.uml.thumbsup;

import java.util.ArrayList;


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
	
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.game4);	
			Log.v(LOG_TAG, "XML WORKING FINE");
		
		}
}