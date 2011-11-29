package edu.uml.thumbsup;

import android.app.ListActivity;
import java.util.Random;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import edu.uml.thumbsup.MySimpleArrayAdapter;
import edu.uml.thumbsup.R;
import android.content.res.Resources;

public class Facts extends ListActivity {

	private String[] myString;
	private static final Random rgenerator = new Random();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] topics = getResources().getStringArray(R.array.topics_array);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, topics));
		MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, topics);
		setListAdapter(adapter);
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Dialog dialog = new Dialog(Facts.this);
		Resources res = getResources();


		if(position == 0){myString = res.getStringArray(R.array.factArray1); }
		if(position == 1){myString = res.getStringArray(R.array.factArray2); }
		if(position == 2){myString = res.getStringArray(R.array.factArray3); }
		if(position == 3){myString = res.getStringArray(R.array.factArray4); }
		if(position == 4){myString = res.getStringArray(R.array.factArray5); }
		if(position == 5){myString = res.getStringArray(R.array.factArray6); }
		if(position == 6){myString = res.getStringArray(R.array.factArray7); }
		if(position == 7){myString = res.getStringArray(R.array.factArray8); }
		if(position == 8){myString = res.getStringArray(R.array.factArray9); }
		String q = myString[rgenerator.nextInt(myString.length)];

		dialog.setContentView(R.layout.custom_dialog);
		dialog.setTitle("Did you know: ");
		dialog.setCancelable(true);
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText(q);
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.exclaim);

		dialog.show();
	}

}