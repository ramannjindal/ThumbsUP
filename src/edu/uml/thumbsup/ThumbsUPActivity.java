package edu.uml.thumbsup;

import edu.uml.thumbsup.R;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;


public class ThumbsUPActivity extends Activity {
    Button bNewGame, bHighScores, bOptions, bCredits;
    MediaPlayer mpButtonClick;
    	
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mpButtonClick = MediaPlayer.create(this, R.raw.bgmusic);
		mpButtonClick.start();
		
        bNewGame 	= (Button) findViewById(R.id.mButton_newgame);
        bHighScores = (Button) findViewById(R.id.mButton_highscores);
        bOptions 	= (Button) findViewById(R.id.mButton_options);
        bCredits 	= (Button) findViewById(R.id.mButton_credits);
        
        bNewGame.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
				Intent openGameMenu = new Intent("edu.uml.thumbsup.GAMEMENU");
				
				AnimationSet set = new AnimationSet(true);
				Animation animation = new AlphaAnimation(0,10);
				animation.setDuration(100);
				set.addAnimation(animation);
				bNewGame.startAnimation(set); 
				mpButtonClick.pause();
				startActivity(openGameMenu);
        	}
        });  
        
        bHighScores.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent openScoreMenu = new Intent("edu.uml.thumbsup.SCOREMENU");
				
				AnimationSet set = new AnimationSet(true);
				Animation animation = new AlphaAnimation(0,10);
				animation.setDuration(100);
				set.addAnimation(animation);
				bHighScores.startAnimation(set); 
				
				startActivity(openScoreMenu);
			}
		});
        
        bCredits.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent openCredits = new Intent("edu.uml.thumbsup.CREDITS");
				
				AnimationSet set = new AnimationSet(true);
				Animation animation = new AlphaAnimation(0,10);
				animation.setDuration(100);
				set.addAnimation(animation);
				bCredits.startAnimation(set);
				
				startActivity(openCredits);
			}
		});
    }
    
    @Override
    protected void onDestroy() {
    	mpButtonClick.release();   	
    	super.onDestroy();
    }
    
  /*  @Override
    public void onBackPressed() {
       mpButtonClick.pause();
        // implement your override logic here
       return;
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            Log.d("CDA", "onKeyDown Called");

            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/

}