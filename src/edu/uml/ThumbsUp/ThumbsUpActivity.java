package edu.uml.thumbsup;

import edu.uml.thumbsup.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ThumbsUPActivity extends Activity {
    /** Called when the activity is first created. */
    
    Button bNewGame, bHighScores, bOptions, bCredits ;
    TextView mainDisplay ;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bNewGame = (Button) findViewById(R.id.button1);
        bHighScores = (Button) findViewById(R.id.Button01);
        bOptions = (Button) findViewById(R.id.Button02);
        bCredits = (Button) findViewById(R.id.Button03);
        mainDisplay = (TextView) findViewById(R.id.textView1);
    }
}