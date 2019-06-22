package com.example.mostafa.task_orientedstrategies.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mostafa.task_orientedstrategies.*;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "User.db";
    public static String message;

    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                String.format(
                        "CREATE TABLE IF NOT EXISTS %s(%s integer primary key , %s varchar(15) not null default 'first_name' , %s varchar(15) not null default 'last_name'" +
                                     ", %s varchar(25) not null unique default 'example@domain.com', %s varchar(8) not null unique default '******');"
                        , UserDatabase.Table.userTable , UserDatabase.Table.Column.userId , UserDatabase.Table.Column.firstName
                        , UserDatabase.Table.Column.lastName, UserDatabase.Table.Column.email, UserDatabase.Table.Column.password));


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(User r){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put(UserDatabase.Table.Column.userId , r.getUser_id());
        data.put(UserDatabase.Table.Column.firstName , r.getFirstName());
        data.put(UserDatabase.Table.Column.lastName , r.getLastName());
        data.put(UserDatabase.Table.Column.email , r.getEmail());
        data.put(UserDatabase.Table.Column.password , r.getPassword());

        long isInserted = db.insert(UserDatabase.Table.userTable , null , data);
        if(isInserted != -1) {
            message = "Account Created";
            return true;
        }

        return false;
    }

    public Cursor login(String email , String password){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery(String.format("SELECT %s , %s FROM %s WHERE %s = '%s' AND (%s = '%s');"
                , UserDatabase.Table.Column.email , UserDatabase.Table.Column.password,
                 UserDatabase.Table.userTable , UserDatabase.Table.Column.password , password ,UserDatabase.Table.Column.email ,
                email) , null);
        if(data == null)
            message = "YOU ARE NOT REGISTERED OR YOUR DATA ISN'T CORRECT";
        else
            message = "LOGIN SUCCESSFULLY";
        return data;
    }
}
