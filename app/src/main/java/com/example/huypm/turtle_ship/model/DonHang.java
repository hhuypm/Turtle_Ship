package com.example.huypm.turtle_ship.model;

import java.util.Date;

public class DonHang {

    private int Id;
    private int Kh;
    private String NgayDat;
    private String NgayGiao;
    private String NgayNhan;
    private int DCnhanhang;
    private int DCgiaohang;
    private int HTgiaohang;
    private int Cayso;
    private int ThanhTien;

    public DonHang(){}
    public DonHang(int id, int kh, String ngayDat, String ngayGiao, String ngayNhan, int dCnhanhang, int dCgiaohang, int hTgiaohang,
                   int cayso, int thanhTien){
        this.Id=id;
        this.Kh=kh;
        this.NgayDat=ngayDat;
        this.NgayGiao=ngayGiao;
        this.NgayNhan=ngayNhan;
        this.DCgiaohang=dCgiaohang;
        this.DCnhanhang=dCnhanhang;
        this.HTgiaohang=hTgiaohang;
        this.Cayso=cayso;
        this.ThanhTien=thanhTien;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getKh() {
        return Kh;
    }

    public void setKh(int kh) {
        Kh = kh;
    }

    public String getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(String ngayDat) {
        NgayDat = ngayDat;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(String ngayGiao) {
        NgayGiao = ngayGiao;
    }

    public String getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        NgayNhan = ngayNhan;
    }

    public int getDCnhanhang() {
        return DCnhanhang;
    }

    public void setDCnhanhang(int DCnhanhang) {
        this.DCnhanhang = DCnhanhang;
    }

    public int getDCgiaohang() {
        return DCgiaohang;
    }

    public void setDCgiaohang(int DCgiaohang) {
        this.DCgiaohang = DCgiaohang;
    }

    public int getHTgiaohang() {
        return HTgiaohang;
    }

    public void setHTgiaohang(int HTgiaohang) {
        this.HTgiaohang = HTgiaohang;
    }

    public int getCayso() {
        return Cayso;
    }

    public void setCayso(int cayso) {
        Cayso = cayso;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
        ThanhTien = thanhTien;
    }
}
