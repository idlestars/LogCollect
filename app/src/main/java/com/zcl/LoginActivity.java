package com.zcl;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logcollec.R;


public class LoginActivity extends Activity implements View.OnClickListener {

    EditText username;
    EditText password;
    Button login;
    CheckBox rempassword;
    TextView register;
    Intent intent;
    String un;
    String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        login=(Button) findViewById(R.id.b_login);
        register=(TextView) findViewById(R.id.tv_register);
        login.setOnClickListener(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        rempassword=(CheckBox) findViewById(R.id.cb_rempassword);
        username=(EditText) findViewById(R.id.et_username);
        password=(EditText) findViewById(R.id.et_password);
        if (rempassword.isChecked()) {
            SharedPreferences pref = getSharedPreferences("data",
                    MODE_PRIVATE);
            un = pref.getString("username", "");
            pw = pref.getString("password", "");
            username.setText(un);
            password.setText(pw);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        if(true==isLoginEmpty()){

            Login();
        }
    }

    private void Login() {
        if (username.getText().toString().equals(un)&&password.getText().toString().equals(pw)){
            intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(LoginActivity.this,"用户名或密码错误！！！",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isLoginEmpty() {
        SharedPreferences pref = getSharedPreferences("data",
                MODE_PRIVATE);
        username=(EditText) findViewById(R.id.et_username);
        password=(EditText) findViewById(R.id.et_password);
        String um = username.getText().toString().trim();
        String pw = password.getText().toString().trim();
        if (TextUtils.isEmpty(um)) {
            Toast.makeText(LoginActivity.this, "account can not empty!",
                    Toast.LENGTH_LONG).show();
            return false;
        } else if (TextUtils.isEmpty(pw)) {
            Toast.makeText(LoginActivity.this,
                    "password can not empty!", Toast.LENGTH_LONG)
                    .show();
            return false;
        } else {
            return true;
        }
    }
}
