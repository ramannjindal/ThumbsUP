package edu.uml.thumbsup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


public class game5 extends Activity implements OnClickListener {

	static final int numImageButtons = 16;
	
	ImageButton[] imageButtons = new ImageButton[numImageButtons];
	ImageButton aButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.game5);
        
        imageButtons[0]  = (ImageButton) this.findViewById(R.id.imageButton00);
        imageButtons[1]  = (ImageButton) this.findViewById(R.id.imageButton01);
        imageButtons[2]  = (ImageButton) this.findViewById(R.id.imageButton02);
        imageButtons[3]  = (ImageButton) this.findViewById(R.id.imageButton03);
        imageButtons[4]  = (ImageButton) this.findViewById(R.id.imageButton04);
        imageButtons[5]  = (ImageButton) this.findViewById(R.id.imageButton05);
        imageButtons[6]  = (ImageButton) this.findViewById(R.id.imageButton06);
        imageButtons[7]  = (ImageButton) this.findViewById(R.id.imageButton07);
        imageButtons[8]  = (ImageButton) this.findViewById(R.id.imageButton08);
        imageButtons[9]  = (ImageButton) this.findViewById(R.id.imageButton09);
        imageButtons[10] = (ImageButton) this.findViewById(R.id.imageButton10);
        imageButtons[11] = (ImageButton) this.findViewById(R.id.imageButton11);
        imageButtons[12] = (ImageButton) this.findViewById(R.id.imageButton12);
        imageButtons[13] = (ImageButton) this.findViewById(R.id.imageButton13);
        imageButtons[14] = (ImageButton) this.findViewById(R.id.imageButton14);
        imageButtons[15] = (ImageButton) this.findViewById(R.id.imageButton15);
        
        for (int i = 0; i < numImageButtons; i++) {
        	imageButtons[i].setOnClickListener(this);
        	imageButtons[i].setImageResource(R.drawable.green);
        }
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
