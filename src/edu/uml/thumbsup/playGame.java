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

	private RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
	private TextView sol;
	int count = 0;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        rb2 = (RadioButton)findViewById(R.id.option2);      
        
        sol = (TextView)findViewById(R.id.textView1);
	
	    
	    Button ansButton = (Button)findViewById(R.id.selected);
	    ansButton.setOnClickListener(new View.OnClickListener(){
        
		//@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	     if(rb2.isChecked() == true){
	    	 count++;
	     }
	     else{
	    	sol.setText("Wrong Answer"); 
	     }
			
	    
	     sol.setText("Score: " + scores()+"/50");
		}
		
		int final_score= scores();
	
		
	 });
	}  
	
	int scores(){
		int score = count * 10;
		return score;
	}
}
