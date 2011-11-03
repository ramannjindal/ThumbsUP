package edu.uml.thumbsup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gamemenu extends Activity{

	Button game1, game2, game3, game4, game5, game6, game7, game8;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemenu);
        game1 = (Button)findViewById(R.id.gmbutton1);
        game2 = (Button)findViewById(R.id.gmbutton2);
        game3 = (Button)findViewById(R.id.gmbutton3);
        game4 = (Button)findViewById(R.id.gmbutton4);
        game5 = (Button)findViewById(R.id.gmbutton5);
        game6 = (Button)findViewById(R.id.gmbutton6);
        game7 = (Button)findViewById(R.id.gmbutton7);
        game8 = (Button)findViewById(R.id.gmbutton8);
	
        game1.setOnClickListener(new View.OnClickListener() {
		
        	public void onClick(View v) {
				Intent openGame1 = new Intent("edu.uml.thumbsup.GAME1");
				startActivity(openGame1);			
        	}
        });
        
        game2.setOnClickListener(new View.OnClickListener() {
    		
        	public void onClick(View v) {
				Intent openGame2 = new Intent("edu.uml.thumbsup.GAME2");
				startActivity(openGame2);			
        	}
        });
        
        game3.setOnClickListener(new View.OnClickListener() {
    		
        	public void onClick(View v) {
				Intent openGame3 = new Intent("edu.uml.thumbsup.GAME3");
				startActivity(openGame3);			
        	}
        });
        
        game4.setOnClickListener(new View.OnClickListener() {
    		
        	public void onClick(View v) {
				Intent openGame4 = new Intent("edu.uml.thumbsup.GAME4");
				startActivity(openGame4);			
        	}
        });
        
        game5.setOnClickListener(new View.OnClickListener() {
    		
        	public void onClick(View v) {
				Intent openGame5 = new Intent("edu.uml.thumbsup.GAME5");
				startActivity(openGame5);			
        	}
        });
        
        game6.setOnClickListener(new View.OnClickListener() {
    		
        	public void onClick(View v) {
				Intent openGame6 = new Intent("edu.uml.thumbsup.GAME6");
				startActivity(openGame6);			
        	}
        });
        
        game7.setOnClickListener(new View.OnClickListener() {
    		
        	public void onClick(View v) {
				Intent openGame7 = new Intent("edu.uml.thumbsup.GAME7");
				startActivity(openGame7);			
        	}
        });
        
        game8.setOnClickListener(new View.OnClickListener() {
    		
        	public void onClick(View v) {
				Intent openGame8 = new Intent("edu.uml.thumbsup.GAME8");
				startActivity(openGame8);			
        	}
        });
	}
}
