package com.example.huypm.turtle_ship.model;

public class Customer_Employee {
    private int Id = -1;
    private String Ten = "";
    private String SDT = "";
    private String Email ="";
    private int NV =0;
    public Customer_Employee(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getNV() {
        return NV;
    }

    public void setNV(int NV) {
        this.NV = NV;
    }

    public Customer_Employee(int id, String ten, String sDT, String email, int nv){
        this.Id =id;
        this.Ten=ten;
        this.SDT=sDT;
        this.Email=email;
        this.NV=nv;
    }
}
