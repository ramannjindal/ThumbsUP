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
	private int score = 1000;

	private TextView tv;
	private TextView scoreTV;

	private ImageView light;
	private ImageView battery;

	private Tile resistor1;
	private Tile resistor2;
	private Tile resistor3;
	private Tile resistor4;	
	private Tile wire01;
	private Tile wire02;
	private Tile wire03;
	private Tile wire04;
	private Tile wire05;
	private Tile wire06;
	private Tile wire07;
	private Tile wire08;
	private Tile wire09;
	private Tile wire10;
	private Tile wire11;
	private Tile wire12;


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
		scoreTV.setText("Score: " + score);

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
		 *  Messy looking, probably best to keep shrunk on the side
		 **/
		resistor1 = new Tile((ImageView)this.findViewById(R.id.Resistor01));
		RotateImageView(resistor1);
		resistor1.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A resistor which lowers the current by 1.5 Volts.");
						scoreTV.setText("Score: " + score);
						RotateImageView(resistor1);
					}
				});
		resistor2 = new Tile((ImageView)this.findViewById(R.id.Resistor02));
		RotateImageView(resistor2);
		resistor2.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A resistor which lowers the current by 1.5 Volts.");
						scoreTV.setText("Score: " + score);
						RotateImageView(resistor2);
					}
				});
		resistor3 = new Tile((ImageView)this.findViewById(R.id.Resistor03));
		RotateImageView(resistor3);
		resistor3.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A resistor which lowers the current by 1.5 Volts.");
						scoreTV.setText("Score: " + score);
						RotateImageView(resistor3);
					}
				});
		resistor4 = new Tile((ImageView)this.findViewById(R.id.Resistor04));
		RotateImageView(resistor4);
		resistor4.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A resistor which lowers the current by 1.5 Volts.");
						scoreTV.setText("Score: " + score);
						RotateImageView(resistor4);
					}
				});

		wire01 = new Tile((ImageView)this.findViewById(R.id.Wire01));
		RotateImageView(wire01);
		wire01.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire01);
					}
				});
		wire02 = new Tile((ImageView)this.findViewById(R.id.Wire02));
		RotateImageView(wire02);
		wire02.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire02);
					}
				});
		wire03 = new Tile((ImageView)this.findViewById(R.id.Wire03));
		RotateImageView(wire03);
		wire03.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire03);
					}
				});
		wire04 = new Tile((ImageView)this.findViewById(R.id.Wire04));
		RotateImageView(wire04);
		wire04.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire04);
					}
				});
		wire05 = new Tile((ImageView)this.findViewById(R.id.Wire05));
		RotateImageView(wire05);
		wire05.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire05);
					}
				});
		wire06 = new Tile((ImageView)this.findViewById(R.id.Wire06));
		RotateImageView(wire06);
		wire06.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire06);
					}
				});
		wire07 = new Tile((ImageView)this.findViewById(R.id.Wire07));
		RotateImageView(wire07);
		wire07.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire07);
					}
				});
		wire08 = new Tile((ImageView)this.findViewById(R.id.Wire08));
		RotateImageView(wire08);
		wire08.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire08);
					}
				});
		wire09 = new Tile((ImageView)this.findViewById(R.id.Wire09));
		RotateImageView(wire09);
		wire09.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire09);
					}
				});
		wire10 = new Tile((ImageView)this.findViewById(R.id.Wire10));
		RotateImageView(wire10);
		wire10.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire10);
					}
				});
		wire11 = new Tile((ImageView)this.findViewById(R.id.Wire11));
		RotateImageView(wire11);
		wire11.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire11);
					}
				});
		wire12 = new Tile((ImageView)this.findViewById(R.id.Wire12));
		RotateImageView(wire12);
		wire12.graphic.setOnClickListener(
				new OnClickListener()
				{
					public void onClick(View v)
					{
						tv.setText("A wire through which current may run.");
						scoreTV.setText("Score: " + score);
						RotateImageView(wire12);
					}
				});        
	}

	// Rotates an ImageView by 90
	private void RotateImageView(Tile tile_){
		Integer tag = (Integer)tile_.graphic.getId();
		Bitmap btmp = null;

		// I know, this is messy.  I like using three for() loops and arrays more than a switch here, for some reason
		int[] resistors = {R.id.Resistor01,R.id.Resistor02,R.id.Resistor03,R.id.Resistor04};
		int[] curved    = {R.id.Wire02,R.id.Wire03,R.id.Wire04,R.id.Wire05,R.id.Wire07,R.id.Wire09,R.id.Wire11};
		int[] straight  = {R.id.Wire01,R.id.Wire06,R.id.Wire08,R.id.Wire10,R.id.Wire12};

		for(int ID : resistors)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.resistor);
		for(int ID : curved)
			if(ID == tag)
				btmp = BitmapFactory.decodeResource(getResources(), R.drawable.curved_wire);
		for(int ID : straight)
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