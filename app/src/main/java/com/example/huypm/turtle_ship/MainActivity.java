package com.example.huypm.turtle_ship;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


import com.example.huypm.turtle_ship.DBManager.TurtleShipManager;
import com.example.huypm.turtle_ship.model.Customer_Employee;
import com.example.huypm.turtle_ship.model.Users;

public class MainActivity extends AppCompatActivity {
    Button btn_register;
    Button btn_login;
    EditText et_account;
    EditText et_pass;
    TurtleShipManager db = new TurtleShipManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.activity_main);
        findViewByIds();
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
                if (db.Sign_in(et_account.getText().toString(),et_pass.getText().toString())) {
                    Intent intent = new Intent(getApplicationContext(), MainContent.class);
                    startActivity(intent);
                    Log.d("test","dung r");
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                    Log.d("test","sai r");
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
