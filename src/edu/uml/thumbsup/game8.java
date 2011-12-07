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
	// Score begins as 250 since 16 spins and score decrements accrue on start
	private int score = 250;

	private TextView tv;
	private TextView scoreTV;

	private ImageView light;
	private ImageView battery;

	private Tile[] resistors   = new Tile[4];
	private Tile[] straitWires = new Tile[5];
	private Tile[] curvedWires = new Tile[7];


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game8);

		/**
		 * Non-rotatable Views
		 **/
		tv = (TextView)this.findViewById(R.id.TextView01);
		tv.setText("Select an item to see its description.");

		scoreTV = (TextView)this.findViewById(R.id.Score);
		scoreTV.setText("Score: 100");

		light = (ImageView)this.findViewById(R.id.Light);
		light.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A light emitting diode (LED) which requires 3 Volts.");
					}
				});        
		battery = (ImageView)this.findViewById(R.id.Battery);
		battery.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A battery which provides 9 Volts.");
					}
				});

		/**
		 * Rotatable Views
		 **/
		resistors[0] = new Tile((ImageView)this.findViewById(R.id.Resistor00));
		resistors[1] = new Tile((ImageView)this.findViewById(R.id.Resistor01));
		resistors[2] = new Tile((ImageView)this.findViewById(R.id.Resistor02));
		resistors[3] = new Tile((ImageView)this.findViewById(R.id.Resistor03));

		for(final Tile resistor : resistors){
			RotateImageView(resistor);
			resistor.graphic.setOnClickListener(
					new OnClickListener(){
						public void onClick(View v){
							tv.setText("A resistor that lowers current by 1.5 Volts.");
							scoreTV.setText("Score: " + score);
							RotateImageView(resistor);
						}
					});
		}


		straitWires[0] = new Tile((ImageView)this.findViewById(R.id.Wire00));
		straitWires[1] = new Tile((ImageView)this.findViewById(R.id.Wire05));
		straitWires[2] = new Tile((ImageView)this.findViewById(R.id.Wire07));
		straitWires[3] = new Tile((ImageView)this.findViewById(R.id.Wire09));
		straitWires[4] = new Tile((ImageView)this.findViewById(R.id.Wire11));

		for(final Tile strait : straitWires){
			RotateImageView(strait);
			strait.graphic.setOnClickListener(
					new OnClickListener(){
						public void onClick(View v){
							tv.setText("A wire through which current may run.");
							scoreTV.setText("Score: " + score);
							RotateImageView(strait);
						}
					});
		}

		curvedWires[0] = new Tile((ImageView)this.findViewById(R.id.Wire01));
		curvedWires[1] = new Tile((ImageView)this.findViewById(R.id.Wire02));
		curvedWires[2] = new Tile((ImageView)this.findViewById(R.id.Wire03));
		curvedWires[3] = new Tile((ImageView)this.findViewById(R.id.Wire04));
		curvedWires[4] = new Tile((ImageView)this.findViewById(R.id.Wire06));
		curvedWires[5] = new Tile((ImageView)this.findViewById(R.id.Wire08));
		curvedWires[6] = new Tile((ImageView)this.findViewById(R.id.Wire10));

		for(final Tile curved : curvedWires){
			RotateImageView(curved);
			curved.graphic.setOnClickListener(
					new OnClickListener(){
						public void onClick(View v){
							tv.setText("A wire through which current may run.");
							scoreTV.setText("Score: " + score);
							RotateImageView(curved);
						}
					});
		}
	}

	// Rotates an ImageView by 90
	private void RotateImageView(Tile tile_){
		Integer tag = (Integer)tile_.graphic.getId();
		Bitmap btmp = null;

		int[] straightIDs = {R.id.Wire00,R.id.Wire05,R.id.Wire07,R.id.Wire09,R.id.Wire11};
		int[] resistorIDs = {R.id.Resistor00,R.id.Resistor01,R.id.Resistor02,R.id.Resistor03};
		int[] curvedIDs   = {R.id.Wire01,R.id.Wire02,R.id.Wire03,R.id.Wire04,R.id.Wire06,R.id.Wire08,R.id.Wire10};
		
		for(int ID : resistorIDs)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.resistor);
		for(int ID : curvedIDs)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.curved_wire);
		for(int ID : straightIDs)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.straight_wire);

		// Rotation part
		int w = btmp.getWidth();
		int h = btmp.getHeight();

		Matrix m = new Matrix();
		m.postRotate(90 + tile_.rotation);

		Bitmap bm = Bitmap.createBitmap(btmp,0,0,w,h,m,true);
		BitmapDrawable bitmap = new BitmapDrawable(bm);

		tile_.graphic.setImageDrawable(bitmap); 

		tile_.rotation = (tile_.rotation + 90) % 360;

		// Lower the score
		score = Math.max(0, score - 10);
	}
}


class Tile{
	public ImageView graphic;
	public int rotation;


	public Tile(ImageView graphic_){
		graphic = graphic_;

		Random rand = new Random();
		rotation = (rand.nextInt(4) * 90) % 360;
	}
}