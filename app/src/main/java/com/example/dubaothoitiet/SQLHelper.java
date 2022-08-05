package com.example.dubaothoitiet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dubaothoitiet.model.Contact;
import com.example.dubaothoitiet.model.ContactNhietDo;

import java.util.ArrayList;
import java.util.List;

public class SQLHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "Weather.db";
    static final String DB_TABLE_CONTACTNHIETDO = "ContactNhietDo";
    static final String DB_TABLE_CONTACT = "Contact";
    static final int DB_VERSION = 1;

    public SQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTable = "CREATE TABLE ContactNhietDo(" +
                "id INTEGER NOT NULL PRIMARY KEY," +
                "time TEXT," +
                "nhietdo INTEGER," +"" +
                "icon TEXT)";
        String queryCreateTable2 = "CREATE TABLE Contact(" +
                "id INTEGER NOT NULL PRIMARY KEY," +
                "city_name TEXT," +
                "nhietdo INTEGER," +
                "description TEXT," +
                "icon_hn TEXT," +
                "icon_nm TEXT," +
                "icon_nk TEXT," +
                "nhietdo_hn TEXT," +
                "nhietdo_nm TEXT," +
                "nhietdo_nk TEXT," +
                "gio TEXT," +
                "nhietdo_cn INTEGER," +
                "doam INTEGER," +
                "apsuat TEXT)";
        db.execSQL(queryCreateTable);

        db.execSQL(queryCreateTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_CONTACT);
            db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_CONTACTNHIETDO);
            onCreate(db);
        }
    }
    public void insertContactNhietdo(int id, String time, int nhietdo, String icon){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("time", time);
        contentValues.put("nhietdo", nhietdo);
        contentValues.put("icon", icon);
        sqLiteDatabase.insert(DB_TABLE_CONTACTNHIETDO, null, contentValues);

    }

    public void insertContact(int id, String cityName, int nhietDo, String icon_hn, String icon_nm, String icon_nk,
                              String nhietdo_hn, String nhietdo_nm, String nhietdo_nk, String gio, int nhietdo_cn, int doam, String apsuat){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("city_name", cityName);
        contentValues.put("nhietdo", nhietDo);
        contentValues.put("icon_hn", icon_hn);
        contentValues.put("icon_nm", icon_nm);
        contentValues.put("icon_nk", icon_nk);
        contentValues.put("nhietdo_hn", nhietdo_hn);
        contentValues.put("nhietdo_nm", nhietdo_nm);
        contentValues.put("nhietdo_nk", nhietdo_nk);
        contentValues.put("gio", gio);
        contentValues.put("nhietdo_cn", nhietdo_cn);
        contentValues.put("doam", doam);
        contentValues.put("nhietdo", nhietDo);
        contentValues.put("apsuat", apsuat);
        sqLiteDatabase.insert(DB_TABLE_CONTACT, null, contentValues);

    }


    public void updateContactNhietDo(ContactNhietDo contact){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", contact.getTime());
        contentValues.put("nhietdo", contact.getNhietdo());
        contentValues.put("icon", contact.getIcon());

        sqLiteDatabase.update(DB_TABLE_CONTACTNHIETDO, contentValues, "id = ?",
                new String[]{String.valueOf(contact.getId())});

    }

    public void updateContact(Contact contact){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("city_name", contact.getCityName());
        contentValues.put("nhietdo", contact.getNhietDo());
        contentValues.put("description", contact.getDescription());
        contentValues.put("icon_hn", contact.getIcon_hn());
        contentValues.put("icon_nm", contact.getIcon_nm());
        contentValues.put("icon_nk", contact.getIcon_nk());
        contentValues.put("nhietdo_hn", contact.getNhietdo_hn());
        contentValues.put("nhietdo_nm", contact.getNhietdo_nm());
        contentValues.put("nhietdo_nk", contact.getNhietdo_nk());
        contentValues.put("gio", contact.getGio());
        contentValues.put("nhietdo_cn", contact.getNhietdo_cn());
        contentValues.put("doam", contact.getDoam());
        contentValues.put("apsuat", contact.getApsuat());

        sqLiteDatabase.update(DB_TABLE_CONTACT, contentValues, "id = ?",
                new String[]{String.valueOf(contact.getId())});

    }



    public void deleteContactNhietDo(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_TABLE_CONTACTNHIETDO, "id = ?", new String[]{String.valueOf(id)});
    }

    public List<ContactNhietDo> getAllContactNhietDo(){
        List<ContactNhietDo> contactList = new ArrayList<>();

        ContactNhietDo contact;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE_CONTACTNHIETDO,
                null, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            int nhietdo = cursor.getInt(cursor.getColumnIndex("nhietdo"));
            String icon = cursor.getString(cursor.getColumnIndex("icon"));
            contact = new ContactNhietDo(id, time, nhietdo, icon);
            contactList.add(contact);
        }
        return contactList;
    }
    
    public Contact getContactSQL(){
        Contact contact = null;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        
        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE_CONTACT,
                null, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String cityName = cursor.getString(cursor.getColumnIndex("city_name"));
            int nhietdo = cursor.getInt(cursor.getColumnIndex("nhietdo"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            String icon_hn = cursor.getString(cursor.getColumnIndex("icon_hn"));
            String icon_nm = cursor.getString(cursor.getColumnIndex("icon_nm"));
            String icon_nk = cursor.getString(cursor.getColumnIndex("icon_nk"));
            String nhietdo_hn = cursor.getString(cursor.getColumnIndex("nhietdo_hn"));
            String nhietdo_nm = cursor.getString(cursor.getColumnIndex("nhietdo_nm"));
            String nhietdo_nk = cursor.getString(cursor.getColumnIndex("nhietdo_nk"));
            String gio = cursor.getString(cursor.getColumnIndex("gio"));
            int nhietdo_cn = cursor.getInt(cursor.getColumnIndex("nhietdo_cn"));
            int doam = cursor.getInt(cursor.getColumnIndex("doam"));
            String apsuat = cursor.getString(cursor.getColumnIndex("apsuat"));
            contact = new Contact(id, cityName, nhietdo, description, icon_hn, icon_nm, icon_nk, nhietdo_hn, nhietdo_nm, nhietdo_nk, gio, nhietdo_cn, doam, apsuat);
        }
        return contact;
    }


}
