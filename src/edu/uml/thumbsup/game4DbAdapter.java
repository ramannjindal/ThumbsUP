package edu.uml.thumbsup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class game4DbAdapter {

	// Database fields
	public static final String KEY_ROWID = "_id";
	public static final String KEY_INVENTED = "invented";
	public static final String KEY_INVENTORS = "inventors";
	private static final String DB_TABLE = "inv";
	private Context context;
	private SQLiteDatabase db;
	private game4DatabaseHelper dbHelper;
	
	public game4DbAdapter(Context context) {
		this.context = context;
	}
	
	public game4DbAdapter open() throws SQLException {
		dbHelper = new game4DatabaseHelper(context);
		db = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close() {
		dbHelper.close();
	}
	
	/** * Create a new inv.If the inv is successfully created return the new * rowId for that note, otherwise return a -1 to indicate failure. */

	public long createTodo(String invented, String inventors) {
		ContentValues values = createContentValues(invented, inventors);
		return db.insert(DB_TABLE, null, values);
	}

	
	
	/** * Update the todo */

		public boolean updateTodo(long rowId, String invented, String inventors) {
			ContentValues values = createContentValues(invented, inventors);
			return db.update(DB_TABLE, values, KEY_ROWID + "=" + rowId, null) > 0;
		}

		
	/** * Deletes todo */

		public boolean deleteTodo(long rowId) {
			return db.delete(DB_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
		}

		
	/** * Return a Cursor over the list of all todo in the database * * @return Cursor over all notes */

		public Cursor fetchAllTodos() {
			return db.query(DB_TABLE, new String[] { KEY_ROWID, KEY_INVENTED,KEY_INVENTORS }, null, null, null, null, null);
		}

		
	/** * Return a Cursor positioned at the defined todo */

		public Cursor fetchTodo(long rowId) throws SQLException {
			Cursor mCursor = db.query(true, DB_TABLE, new String[] { KEY_ROWID,
					KEY_INVENTED, KEY_INVENTORS }, KEY_ROWID + "="
					+ rowId, null, null, null, null, null);
			if (mCursor != null) {
				mCursor.moveToFirst();
			}
			return mCursor;
		}
	
	
	private ContentValues createContentValues(String invented, String inventors) {
		ContentValues values = new ContentValues();
		values.put(KEY_INVENTED, invented);
		values.put(KEY_INVENTORS, inventors);
		return values;
	}


	
	
}
