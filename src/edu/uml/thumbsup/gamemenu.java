package edu.uml.thumbsup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class gamemenu extends Activity{
	int gameNumber = 0;
	/* BE SURE TO UPDATE THIS IF WE ADD/REMOVE GAMES */
	final int totalGames = 7;
	Button bSelectedGame, bArrowRight, bArrowLeft;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamemenu);

		bSelectedGame = (Button) findViewById(R.id.game_button);
		bSelectedGame.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				AnimationSet set = new AnimationSet(true);
				Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,30,Animation.RELATIVE_TO_SELF,30);
				animation.setDuration(1000);
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
			break;
		case 1:
			Intent openGame2 = new Intent("edu.uml.thumbsup.GAME2");
			startActivity(openGame2);
			break;
		case 2:
			Intent openGame3 = new Intent("edu.uml.thumbsup.GAME3");
			startActivity(openGame3);
			break;
		case 3:
			Intent openGame4 = new Intent("edu.uml.thumbsup.GAME4");
			startActivity(openGame4);
			break;
		case 4:
			Intent openGame5 = new Intent("edu.uml.thumbsup.GAME5");
			startActivity(openGame5);
			break;
		case 5:
			Intent openGame6 = new Intent("edu.uml.thumbsup.GAME6");
			startActivity(openGame6);
			break;
		case 6:
			Intent openGame8 = new Intent("edu.uml.thumbsup.GAME8");
			startActivity(openGame8);
			break;
		}
	}
}