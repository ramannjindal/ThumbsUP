package edu.uml.thumbsup;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class scoremenu extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.scoremenu);

        int []my_array = getResources().getIntArray(R.array.scores);
        TextView score1 = (TextView) findViewById(R.id.textView3);
        TextView score2 = (TextView) findViewById(R.id.textView5);
        TextView score3 = (TextView) findViewById(R.id.textView7);
        TextView score4 = (TextView) findViewById(R.id.textView9);
        TextView score5 = (TextView) findViewById(R.id.textView13);
        TextView score6 = (TextView) findViewById(R.id.textView10);
        TextView score7 = (TextView) findViewById(R.id.textView15);
        
        score1.setText(""+my_array[0]);
        score2.setText(""+my_array[1]);
        score3.setText(""+my_array[2]);
        score4.setText(""+my_array[3]);
        score5.setText(""+my_array[4]);
        score6.setText(""+my_array[5]);
        score7.setText(""+my_array[6]);
	}
	
}
