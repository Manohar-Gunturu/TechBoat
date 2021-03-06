package com.exercise.AndroidSQLite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidSQLite extends Activity {
	
	private SQLiteAdapter mySQLiteAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView listContent = (TextView)findViewById(R.id.contentlist);
        
        /*
         * 	Create/Open a SQLite database
         *  and fill with dummy content
         *  and close it
         */
        mySQLiteAdapter = new SQLiteAdapter(this);
        mySQLiteAdapter.openToWrite();
        mySQLiteAdapter.deleteAll();
        mySQLiteAdapter.insert("ABCDE");
        mySQLiteAdapter.insert("FGHIJK");
        mySQLiteAdapter.insert("1234567");
        mySQLiteAdapter.insert("890");
        mySQLiteAdapter.insert("Testing");
        mySQLiteAdapter.close();

        /*
         * 	Open the same SQLite database
         * 	and read all it's content.
         */
        mySQLiteAdapter = new SQLiteAdapter(this);
        mySQLiteAdapter.openToRead();
        String contentRead = mySQLiteAdapter.queueAll();
        mySQLiteAdapter.close();
        
        listContent.setText(contentRead);
        
    }
}