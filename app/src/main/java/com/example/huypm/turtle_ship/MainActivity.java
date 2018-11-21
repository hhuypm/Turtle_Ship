package com.example.huypm.turtle_ship;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import java.util.Calendar;
import java.util.Date;


import com.example.huypm.turtle_ship.DBManager.TurtleShipManager;
import com.example.huypm.turtle_ship.model.Customer_Employee;
import com.example.huypm.turtle_ship.model.Users;

public class MainActivity extends AppCompatActivity {
    Button btn_register;
    Button btn_login;
    EditText et_account;
    EditText et_pass;
    private Dialog dialog;
    TurtleShipManager db = new TurtleShipManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.activity_main);
        findViewByIds();
        Date currentTime = Calendar.getInstance().getTime();
        Log.d("datetest",String.valueOf(currentTime));
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chỗ này là đăng nhập
                if (db.Sign_in(et_account.getText().toString(),et_pass.getText().toString())!= -1) {
                    int id = db.Sign_in(et_account.getText().toString(),et_pass.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), MainContent.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID",id);
                    intent.putExtra("ID",id);

                    Log.d("test","dung r");
                    showAlertDialog_DN();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                    Log.d("test","sai r");
                    showAlertDialog_DNTB();
                }
            }
        });

        Button btn_test2 = (Button) findViewById(R.id.btn_fogot_pass);
        btn_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainContent.class);
                startActivity(intent);
            }
        });

        TurtleShipManager db = new TurtleShipManager(this);
    }

    public void showAlertDialog_DN(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage("Đăng Nhập Thành Công");
        builder.setCancelable(false);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getApplicationContext(), MainContent.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
    public void showAlertDialog_DNTB(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage("Đăng Nhập Thất Bại");
        builder.setCancelable(false);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
    public void findViewByIds(){
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_login = (Button) findViewById(R.id.btn_sign_in);
        et_account = (EditText) findViewById(R.id.email_phone);
        et_pass = (EditText) findViewById(R.id.password);
    }
    public void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
