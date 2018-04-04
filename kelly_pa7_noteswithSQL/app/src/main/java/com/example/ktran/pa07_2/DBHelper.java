package com.example.ktran.pa07_2;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "dbNotes";
    static final int DB_V = 1;

    static final String T_NOTES = "t_notes";
    static final String ID = "_id"; //adapters force us to do this

    static final String NAME = "n_name";
    static final String TYPE = "n_type";
    static final String CONT = "n_cont";

    static final String TAG = "contacts dbh";

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_V);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql_create =
                "CREATE TABLE " + T_NOTES + "(" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME + " TEXT, " +
                        TYPE + " TEXT, " +
                        CONT + " TEXT);";

        Log.d(TAG, "onCreate FROM DBHelper: " + sql_create);
        sqLiteDatabase.execSQL(sql_create);
    }

    public void insert(Note n){
        String insert = "INSERT INTO " + T_NOTES + " VALUES (" +
                "null,"  +
                "'"+  n.getTitle() + "'" + ", " +
                "'" +n.getType() + "'" +"," +
                "'" +n.getContent() + "'"+ ");";

        Log.d(TAG, "onInsert " + insert);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insert);

    }

    public void update(int id, Note n) {

        String sqlUpdate = "UPDATE " + T_NOTES +
                " SET " + NAME + " = '" + n.getTitle() +
                "', " + TYPE + " = '" + n.getType() +
                "', " + CONT + " = '" + n.getContent() +
                "' WHERE " + ID + " = " + id;
        Log.d(TAG, "updateContactById: " + sqlUpdate);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sqlUpdate);
        db.close();
    }

    public void delete(String name){

        String sql_delete = "DELETE FROM " + T_NOTES + " WHERE " + NAME + " = '" + name + "';";
        Log.d(TAG, "deleteId: " + sql_delete);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql_delete);
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getSelectAllContactsCursor(){
        String sqlSelectAll = "SELECT * FROM " + T_NOTES;
        Log.d(TAG, "getSelectAllContactsCursor: " + sqlSelectAll);
        // get reference to the database, read only
        SQLiteDatabase db = this.getReadableDatabase();
        // call rawQuery(), which returns a Cursor reference
        Cursor cursor = db.rawQuery(sqlSelectAll, null);

        // dont close the db, cursor needs it
        return cursor;
    }

    public void deleteAllNotes() {
        String sql_delete = "DELETE FROM " + T_NOTES + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql_delete);
        db.close();
    }



}
