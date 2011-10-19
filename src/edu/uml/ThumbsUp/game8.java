package edu.uml.thumbsup;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class game8 extends Activity{
	private boolean lightPressed   = false;
	private boolean batteryPressed = false;
	
	private ImageView light;
	private ImageView battery;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.game8);
        
        light = (ImageView) this.findViewById(R.id.imageView1);
        light.setOnClickListener(
        		new OnClickListener()
        		{
        			public void onClick(View v)
        			{
        				lightPressed = true;
        				DoIWin();
        			}
        		});
        
        battery = (ImageView) this.findViewById(R.id.imageView2);
        battery.setOnClickListener(
        		new OnClickListener()
        		{
        			public void onClick(View v)
        			{
        				batteryPressed = true;
        				DoIWin();
        			}
        		});
	}
	
	public void DoIWin()
	{
		if(lightPressed && batteryPressed)
		{
			light.setColorFilter(Color.YELLOW);
		}
	}
	
}