package com.example.huypm.turtle_ship.model;

public class DiaChi {
    private int Id=-1;
    private int Cus_Emp=-1;
    private String Tp="";
    private String Quan="";
    private String Phuong="";
    private String Duong="";
    private int GiaoNhan=-1;
    private int DCChinh=-1;

    public DiaChi(){}
    public DiaChi(int id, int cus_Emp, String tp, String quan, String phuong, String duong, int giaoNhan,int dcchinh){
        this.Id=id;
        this.Cus_Emp=cus_Emp;
        this.Tp=tp;
        this.Quan=quan;
        this.Phuong=phuong;
        this.Duong=duong;
        this.GiaoNhan=giaoNhan;
        this.DCChinh = dcchinh;
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

    public int getDCChinh() {
        return DCChinh;
    }

    public void setDCChinh(int dcChinh) {
        GiaoNhan = dcChinh;
    }
}
