package edu.uml.thumbsup;

/* Developer - Caleb Brandon & Mike Feole */

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class gamemenu extends Activity{
	int gameNumber = 0;
	/* BE SURE TO UPDATE THIS IF WE ADD/REMOVE GAMES */
	final int totalGames = 7;
	Button bSelectedGame, bArrowRight, bArrowLeft;
	MediaPlayer mpButtonClick;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamemenu);
		mpButtonClick = MediaPlayer.create(this, R.raw.bgmusic);
		mpButtonClick.start();
		
		
		bSelectedGame = (Button) findViewById(R.id.game_button);
		bSelectedGame.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				AnimationSet set = new AnimationSet(true);
				Animation animation = new AlphaAnimation(0,10);
				animation.setDuration(100);
				set.addAnimation(animation);
				bSelectedGame.startAnimation(set);

				LaunchSelectedGame();
			}
		});

		bArrowRight = (Button) findViewById(R.id.arrow_right_button);
		bArrowRight.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				gameNumber = (gameNumber + 1) % totalGames;
				ChangeCurrentButtonText();
			}
		});

		bArrowLeft = (Button) findViewById(R.id.arrow_left_button);
		bArrowLeft.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				gameNumber = (gameNumber - 1) % totalGames;
				gameNumber = (gameNumber < 0 ? totalGames - 1 : gameNumber);
				ChangeCurrentButtonText();
			}
		});
	}
	 


	private void ChangeCurrentButtonText(){
		switch(gameNumber){
		case 0:
			bSelectedGame.setText(R.string.game1_name);
			break;
		case 1:
			bSelectedGame.setText(R.string.game2_name);
			break;
		case 2:
			bSelectedGame.setText(R.string.game3_name);
			break;
		case 3:
			bSelectedGame.setText(R.string.game4_name);
			break;
		case 4:
			bSelectedGame.setText(R.string.game5_name);
			break;
		case 5:
			bSelectedGame.setText(R.string.game6_name);
			break;
		case 6:
			bSelectedGame.setText(R.string.game8_name);
			break;
		}
	}

	private void LaunchSelectedGame(){
		switch(gameNumber){
		case 0:
			Intent openGame1 = new Intent("edu.uml.thumbsup.GAME1");
			startActivity(openGame1);
			mpButtonClick.pause();
			break;
		case 1:
			Intent openGame2 = new Intent("edu.uml.thumbsup.GAME2");
			startActivity(openGame2);
			mpButtonClick.pause();
			break;
		case 2:
			Intent openGame3 = new Intent("edu.uml.thumbsup.GAME3");
			startActivity(openGame3);
			mpButtonClick.pause();
			break;
		case 3:
			Intent openGame4 = new Intent("edu.uml.thumbsup.GAME4");
			startActivity(openGame4);
			mpButtonClick.pause();
			break;
		case 4:
			Intent openGame5 = new Intent("edu.uml.thumbsup.GAME5");
			startActivity(openGame5);
			mpButtonClick.pause();
			break;
		case 5:
			Intent openGame6 = new Intent("edu.uml.thumbsup.GAME6");
			startActivity(openGame6);
			mpButtonClick.pause();
			break;
		case 6:
			Intent openGame8 = new Intent("edu.uml.thumbsup.GAME8");
			startActivity(openGame8);
			mpButtonClick.pause();
			break;
		}
	}
	
    @Override
    protected void onDestroy() {
    	mpButtonClick.release();   	
    	super.onDestroy();
    }
}