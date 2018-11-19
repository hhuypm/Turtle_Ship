package com.example.huypm.turtle_ship.model;

public class DiaChi {
    private int Id;
    private int Cus_Emp;
    private String Tp;
    private String Quan;
    private String Phuong;
    private String Duong;
    private int GiaoNhan;

    public DiaChi(){}
    public DiaChi(int id, int cus_Emp, String tp, String quan, String phuong, String duong, int giaoNhan){
        this.Id=id;
        this.Cus_Emp=cus_Emp;
        this.Tp=tp;
        this.Quan=quan;
        this.Phuong=phuong;
        this.Duong=duong;
        this.GiaoNhan=giaoNhan;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCus_Emp() {
        return Cus_Emp;
    }

    public void setCus_Emp(int cus_Emp) {
        Cus_Emp = cus_Emp;
    }

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    public String getQuan() {
        return Quan;
    }

    public void setQuan(String quan) {
        Quan = quan;
    }

    public String getPhuong() {
        return Phuong;
    }

    public void setPhuong(String phuong) {
        Phuong = phuong;
    }

    public String getDuong() {
        return Duong;
    }

    public void setDuong(String duong) {
        Duong = duong;
    }

    public int getGiaoNhan() {
        return GiaoNhan;
    }

    public void setGiaoNhan(int giaoNhan) {
        GiaoNhan = giaoNhan;
    }
}
