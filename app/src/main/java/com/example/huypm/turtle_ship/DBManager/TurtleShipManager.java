package com.example.huypm.turtle_ship.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.huypm.turtle_ship.model.ChiTietDonHang;
import com.example.huypm.turtle_ship.model.Customer_Employee;
import com.example.huypm.turtle_ship.model.DiaChi;
import com.example.huypm.turtle_ship.model.DonHang;
import com.example.huypm.turtle_ship.model.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
                    NV + " TEXT )";

    // Thêm Emp_Cus
    public void addCus_Emp(Customer_Employee customer_employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, customer_employee.getId());
        values.put(Ten_cus, customer_employee.getTen());
        values.put(SDT_cus, customer_employee.getSDT());
        values.put(Email_cus, customer_employee.getEmail());
        values.put(NV, customer_employee.getNV());
        db.insert(TABLES_CusEmp, null, values);
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
                cus_emp.setTen(cursor.getString(4));
                cus_emp.setEmail(cursor.getString(3));
                cus_emp.setSDT(cursor.getString(3));
                cus_emp.setNV(cursor.getString(2));
                listCus.add(cus_emp);
            } while (cursor.moveToNext());
        }
        db.close();
        return listCus;


    }

    //Bảng DiaChi
    private static final String TABLES_DiaChi = "DiaChi";
    private static final String ID_diachi = "Id";
    private static final String Cus_emp= "Cus_emp";
    private static final String TP= "ThanhPho";
    private static final String Quan= "Quan";
    private static final String Phuong= "Phuong";
    private static final String Duong= "Duong";
    private static final String GiaoNhan= "GianNhan";
    private String SQLQuery3 = "CREATE TABLE " + TABLES_DiaChi + " (" +
            ID_diachi + " integer primary key," +
            Cus_emp + " String, " +
            TP + " String, " +
            Quan + " String, "+
            Phuong + " String, "+
            Duong + " String, "+
            GiaoNhan + " TEXT )";

    // Thêm DiaChi
    public void addDiaChi (DiaChi diaChi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, diaChi.getId());
        values.put(Cus_emp, diaChi.getCus_Emp());
        values.put(TP, diaChi.getTp());
        values.put(Quan, diaChi.getQuan());
        values.put(Phuong, diaChi.getPhuong());
        values.put(Duong, diaChi.getDuong());
        values.put(GiaoNhan, diaChi.getGiaoNhan());
        db.insert(TABLES_DiaChi, null, values);
        db.close();
    }

    // Lấy tất cả DiaChi
    public List<DiaChi> getAllDiaChi() {
        List<DiaChi> listDiaChi = new ArrayList<>();

        String selectquery = "SELECT * FROM " + TABLES_DiaChi;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst()) {
            do {
                DiaChi diaChi = new DiaChi();
                diaChi.setId(cursor.getInt(0));
                diaChi.setCus_Emp(cursor.getInt(4));
                diaChi.setTp(cursor.getString(3));
                diaChi.setQuan(cursor.getString(3));
                diaChi.setPhuong(cursor.getString(2));
                diaChi.setDuong(cursor.getString(2));
                diaChi.setGiaoNhan(cursor.getInt(2));
                listDiaChi.add(diaChi);
            } while (cursor.moveToNext());
        }
        db.close();
        return listDiaChi;


    }
    //Bảng DonHang
    private static final String TABLES_DonHang = "DonHang";
    private static final String ID_donhang = "Id";
    private static final String KhachHang= "KhachHang";
    private static final String NgayDat= "NgayDat";
    private static final String NgayGiao= "NgayGiao";
    private static final String NgayNhan= "NgayNhan";
    private static final String DCNhanHang= "DCNhanHang";
    private static final String DCGiaoHang= "DCGiaoHang";
    private static final String HTGiaoHang= "HTGiaoHang";
    private static final String CaySo= "CaySo";
    private static final String ThanhTien= "ThanhTien";
    private String SQLQuery4 = "CREATE TABLE " + TABLES_DonHang + " (" +
            ID_donhang + " integer primary key," +
            KhachHang + " String, " +
            NgayDat + " String, " +
            NgayGiao + " String, "+
            NgayNhan + " String, "+
            DCNhanHang + " String, "+
            DCGiaoHang + " String, "+
            HTGiaoHang + " String, "+
            CaySo + " String, "+
            ThanhTien + " TEXT )";

    // Thêm DiaChi
    public void addDonHang (DonHang donHang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, donHang.getId());
        values.put(KhachHang, donHang.getKh());
        values.put(NgayDat, donHang.getNgayDat());
        values.put(NgayGiao, donHang.getNgayGiao());
        values.put(NgayNhan, donHang.getNgayNhan());
        values.put(DCGiaoHang, donHang.getDCgiaohang());
        values.put(DCNhanHang, donHang.getDCnhanhang());
        values.put(HTGiaoHang, donHang.getHTgiaohang());
        values.put(CaySo, donHang.getCayso());
        values.put(ThanhTien, donHang.getThanhTien());
        db.insert(TABLES_DonHang, null, values);
        db.close();
    }

    // Lấy tất cả DonHang
    public List<DonHang> getAllDonHang() {
        List<DonHang> listDonHang = new ArrayList<>();

        String selectquery = "SELECT * FROM " + TABLES_DonHang;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst()) {
            do {
                DonHang donHang = new DonHang();
                donHang.setId(cursor.getInt(0));
                donHang.setKh(cursor.getInt(4));
                donHang.setNgayDat(cursor.getString(3));
                donHang.setNgayGiao(cursor.getString(3));
                donHang.setNgayNhan(cursor.getString(2));
                donHang.setDCnhanhang(cursor.getInt(2));
                donHang.setDCgiaohang(cursor.getInt(2));
                donHang.setHTgiaohang(cursor.getInt(2));
                donHang.setCayso(cursor.getInt(2));
                donHang.setThanhTien(cursor.getInt(2));
                listDonHang.add(donHang);
            } while (cursor.moveToNext());
        }
        db.close();
        return listDonHang;


    }

    //Bảng ChiTietDonHang
    private static final String TABLES_CTDH = "CTDH";
    private static final String ID_CTDH = "CTDH";
    private static final String HinhAnh= "HinhAnh";
    private static final String Mota= "Mota";
    private static final String DinhGia= "DinhGia";
    private static final String KhoiLuong= "KhoiLuong";
    private static final String SoLuong= "SoLuong";
    private String SQLQuery5 = "CREATE TABLE " + TABLES_CTDH + " (" +
            ID_CTDH + " integer primary key," +
            HinhAnh + " String, " +
            Mota + " String, " +
            DinhGia + " String, "+
            KhoiLuong + " String, "+
            SoLuong + " TEXT )";

    // Thêm ChiTietDonHang
    public void addCTDH (ChiTietDonHang chiTietDonHang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, chiTietDonHang.getId());
        values.put(HinhAnh, chiTietDonHang.getHinhanh());
        values.put(Mota, chiTietDonHang.getMota());
        values.put(DinhGia, chiTietDonHang.getDinhgia());
        values.put(KhoiLuong, chiTietDonHang.getKhoiluong());
        values.put(SoLuong, chiTietDonHang.getSoluong());
        db.insert(TABLES_CTDH, null, values);
        db.close();
    }

    // Lấy tất cả ChiTietDonHang
    public List<ChiTietDonHang> getAllCTDH() {
        List<ChiTietDonHang> listCTDH = new ArrayList<>();

        String selectquery = "SELECT * FROM " + TABLES_CTDH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst()) {
            do {
                ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
                chiTietDonHang.setId(cursor.getInt(0));
                chiTietDonHang.setHinhanh(cursor.getString(4));
                chiTietDonHang.setMota(cursor.getString(3));
                chiTietDonHang.setDinhgia(cursor.getString(3));
                chiTietDonHang.setKhoiluong(cursor.getInt(2));
                chiTietDonHang.setSoluong(cursor.getInt(2));
                listCTDH.add(chiTietDonHang);
            } while (cursor.moveToNext());
        }
        db.close();
        return listCTDH;


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
