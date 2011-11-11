package edu.uml.thumbsup;

//Prathibas Game
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class game6 extends Activity{
	private Button btnName1a,btnName2a, btnName3a;
	private Button btnName1b,btnName2b, btnName3b;
	private Button btnName1c,btnName2c, btnName3c;
	private Button btnName1d,btnName2d, btnName3d;	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game6);    
        
        btnName1a = (Button) this.findViewById(R.id.button1a);        
        btnName1a.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName1a.setText("APPLE");
        	}
        });
        
        btnName2a = (Button) this.findViewById(R.id.button2a);        
        btnName2a.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName2a.setText("PAPER");
        	}
        });
        
        btnName3a = (Button) this.findViewById(R.id.button3a);        
        btnName3a.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName3a.setText("PHONE");
        	}
        });

        btnName1b = (Button) this.findViewById(R.id.button1b);        
        btnName1b.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName1b.setText("REVOLVER");
        	}
        });
        
        btnName2b = (Button) this.findViewById(R.id.button2b);        
        btnName2b.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName2b.setText("FLUSH TOILET");
        	}
        });
        
        btnName3b = (Button) this.findViewById(R.id.button3b);        
        btnName3b.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName3b.setText("COMPUTER MOUSE");
        	}
        });

        btnName1c = (Button) this.findViewById(R.id.button1c);        
        btnName1c.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName1c.setText("STEAM ENGINE");
        	}
        });
        
        btnName2c = (Button) this.findViewById(R.id.button2c);        
        btnName2c.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName2c.setText("BATTERY");
        	}
        });
        
        btnName3c = (Button) this.findViewById(R.id.button3c);        
        btnName3c.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName3c.setText("IRON CASED ROCKETS");
        	}
        });

        btnName1d = (Button) this.findViewById(R.id.button1d);        
        btnName1d.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName1d.setText("HYDROGEN BOMB");
        	}
        });
        
        btnName2d = (Button) this.findViewById(R.id.button2d);        
        btnName2d.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName2d.setText("RADIO");
        	}
        });
        
        btnName3d= (Button) this.findViewById(R.id.button3d);        
        btnName3d.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		btnName3d.setText("PLASTIC SURGERY");
        	}
        });    
    }
}
