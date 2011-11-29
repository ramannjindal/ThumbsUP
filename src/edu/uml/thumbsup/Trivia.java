package edu.uml.thumbsup;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Trivia extends Activity {
	final MyCount counter = new MyCount(12000, 1000);// this means that we count
	// from 12.000 to 0 with
	// 1000ms per
	// second...so it will
	// be
	// displayed...12...11...10...etc

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.trivia);
MyCount counter = new MyCount(20000, 1000);// instantiate counter
counter.start();// counter start as soon as app is opened...you can put
// this in a OnClickListener also.
}

public class MyCount extends CountDownTimer {

public MyCount(long millisInFuture, long countDownInterval) {
super(millisInFuture, countDownInterval);
}

@Override
public void onFinish() {
TextView scor = (TextView) findViewById(R.id.TextView01);
scor.setText("0");// this is the message displayed at the finish of
// the counting...can be Game Over ..etc..
}

@Override
public void onTick(long millisUntilFinished) {
TextView scor = (TextView) findViewById(R.id.TextView01);
scor.setText(String.valueOf(millisUntilFinished / 1000));
// here we update the text with seconds until 0.
}

}

}
