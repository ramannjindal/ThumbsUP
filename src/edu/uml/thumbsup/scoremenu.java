package edu.uml.thumbsup;

/* Developer - Mike Feole */

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class scoremenu extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.scoremenu);

        TextView score1 = (TextView) findViewById(R.id.textView3);
        TextView score2 = (TextView) findViewById(R.id.textView5);
        TextView score3 = (TextView) findViewById(R.id.textView7);
        TextView score4 = (TextView) findViewById(R.id.textView9);
        TextView score5 = (TextView) findViewById(R.id.textView13);
        TextView score6 = (TextView) findViewById(R.id.textView10);
        TextView score7 = (TextView) findViewById(R.id.textView15);
        
        score1.setText(""+Global.scores[0]);
        score2.setText(""+Global.scores[1]);
        score3.setText(""+Global.scores[2]);
        score4.setText(""+Global.scores[3]);
        score5.setText(""+Global.scores[4]);
        score6.setText(""+Global.scores[5]);
        score7.setText(""+Global.scores[6]);
	}
	
}
