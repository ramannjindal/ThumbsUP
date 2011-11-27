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
                
        sol = (TextView)findViewById(R.id.textView1);
        Button ansButton = (Button)findViewById(R.id.selected);
        
        ansButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int count = checkStates();
				int ans = scores(count);	
				sol.setText("Score: " + ans);
			}

		});
               
	}
	
		public int scores(int count){
			int score = count * 10;
			return score;
		}
	
		public int checkStates(){
			int val = 0;
			RadioButton rButton[] = new RadioButton[10];
			
			for(int i=1; i<10;i++){
				rButton[i] = (RadioButton)findViewById(R.id.option1);
			}
			return val;
		}
	
	
}
      /*  
        rButtons[1]=(RadioButton)findViewById(R.id.option1);
        rButtons[2]=(RadioButton)findViewById(R.id.option2);
        rButtons[3]=(RadioButton)findViewById(R.id.option3);
        rButtons[4]=(RadioButton)findViewById(R.id.option4);
        rButtons[5]=(RadioButton)findViewById(R.id.option5);
        rButtons[6]=(RadioButton)findViewById(R.id.option6);
        rButtons[7]=(RadioButton)findViewById(R.id.option7);
        rButtons[8]=(RadioButton)findViewById(R.id.option8);
        rButtons[9]=(RadioButton)findViewById(R.id.option9);
        rButtons[10]=(RadioButton)findViewById(R.id.option10);
        
	private void checkStates(RadioButton[] buttons){
		for(int i=1;i<=10;i++){
			if(buttons[i].isChecked()){
			count ++;
			}
		}
		scores();
	}
	*/
	
