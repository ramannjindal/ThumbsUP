package edu.uml.thumbsup;

import edu.uml.thumbsup.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThumbsUPActivity extends Activity {
    /** Called when the activity is first created. */
    
    Button bNewGame, bHighScores, bOptions, bCredits ;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bNewGame = (Button) findViewById(R.id.mbutton1);
        bHighScores = (Button) findViewById(R.id.mButton01);
        bOptions = (Button) findViewById(R.id.mButton02);
        bCredits = (Button) findViewById(R.id.mButton03);
        
        bNewGame.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		
				Intent openGameMenu = new Intent("edu.uml.thumbsup.GAMEMENU");
				startActivity(openGameMenu);
        		
        	}
        });        
    }
}