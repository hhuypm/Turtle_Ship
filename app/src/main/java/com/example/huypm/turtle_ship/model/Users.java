package com.example.huypm.turtle_ship.model;

public class Users {
    private int Id;
    private int Cus_Emp;
    private String Pass;

    public Users(){
    }

    public Users (int id, int cus_emp, String pass){
        this.Id = id;
        this.Cus_Emp = cus_emp;
        this.Pass = pass;
    }

    public int getId()  {return Id;}
    public void setId(int id) {
        this.Id = id;
    }
    public int getCus_Emp()  {return Cus_Emp;}
    public void setCus_Emp(int cus_emp) { this.Cus_Emp = cus_emp;}
    public String getPass() {
        return Pass;
    }
    public void setPass(String pass) {
        Pass = pass;
    }
}
