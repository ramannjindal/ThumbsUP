package edu.uml.thumbsup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class game5 extends Activity{

	public ImageView g5imageView0, g5imageView1, g5imageView2, g5imageView3, g5imageView4, g5imageView5 ;
	public ImageView g5imageView6, g5imageView7, g5imageView8, g5imageView9, g5imageView10, g5imageView11 ;
	public ImageView g5imageView12, g5imageView13, g5imageView14, g5imageView15 ;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.game5);
        
        g5imageView0 = (ImageView) this.findViewById(R.id.g5imageView1);
        g5imageView1 = (ImageView) this.findViewById(R.id.g5ImageView01);
        g5imageView2 = (ImageView) this.findViewById(R.id.g5ImageView02);
        g5imageView3 = (ImageView) this.findViewById(R.id.g5ImageView03);
        g5imageView4 = (ImageView) this.findViewById(R.id.g5imageView04);
        g5imageView5 = (ImageView) this.findViewById(R.id.g5ImageView05);
        g5imageView6 = (ImageView) this.findViewById(R.id.g5ImageView06);
        g5imageView7 = (ImageView) this.findViewById(R.id.g5ImageView07);
        g5imageView8 = (ImageView) this.findViewById(R.id.g5imageView08);
        g5imageView9 = (ImageView) this.findViewById(R.id.g5ImageView09);
        g5imageView10 = (ImageView) this.findViewById(R.id.g5ImageView10);
        g5imageView11 = (ImageView) this.findViewById(R.id.g5ImageView11);
        g5imageView12 = (ImageView) this.findViewById(R.id.g5imageView12);
        g5imageView13 = (ImageView) this.findViewById(R.id.g5ImageView13);
        g5imageView14 = (ImageView) this.findViewById(R.id.g5ImageView14);
        g5imageView15 = (ImageView) this.findViewById(R.id.g5ImageView15);
        
        Thread timer = new Thread(){
			public void run(){
				try{
					sleep(90000); //1.5 minutes
				} catch (InterruptedException e){
					e.printStackTrace();
				} finally {
					//print score and finish
				}
			}			
		};
		timer.start();
	
	g5imageView0.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView1.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});	
	
	g5imageView2.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView3.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView4.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView5.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView6.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView7.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView8.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView9.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView10.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView11.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView12.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView13.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView14.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	g5imageView15.setOnClickListener(new OnClickListener(){
		public void onClick(View v)
		{
		
		}
	});
	
	}
}
