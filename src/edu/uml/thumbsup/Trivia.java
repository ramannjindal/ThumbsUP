package edu.uml.thumbsup;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;


	
	public class Trivia extends Activity {
		static int qindex = 0;
		static int aindex = 0;
		static int qcount = 1;
		static int score = 0;
		static int ms;
		private String[] myString;
		RadioButton rb0,rb1,rb2,rb3;
		
		
		MyCount counter = new MyCount(60000, 1000);

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.trivia);
			counter.start();
			TextView view = (TextView) findViewById(R.id.question);
			Resources res = getResources();
			if(((Globals) this.getApplication()).getMS() == 0){
				ms = 1;
				myString = res.getStringArray(R.array.trivArray1);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray1);
			}
			if(((Globals) this.getApplication()).getMS() == 1){
				ms = 2;
				myString = res.getStringArray(R.array.trivArray2);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray2);
			}
			if(((Globals) this.getApplication()).getMS() == 2){
				ms = 3;
				myString = res.getStringArray(R.array.trivArray3);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray3);
			}
			if(((Globals) this.getApplication()).getMS() == 3){
				ms = 4;
				myString = res.getStringArray(R.array.trivArray4);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray4);
			}
			
			if(((Globals) this.getApplication()).getMS() == 4){
				ms = 5;
				myString = res.getStringArray(R.array.trivArray5);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray5);
			}
			if(((Globals) this.getApplication()).getMS() == 5){
				ms = 6;
				myString = res.getStringArray(R.array.trivArray6);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray6);
			}
			if(((Globals) this.getApplication()).getMS() == 6){
				ms = 7;
				myString = res.getStringArray(R.array.trivArray7);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray7);
			}
			if(((Globals) this.getApplication()).getMS() == 7){
				ms = 8;
				myString = res.getStringArray(R.array.trivArray8);
				String q = myString[0];
				view.setText(q);
				myString = res.getStringArray(R.array.answerArray8);
			}
			
			
			rb0 = (RadioButton) findViewById(R.id.radio0);
			rb1 = (RadioButton) findViewById(R.id.radio1);
			rb2 = (RadioButton) findViewById(R.id.radio2);
			rb3 = (RadioButton) findViewById(R.id.radio3);			
			rb0.setOnClickListener(OCL);
			rb1.setOnClickListener(OCL);
			rb2.setOnClickListener(OCL);
			rb3.setOnClickListener(OCL);
			
			for(int i =0 ; i < 4 ; i++){
				String a = myString[i];
				
				if( i == 0){rb0.setText(a);}
				if( i == 1){rb1.setText(a);}
				if( i == 2){rb2.setText(a);}
				if( i == 3){rb3.setText(a);}
			}
			
			
			
		}
		
		RadioButton.OnClickListener OCL =
				   new RadioButton.OnClickListener()
				  {

				  @Override
				  public void onClick(View v) {
				   Resources res = getResources();
				   String[] a = null;
				   String[] q = null;
				   if(ms == 1){
					   a = res.getStringArray(R.array.answerArray1);
					   q = res.getStringArray(R.array.trivArray1);
				   }
					   
				   if(ms == 2){
					   a = res.getStringArray(R.array.answerArray2);
					   q = res.getStringArray(R.array.trivArray2);
				   }
				   if(ms == 3){
					   a = res.getStringArray(R.array.answerArray3);
					   q = res.getStringArray(R.array.trivArray3);
				   }
				   if(ms == 4){
					   a = res.getStringArray(R.array.answerArray4);
					   q = res.getStringArray(R.array.trivArray4);
				   }
				   if(ms == 5){
					   a = res.getStringArray(R.array.answerArray5);
					   q = res.getStringArray(R.array.trivArray5);
				   }
				   if(ms == 6){
					   a = res.getStringArray(R.array.answerArray6);
					   q = res.getStringArray(R.array.trivArray6);
				   }
				   if(ms == 7){
					   a = res.getStringArray(R.array.answerArray7);
					   q = res.getStringArray(R.array.trivArray7);
				   }
				   if(ms == 8){
					   a = res.getStringArray(R.array.answerArray8);
					   q = res.getStringArray(R.array.trivArray8);
				   }
				   
				   		// check if the button selected is the same value stored in answerArray
					   if(rb0.isChecked()){ 
						   if(Integer.parseInt(a[aindex+4]) == 1){ // if the answer in the array is equal to 1 the index of the button pressed
							   
							   qcount++; //increment to keep track of how many questions have been asked
							   qindex++; // select the next question
							   aindex+=5;//select the next answer
							   if(qcount <= 10) nextQ(a,q,aindex,qindex);
							   else {
								   counter.cancel();
								   qindex = 0;aindex = 0;qcount = 1;
								   wincond();
							   }
						   }
						   
						   else Toast.makeText(Trivia.this, "Incorrect",Toast.LENGTH_SHORT).show();	
					   }
					   if(rb1.isChecked()){ 
						   if(Integer.parseInt(a[aindex+4]) == 2){
							   
							   qcount++;
							   qindex++;
							   aindex+=5;
							   if(qcount <= 10) nextQ(a,q,aindex,qindex);
							   else {
								   counter.cancel();
								   qindex = 0;aindex = 0;qcount = 1;
								   wincond();
							   }
						   }
						   else Toast.makeText(Trivia.this, "Incorrect",Toast.LENGTH_SHORT).show();	
				  }
					   if(rb2.isChecked()){ 
						   if(Integer.parseInt(a[aindex+4]) == 3){
							   
							   qcount++;
							   qindex++;
							   aindex+=5;
							   if(qcount <= 10) nextQ(a,q,aindex,qindex);
							   else {
								   counter.cancel();
								   qindex = 0;aindex = 0;qcount = 1;
								   wincond();
							   }
							 }
						   else Toast.makeText(Trivia.this, "Incorrect",Toast.LENGTH_SHORT).show();	
				  }
					   if(rb3.isChecked()){ 
						   if(Integer.parseInt(a[aindex+4]) == 4){
							   
							   qcount++;
							   qindex++;
							   aindex+=5;
							   if(qcount <= 10) nextQ(a,q,aindex,qindex);
							   else {
								   counter.cancel();
								   qindex = 0;aindex = 0;qcount = 1;
								   wincond();
							   }
							   
							  }
						   else Toast.makeText(Trivia.this, "Incorrect",Toast.LENGTH_SHORT).show();	
				  }
			
			}   				   
		 };
		 
		 @Override
		 public void onBackPressed() {
			 counter.cancel();
			 finish();
		     return;
		 }

		 
		 
		 void nextQ( String[] astr , String[] qstr, int aindex, int qindex){
			 TextView view = (TextView) findViewById(R.id.question);
				String q = qstr[qindex];
				view.setText(q);
				
				rb0 = (RadioButton) findViewById(R.id.radio0);
				rb1 = (RadioButton) findViewById(R.id.radio1);
				rb2 = (RadioButton) findViewById(R.id.radio2);
				rb3 = (RadioButton) findViewById(R.id.radio3);			
				rb0.setOnClickListener(OCL);
				rb1.setOnClickListener(OCL);
				rb2.setOnClickListener(OCL);
				rb3.setOnClickListener(OCL);
				
				for(int i=0 ;  i < 4 ; i++){
					String a = astr[aindex+i];
					
					if( i == 0){rb0.setText(a);}
					if( i == 1){rb1.setText(a);}
					if( i == 2){rb2.setText(a);}
					if( i == 3){rb3.setText(a);}
				}
			 
		 }
		 
		 void wincond(){
			 
			 AlertDialog.Builder builder = new AlertDialog.Builder(Trivia.this);
				builder.setMessage("You have answered all the questions!\nYOU WIN!!")
				       .setCancelable(false)
				       .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
				           public void onClick(DialogInterface dialog, int id) {
				                Trivia.this.finish();
				           }
				       });      
				AlertDialog alert = builder.create();
				alert.show();
		 }

		public class MyCount extends CountDownTimer {

			public MyCount(long millisInFuture, long countDownInterval) {
				super(millisInFuture, countDownInterval);
			}

			@Override
			public void onFinish() {
				qindex = 0;
				aindex = 0;
				qcount = 1;
				TextView scor = (TextView) findViewById(R.id.TextView01);
				scor.setText("0");// this is the message displayed at the finish of
									// the counting...can be Game Over ..etc..
				AlertDialog.Builder builder = new AlertDialog.Builder(Trivia.this);
				builder.setMessage("Time has run out\nGame Over")
				       .setCancelable(false)
				       .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
				           public void onClick(DialogInterface dialog, int id) {
				                Trivia.this.finish();
				           }
				       });
				       
				AlertDialog alert = builder.create();
				alert.show();
			}

			@Override
			public void onTick(long millisUntilFinished) {
				TextView scor = (TextView) findViewById(R.id.TextView01);
				scor.setText(String.valueOf(millisUntilFinished / 1000));
				// here we update the text with seconds until 0.
			}

		}
		
	}

	
