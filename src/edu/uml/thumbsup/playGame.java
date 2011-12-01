package edu.uml.thumbsup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
//import android.widget.Toast;


public class playGame extends Activity {

	private RadioButton rButtons[] = new RadioButton[10];
	private TextView sol;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		rButtons[1] = (RadioButton)findViewById(R.id.option1);

		
		
		
		sol = (TextView)findViewById(R.id.textView1);
		Button ansButton = (Button)findViewById(R.id.selected);

		ansButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int count = checkStates();		
				int ans = scores(count);	
				sol.setText("Score: " + ans);
			}
			
			
			public int checkStates(){
				int val = 0;	
				if(rButtons[1].isChecked() == true){
					sol.setText("Checked");
					val++;
				}
				else{
					sol.setText("Unchecked");
				}
				return val;
			}
			
			
			public int scores(int count){
				int score = count * 10;
				return score;
			}
		});

	}

			
}


