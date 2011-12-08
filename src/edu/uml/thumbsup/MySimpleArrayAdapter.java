package edu.uml.thumbsup;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] names;

	public MySimpleArrayAdapter(Activity context, String[] names) {
		super(context, R.layout.rowlayout, names);
		this.context = context;
		this.names = names;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.rowlayout, null, true);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		textView.setText(names[position]);
		String s = names[position];
		if (s.startsWith("Science")){imageView.setImageResource(R.drawable.vials);}
		if (s.startsWith("Technology")){imageView.setImageResource(R.drawable.robot);}
		if (s.startsWith("History")){imageView.setImageResource(R.drawable.book);}
		if (s.startsWith("Music")){imageView.setImageResource(R.drawable.music);}
		if (s.startsWith("Movies")){imageView.setImageResource(R.drawable.movie);}
		if (s.startsWith("Sports")){imageView.setImageResource(R.drawable.ball);}
		if (s.startsWith("Politics")){imageView.setImageResource(R.drawable.question);}
		if (s.startsWith("Religion")){imageView.setImageResource(R.drawable.star);}
		

		return rowView;
	}
}
