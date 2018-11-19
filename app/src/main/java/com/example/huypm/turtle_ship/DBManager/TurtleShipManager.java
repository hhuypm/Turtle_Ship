package com.example.huypm.turtle_ship.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.huypm.turtle_ship.model.Customer_Employee;
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
        if (user.getId() != -1){
            values.put(ID, user.getId());
            values.put(CUS_EMP, user.getCus_Emp());
            values.put(PASS, user.getPass());
            db.insert(TABLE_USERS, null, values);
        }
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
                user.setCus_Emp(cursor.getInt(1));
                user.setPass(cursor.getString(2));
                listUser.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return listUser;
    }
    // Lay Max id User
    public int MaxIdUser(){
        int maxid = -1;
        String selectquery = "SELECT max(id) FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst())
            if (cursor.getString(0)!= "")
                maxid = Integer.parseInt(cursor.getString(0));
        return maxid;
    }
    //Bảng Cus_Emp
    private static final String TABLES_CusEmp = "Customer_Employee";
    private static final String ID_cus = "Id";
    private static final String Ten_cus= "Ten";
    private static final String SDT_cus= "SDT";
    private static final String Email_cus= "Email";
    private static final String NV= "Nhanvien";
    private String SQLQuery2 = "CREATE TABLE " + TABLES_CusEmp + " (" +
                    ID_cus + " integer primary key," +
                    Ten_cus + " String, " +
                    SDT_cus + " String, " +
                    Email_cus + " String, "+
                    NV + " BLOB )";

    // Thêm Emp_Cus
    public void addCus_Emp(Customer_Employee customer_employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (customer_employee.getId() != -1) {
            values.put(ID, customer_employee.getId());
            values.put(Ten_cus, customer_employee.getTen());
            values.put(SDT_cus, customer_employee.getSDT());
            values.put(Email_cus, customer_employee.getEmail());
            values.put(NV, customer_employee.getNV());
            db.insert(TABLES_CusEmp, null, values);
        }
        db.close();
    }

    // Lấy tất cả Cus_Emp
    public List<Customer_Employee> getAllCus_Emp() {
        List<Customer_Employee> listCus = new ArrayList<>();

        String selectquery = "SELECT * FROM " + TABLES_CusEmp;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst()) {
            do {
                Customer_Employee cus_emp = new Customer_Employee();
                cus_emp.setId(cursor.getInt(0));
                cus_emp.setTen(cursor.getString(1));
                cus_emp.setEmail(cursor.getString(2));
                cus_emp.setSDT(cursor.getString(3));
                cus_emp.setNV(cursor.getInt(4));
                listCus.add(cus_emp);
            } while (cursor.moveToNext());
        }
        db.close();
        return listCus;
    }
    // Lay max id Cus_Emp
    public int getMaxIdCus_Emp(){
        int maxID = -1;
        String selectQuery = "SELECT max(Id) FROM " +TABLES_CusEmp;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            if (cursor.getString(0) != "")
            maxID = Integer.parseInt(cursor.getString(0));
        }
        db.close();
        return maxID;
    }




    // Dang nhap
    public boolean Sign_in(String account, String pass){
        String selectQuery = "Select * from " + TABLES_CusEmp+", "+TABLE_USERS +" where ("+TABLES_CusEmp+".SDT=\""+account+"\" or "+TABLES_CusEmp+".Email = \""+account+"\") and " +
                TABLES_CusEmp+".Id ="+TABLE_USERS+".Cus_Emp and "+TABLE_USERS+".Pass = \""+pass+"\"" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            if (cursor.getString(0) != "") {
                db.close();
                return true;
            }
        }
        db.close();
        return false;
    }
    public TurtleShipManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        sqLiteDatabase.execSQL(SQLQuery2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

}
