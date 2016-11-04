package team.innovators.k.a.t.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter {
	
	static final String DATABASE_NAME = "user.db";
	static final int DATABASE_VERSION = 1;
	public static final int NAME_COLUMN = 1;
	// TODO: Create public field for each column in your table.
	// SQL Statement to create a new database.
	static final String DATABASE_CREATE = "create table "+"userProfile"+
	                             "( " +"ID"+" integer primary key autoincrement,"+ "EMAIL  text,USERNAME text,PASSWORD text,PHONE text); ";
	// Variable to hold the database instance
	public  SQLiteDatabase userdb;
	// Context of the application using the database.
	private final Context context;
	// Database open/upgrade helper
	private DataBaseHelper dbHelper;
	public  LoginDataBaseAdapter(Context _context) 
	{
		context = _context;
		dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public  LoginDataBaseAdapter open() throws SQLException 
	{
		userdb = dbHelper.getWritableDatabase();
		return this;
	}
	public void close() 
	{
		userdb.close();
	}

	public  SQLiteDatabase getDatabaseInstance()
	{
		return userdb;
	}

	public void insertEntry(String userName,String password,String eMail,String phone)
	{
       ContentValues newValues = new ContentValues();
		// Assign values for each row.
		newValues.put("USERNAME", userName);
		newValues.put("PASSWORD",password);
		newValues.put("EMAIL", eMail);
		newValues.put("PHONE", phone);

		// Insert the row into your table
		userdb.insert("userProfile", null, newValues);
		//Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
	}
	public int deleteEntry(String UserName)
	{
		//String id=String.valueOf(ID);
	    String where="USERNAME=?";
	    int numberOFEntriesDeleted= userdb.delete("userProfile", where, new String[]{UserName}) ;
       // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
	}	
	public String getSinlgeEntry(String userName)
	{
		Cursor cursor=userdb.query("userProfile", null, " PASSWORD=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
		String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
		String email=cursor.getString(cursor.getColumnIndex("EMAIL"));
		String phone=cursor.getString(cursor.getColumnIndex("PHONE"));
		cursor.close();
		return password;				
	}
	public void  updateEntry(String userName,String password,String eMail,String phone)
	{
		// Define the updated row content.
		ContentValues updatedValues = new ContentValues();
		// Assign values for each row.
		updatedValues.put("USERNAME", userName);
		updatedValues.put("PASSWORD",password);
		updatedValues.put("EMAIL", eMail);
		updatedValues.put("PHONE", phone);

        String where="USERNAME = ?";
	    userdb.update("userProfile",updatedValues, where, new String[]{userName});			   
	}

}
