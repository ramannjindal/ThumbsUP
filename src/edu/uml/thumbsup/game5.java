package edu.uml.thumbsup;

/* Developers - Mike Feole & Elad Shahar */

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class game5 extends Activity implements OnClickListener {

	private static final int numImageButtons = 16;
	private static final int numImages = 8; // There should be 1 image for every 2 buttons
	
	private ImageButton[] imageButtons = new ImageButton[numImageButtons];
	private int[] imageAssignments = new int[numImageButtons];
	private ImageButton prevButton = null, currButton = null;
	
	private TextView tvScore;
	
	private static final Integer images[] = {
		R.drawable.ada, R.drawable.babbage, R.drawable.chen, R.drawable.darwin,
		R.drawable.luther, R.drawable.rasputin, R.drawable.tesla, R.drawable.washington
	};
	private static final int thumbsUpImage = R.drawable.icon;
	
	private int score = 0, completed = 0; 
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.game5);
        
        tvScore = (TextView) this.findViewById(R.id.game5_score);
        
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
        }
	}
	
	public void onClick(View v) {
		currButton = (ImageButton)v;
		currButton.setImageResource((Integer)currButton.getTag());
		if (currButton != prevButton) {
			if (prevButton == null) {
				prevButton = currButton;
			} else {
				for (int i = 0; i < numImageButtons; i++) {
					imageButtons[i].setEnabled(false);
				}
				if (currButton.getTag() == prevButton.getTag()) {
					score += 10;
					tvScore.setText("Score: " + score);
					
					completed++;
					if (completed == numImages) {
						currButton.setVisibility(View.INVISIBLE);
						prevButton.setVisibility(View.INVISIBLE);
						
						String scoreMsg;
						
						if (score > Global.scores[4]) {
							Global.scores[4] = score;
							scoreMsg = "You got a new high score of " + score + "!!!";
						} else {
							scoreMsg = "You got a score of " + score + "!";
						}
						
						 // Create the alert box
			            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
			            // Set the message to display
			            alertbox.setMessage(scoreMsg);
						// Add a neutral button to the alert box and
						// assign a click listener
						alertbox.setNeutralButton("OK",
								new DialogInterface.OnClickListener() {
									// Click listener on the neutral button of alert box
									public void onClick(DialogInterface arg0, int arg1) {
										// The neutral button was clicked
										finish();
									}
								});

			            // show the alert box
			            alertbox.show();
					} else {
						v.postDelayed(new Runnable() {
							public void run() {
								currButton.setVisibility(View.INVISIBLE);
								prevButton.setVisibility(View.INVISIBLE);
								prevButton = null;
								currButton = null;
								for (int i = 0; i < numImageButtons; i++) {
									imageButtons[i].setEnabled(true);
								}
							}
						}, 500);
					}
				} else {
					score -= 1;
					tvScore.setText("Score: " + score);
					
					v.postDelayed(new Runnable() {
						public void run() {
							currButton.setImageResource(thumbsUpImage);
							prevButton.setImageResource(thumbsUpImage);
							prevButton = currButton = null;
							for (int i = 0; i < numImageButtons; i++) {
								imageButtons[i].setEnabled(true);
							}
						}	
					}, 500);
				}
			}
		}
	}
}
