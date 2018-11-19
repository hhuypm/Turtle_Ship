package com.example.huypm.turtle_ship;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.huypm.turtle_ship.DBManager.TurtleShipManager;
import com.example.huypm.turtle_ship.model.Customer_Employee;
import com.example.huypm.turtle_ship.model.Users;

public class RegisterActivity extends AppCompatActivity {
    Button btn_back;
    Button btn_accpect_register;
    EditText et_name;
    EditText et_phone;
    EditText et_pass;
    EditText et_re_pass;
    EditText et_mail;
    Context context = this;
    TurtleShipManager db = new TurtleShipManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register_layout);
        FindViewByIds();

        // Get a reference to the Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spn_district);

        // Create an Adapter that holds a list of colors
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.District, R.layout.dropdown_item);

        // Set the Adapter for the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner1 = (Spinner) findViewById(R.id.spn_state);
                ArrayAdapter<CharSequence> adapter1 = null;

                switch (position) {
                    case 0:
                        adapter1 = ArrayAdapter.createFromResource(context, R.array.d1, R.layout.dropdown_item);
                        break;
                    case 1:
                        adapter1 = ArrayAdapter.createFromResource(context, R.array.d2, R.layout.dropdown_item);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        break;
                    case 17:
                        break;
                    case 18:
                        break;
                    case 19:
                        break;
                    case 20:
                        break;
                    case 21:
                        break;
                    case 22:
                        break;
                    case 23:
                        break;
                    case 24:
                        break;
                    default:
                }

                // Create an Adapter that holds a list of colors

                // Set the Adapter for the spinner
                spinner1.setAdapter(adapter1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });


        btn_accpect_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_pass.getText().toString().equals(et_re_pass.getText().toString())) {
                    int maxIdCus_emp = db.getMaxIdCus_Emp();
                    int maxIdUser = db.MaxIdUser();
                    db.addCus_Emp(new Customer_Employee(maxIdCus_emp + 1, et_name.getText().toString(), et_phone.getText().toString(), et_mail.getText().toString(), 0));
                    db.addUser(new Users(maxIdUser+1,maxIdCus_emp+1,et_pass.getText().toString()));
                    RegisterActivity.this.finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),MainContent.class);
                    startActivity(intent);
                }

            }
        });
    }

    public  void FindViewByIds(){
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_accpect_register = (Button) findViewById(R.id.btn_accept_register);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_mail = (EditText) findViewById(R.id.et_mail);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_re_pass = (EditText) findViewById(R.id.et_reenter_pass);
    }

    public void hideKeyboard(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
