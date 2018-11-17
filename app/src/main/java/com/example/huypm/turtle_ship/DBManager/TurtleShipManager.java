package com.example.huypm.turtle_ship.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.huypm.turtle_ship.model.Users;

import java.util.ArrayList;
import java.util.List;

public class TurtleShipManager extends SQLiteOpenHelper {
    // Tên cớ sở dữ liệu
    private static final String DATABASE_NAME = "TurleShip";

    //Bảng Users
    private static final String TABLE_USERS = "Users";
    private static final String ID = "Id";
    private static final String PASS = "Pass";
    private static final String CUS_EMP = "Cus_Emp";
    private String SQLQuery = "CREATE TABLE " + TABLE_USERS + " (" +
            ID + " integer primary key, " +
            CUS_EMP + " integer, " +
            PASS + " TEXT) ";

    // Thêm User
    public void addUser(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, user.getId());
        values.put(CUS_EMP, user.getCus_Emp());
        values.put(PASS, user.getPass());

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    // Lấy tất cả User
    public List<Users> getAlluser() {
        List<Users> listUser = new ArrayList<>();

        String selectquery = "SELECT * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst()) {
            do {
                Users user = new Users();
                user.setId(cursor.getInt(0));
                user.setCus_Emp(cursor.getInt(4));
                user.setPass(cursor.getString(3));
                listUser.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return listUser;


    }
    public TurtleShipManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

}
