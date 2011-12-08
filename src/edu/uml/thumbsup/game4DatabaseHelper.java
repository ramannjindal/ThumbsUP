package edu.uml.thumbsup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class game4DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "game4data";
	private static final int DATABASE_VERSION = 1;

	public game4DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		game4InvTable.onCreate(database);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		game4InvTable.onUpgrade(database, oldVersion, newVersion);
		
	}

}
