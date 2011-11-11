package edu.uml.thumbsup;

//Prathibas Game
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class game6 extends Activity {
	
	public static final String LOG_TAG = "Droido";
	ImageView iv;
	TextView  tv1;
	Button startGame;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game6);
        iv = (ImageView) findViewById(R.id.image);
    	tv1 = (TextView)findViewById(R.id.textView1);
    	startGame= (Button)findViewById(R.id.startgame);
    	//Log.v(LOG_TAG,"working");
    	
    	final String[] inventors = getResources().getStringArray(R.array.inventors);
    	final String[] inventions = getResources().getStringArray(R.array.inventions);
    	
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.telephone);
            	tv1.setText(inventors[0]+ "  invented  " + inventions[0]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });
        
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.steam_engine);
            	tv1.setText(inventors[1]+ "  invented  " + inventions[1]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.mouse);
            	tv1.setText(inventors[2]+ "  invented  " + inventions[2]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.hydrogenbomb);
            	tv1.setText(inventors[3]+ "  invented  " + inventions[3]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.battery);
            	tv1.setText(inventors[4]+ "  invented  " + inventions[4]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.radio);
            	tv1.setText(inventors[5]+ "  invented  " + inventions[5]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.revolver);
            	tv1.setText(inventors[6]+ "  invented  " + inventions[6]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.motorcycle);
            	tv1.setText(inventors[7]+ "  invented  " + inventions[7]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.ironbox);
            	tv1.setText(inventors[8]+ "  invented  " + inventions[8]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.surgeon);
            	tv1.setText(inventors[9]+ "  invented  " + inventions[9]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.typewriter);
            	tv1.setText(inventors[10]+ "  invented  " + inventions[10]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.telegraph);
            	tv1.setText(inventors[11]+ "  invented  " + inventions[11]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.sewingmachine);
            	tv1.setText(inventors[12]+ "  invented  " + inventions[12]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button14);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.mircowave);
            	tv1.setText(inventors[13]+ "  invented  " + inventions[13]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button15);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.flushtoilet);
            	tv1.setText(inventors[14]+ "  invented  " + inventions[14]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });

        button = (Button) findViewById(R.id.button16);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
            	//Log.v(LOG_TAG,inventors[1]);
            	iv.setBackgroundResource(R.drawable.fountainpen);
            	tv1.setText(inventors[15]+ "  invented  " + inventions[15]);
            	startGame.setVisibility(View.VISIBLE);
            }
        });
        
        startGame.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v){
        		Intent myIntent = new Intent(game6.this, playGame.class);
        		game6.this.startActivity(myIntent);
        	}		
		});

            }
}