package edu.uml.thumbsup;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class game1help extends Activity{
	
	TextView displayHelp;
	TextView displayDividing;
	TextView displayAdding;
	TextView displayReducing;
	TextView displaymultiplying;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1help);
        
        displayHelp = (TextView)findViewById(R.id.tvDescription);
        displayDividing = (TextView)findViewById(R.id.tvDividing);
        displayAdding = (TextView)findViewById(R.id.tvAdding);
        displayReducing = (TextView)findViewById(R.id.tvReducing);
        displaymultiplying = (TextView)findViewById(R.id.tvDescription);
       

}    
}
