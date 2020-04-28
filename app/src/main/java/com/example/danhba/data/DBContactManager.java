package com.example.danhba.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

import com.example.danhba.model.Contact;


public class DBContactManager extends SQLiteOpenHelper {
    //Contact version
    private static int VERSION = 1;
    //Contact Database name
    private static final String DATABASE_NAME ="contact_manager";
    //Contact Table name
    private static final String TABLE_NAME ="contact";
    //Contacts Table Columns names
    private static final String ID ="id";
    private static final String NAME ="name";
    private static final String PHONE ="number_phone";
    private static final String AVATAR ="avatar";


    private String ContactQuery = "CREATE TABLE "+TABLE_NAME+" ("+
            ID+" interger primary key, "+
            NAME+" TEXT, "+
            PHONE+" TEXT, "+
            AVATAR+" BLOB"+")";

    public DBContactManager(Context context) {
        super(context, DATABASE_NAME, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(Contact contact){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(NAME,contact.getmName());
        contentValues.put(PHONE,contact.getmNumberPhone());
        contentValues.put(AVATAR,contact.isMale());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    };
}
