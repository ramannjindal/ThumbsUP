package edu.uml.thumbsup;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

public class Game2menu extends ListActivity{
	
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
		
		if(position == 0){
			((Globals) this.getApplication()).setMS(0);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 1){
			((Globals) this.getApplication()).setMS(1);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 2){
			((Globals) this.getApplication()).setMS(2);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 3){
			((Globals) this.getApplication()).setMS(3);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 4){
			((Globals) this.getApplication()).setMS(4);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 5){
			((Globals) this.getApplication()).setMS(5);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 6){
			((Globals) this.getApplication()).setMS(6);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 7){
			((Globals) this.getApplication()).setMS(7);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}
		if(position == 8){
			((Globals) this.getApplication()).setMS(8);
			Intent myIntent = new Intent(v.getContext(), Trivia.class);
            startActivityForResult(myIntent, 0);
		}

	   
		
	}
	
}
	

