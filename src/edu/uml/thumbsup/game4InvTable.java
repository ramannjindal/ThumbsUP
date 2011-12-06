package edu.uml.thumbsup;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class game4InvTable {
	
	private static final String DATABASE_CREATE = "create table inv"
		+ "(_id integer primary key autoincrement, "
		+ "invented text not null, " + "inventors text not null);";
	
	public static void onCreate(SQLiteDatabase database){
		database.execSQL(DATABASE_CREATE);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
		Log.w(game4InvTable.class.getName(), "Upgrading databse from version"
										+ oldVersion +  "to" +newVersion
										+ ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS inv");
		onCreate(database);
	}
}
