package edu.uml.thumbsup;

import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;


public class game8 extends Activity{
	private int score   = 100;
	private int penalty = 5;

	private TextView helpTV;
	private TextView scoreTV;

	private ImageView light;
	private ImageView battery;

	private Tile[] resistors   = new Tile[4];
	private Tile[] straitwires = new Tile[4];
	private Tile[] curvedwires = new Tile[8];


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game8);

		/**
		 * Non-rotatable objects, i.e.:
		 *  text views, the light, and the battery
		 **/
		helpTV = (TextView)this.findViewById(R.id.TextView01);

		scoreTV = (TextView)this.findViewById(R.id.Score);
		scoreTV.setText("Score: " + score);

		light = (ImageView)this.findViewById(R.id.Light);
		light.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						helpTV.setText("A light emitting diode (LED) which requires 3 Volts.");
					}
				});        
		battery = (ImageView)this.findViewById(R.id.Battery);
		battery.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						helpTV.setText("A battery which provides 9 Volts.");
					}
				});

		/**
		 * Rotatable objects, i.e.:
		 *  all the wires and resistors
		 **/
		resistors[0] = new Tile((ImageView)this.findViewById(R.id.resistor0));
		resistors[1] = new Tile((ImageView)this.findViewById(R.id.resistor1));
		resistors[2] = new Tile((ImageView)this.findViewById(R.id.resistor2));
		resistors[3] = new Tile((ImageView)this.findViewById(R.id.resistor3));

		for(final Tile resistor : resistors){						// For each resistor...
			RotateImageView(resistor);								//  ...apply random start rotation
			resistor.graphic.setOnClickListener(					//  ...set up the click events
					new OnClickListener(){
						public void onClick(View v){
							helpTV.setText("A resistor that lowers current by 1.5 Volts.");
							scoreTV.setText("Score: " + score);

							RotateImageView(resistor);				// Rotate the object on click

							if(DidIWin())
								onDestroy();

							score = Math.max(0, score - penalty);	// Keep the score non-negative
						}
					});
		}


		straitwires[0] = new Tile((ImageView)this.findViewById(R.id.wire00));
		straitwires[1] = new Tile((ImageView)this.findViewById(R.id.wire07));
		straitwires[2] = new Tile((ImageView)this.findViewById(R.id.wire09));
		straitwires[3] = new Tile((ImageView)this.findViewById(R.id.wire11));

		for(final Tile strait : straitwires){						// For each straight wire...
			RotateImageView(strait);								//  ...apply random start rotation
			strait.graphic.setOnClickListener(						//  ...set up the click events
					new OnClickListener(){
						public void onClick(View v){
							helpTV.setText("A wire through which current may run.");
							scoreTV.setText("Score: " + score);

							RotateImageView(strait);				// Rotate the object on click

							if(DidIWin())
								onDestroy();

							score = Math.max(0, score - penalty);	// Keep the score non-negative
						}
					});
		}

		curvedwires[0] = new Tile((ImageView)this.findViewById(R.id.wire01));
		curvedwires[1] = new Tile((ImageView)this.findViewById(R.id.wire02));
		curvedwires[2] = new Tile((ImageView)this.findViewById(R.id.wire03));
		curvedwires[3] = new Tile((ImageView)this.findViewById(R.id.wire04));
		curvedwires[4] = new Tile((ImageView)this.findViewById(R.id.wire05));
		curvedwires[5] = new Tile((ImageView)this.findViewById(R.id.wire06));
		curvedwires[6] = new Tile((ImageView)this.findViewById(R.id.wire08));
		curvedwires[7] = new Tile((ImageView)this.findViewById(R.id.wire10));

		for(final Tile curved : curvedwires){						// For each curved wire...
			RotateImageView(curved);								//  ...apply random start rotation
			curved.graphic.setOnClickListener(						//  ...set up the click events
					new OnClickListener(){
						public void onClick(View v){
							helpTV.setText("A wire through which current may run.");
							scoreTV.setText("Score: " + score);

							RotateImageView(curved);				// Rotate the object on click

							if(DidIWin())
								onDestroy();

							score = Math.max(0, score - penalty);	// Keep the score non-negative
						}
					});
		}
	}

	// Rotates an ImageView by 90
	private void RotateImageView(Tile tile_){
		/**
		 * Set up stage
		 **/
		// Variables for for the current object's ID and a blank bitmap
		Integer tag = (Integer)tile_.graphic.getId();
		Bitmap btmp = null;

		// These contain all the IDs for the rotatable objects loaded into this intent
		int[] straightIDs = {R.id.wire00,R.id.wire05,R.id.wire07,R.id.wire09,R.id.wire11};
		int[] resistorIDs = {R.id.resistor0,R.id.resistor1,R.id.resistor2,R.id.resistor3};
		int[] curvedIDs   = {R.id.wire01,R.id.wire02,R.id.wire03,R.id.wire04,R.id.wire06,R.id.wire08,R.id.wire10};

		// Compare the current object's ID to each of the other IDs
		for(int ID : resistorIDs)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.resistor);
		for(int ID : curvedIDs)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.curved_wire);
		for(int ID : straightIDs)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.straight_wire);

		/**
		 * Actual rotation stage
		 **/
		// Variables for the newly filled bitmap's dimensions
		int w = btmp.getWidth();
		int h = btmp.getHeight();

		// Creates a rotation matrix for the bitmap
		Matrix m = new Matrix();
		m.postRotate(90 + tile_.rotation);

		// Applies the matrix to the bitmap, and stores it in a BitmapDrawable
		Bitmap bm = Bitmap.createBitmap(btmp,0,0,w,h,m,true);
		BitmapDrawable bitmap = new BitmapDrawable(bm);

		// Change the object's graphic and rotation value
		tile_.graphic.setImageDrawable(bitmap);
		tile_.rotation = (tile_.rotation + 90) % 360;
	}

	// Badly made victory decider
	private Boolean DidIWin(){
		int winConditions = 0;		// Count of correctly rotated objects

		if(resistors[0].rotation == 90 || resistors[0].rotation == 270)
			winConditions++;
		if(resistors[1].rotation == 0  || resistors[1].rotation == 180)
			winConditions++;
		if(resistors[2].rotation == 90 || resistors[2].rotation == 270)
			winConditions++;
		if(resistors[3].rotation == 0  || resistors[3].rotation == 180)
			winConditions++;

		if(straitwires[0].rotation == 0  || straitwires[0].rotation == 180)
			winConditions++;
		if(straitwires[1].rotation == 90 || straitwires[1].rotation == 270)
			winConditions++;

		if(curvedwires[0].rotation == 0)
			winConditions++;
		if(curvedwires[1].rotation == 90)
			winConditions++;
		if(curvedwires[2].rotation == 270)
			winConditions++;
		if(curvedwires[3].rotation == 180)
			winConditions++;
		if(curvedwires[5].rotation == 0)
			winConditions++;
		if(curvedwires[6].rotation == 180)
			winConditions++;
		
		if(winConditions == 12)
			return true;

		return false;
	}

	@Override
	public void onDestroy(){
		super.onDestroy();

		if(DidIWin())
			if(score >= Global.scores[6])		// Compares and edits the high scores
				Global.scores[6] = score;
	}
}

// A basic class that contains an ImageView
//  and some rotation data
class Tile{
	public ImageView graphic;
	public int rotation;


	public Tile(ImageView graphic_){
		graphic = graphic_;

		// Rotation begins as a random quarter turn
		Random rand = new Random();
		rotation = (rand.nextInt(4) * 90) % 360;
	}
}