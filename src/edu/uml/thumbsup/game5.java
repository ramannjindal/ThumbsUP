package edu.uml.thumbsup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class game5 extends Activity implements OnClickListener {

	private static final int numImageButtons = 16;
	private static final int numImages = 8; // There should be 1 image for every 2 buttons
	
	private ImageButton[] imageButtons = new ImageButton[numImageButtons];
	private int[] imageAssignments = new int[numImageButtons];
	private ImageButton selectedButton = null;
	
	private static final Integer images[] = {
		R.drawable.green, R.drawable.grey, R.drawable.blue, R.drawable.black,
		R.drawable.brown, R.drawable.yellow, R.drawable.white, R.drawable.orange
	};
	private static final int thumbsUpImage = R.drawable.icon;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.game5);
        
        imageButtons[0]  = (ImageButton) this.findViewById(R.id.imageButton00);
        imageButtons[1]  = (ImageButton) this.findViewById(R.id.imageButton01);
        imageButtons[2]  = (ImageButton) this.findViewById(R.id.imageButton02);
        imageButtons[3]  = (ImageButton) this.findViewById(R.id.imageButton03);
        imageButtons[4]  = (ImageButton) this.findViewById(R.id.imageButton04);
        imageButtons[5]  = (ImageButton) this.findViewById(R.id.imageButton05);
        imageButtons[6]  = (ImageButton) this.findViewById(R.id.imageButton06);
        imageButtons[7]  = (ImageButton) this.findViewById(R.id.imageButton07);
        imageButtons[8]  = (ImageButton) this.findViewById(R.id.imageButton08);
        imageButtons[9]  = (ImageButton) this.findViewById(R.id.imageButton09);
        imageButtons[10] = (ImageButton) this.findViewById(R.id.imageButton10);
        imageButtons[11] = (ImageButton) this.findViewById(R.id.imageButton11);
        imageButtons[12] = (ImageButton) this.findViewById(R.id.imageButton12);
        imageButtons[13] = (ImageButton) this.findViewById(R.id.imageButton13);
        imageButtons[14] = (ImageButton) this.findViewById(R.id.imageButton14);
        imageButtons[15] = (ImageButton) this.findViewById(R.id.imageButton15);
        
        ArrayList<Integer> imageButtonArray = new ArrayList<Integer>();
        for (int i = 0; i < numImageButtons; i++) {
        	imageButtons[i].setOnClickListener(this);
        	imageButtonArray.add(i);
        	imageButtons[i].setImageResource(thumbsUpImage);
        }
        
        Collections.shuffle(imageButtonArray);
        
        for (int i = 0; i < numImageButtons; i++) {
        	int j = imageButtonArray.get(i);
        	imageAssignments[j] = images[i % numImages];
        	imageButtons[j].setTag(images[i % numImages]);
        	//imageButtons[j].setImageResource(images[i % numImages]);
        }
	}
	
	public void onClick(View v) {
		ImageButton ib = (ImageButton)v;
		ib.setImageResource((Integer)ib.getTag());
		if (ib != selectedButton) {
			if (selectedButton == null) {
				selectedButton = ib;
			} else {
				if (ib.getTag() == selectedButton.getTag()) {
					ib.setEnabled(false);
					selectedButton.setEnabled(false);
					selectedButton = null;
				} else {
					/*
					Thread reset = new Thread(new Runnable(){
						public void run() {
						*/
							ib.setImageResource(thumbsUpImage);
							selectedButton.setImageResource(thumbsUpImage);
							selectedButton = null; /*
						}
					});
					reset.start();
					*/
				}
			}
		}
	}
}
