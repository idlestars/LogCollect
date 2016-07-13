package com.zcl.activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.logcollec.R;


public class RegisterActivity extends Activity {
    Spinner sp_biaoduan;
    Spinner sp_dongkou;
    Button b_submit;
    EditText et_regusername;
    EditText et_regpassword;
    EditText et_onceregpassword;
    EditText et_name;
    CheckBox cb_agree;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register);
        sp_biaoduan = (Spinner) findViewById(R.id.sp_biaoduan);
        sp_dongkou = (Spinner) findViewById(R.id.sp_dongkou);
        String[] biaoduanItems = getResources().getStringArray(R.array.sp_biaoduan);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, biaoduanItems);
        sp_biaoduan.setAdapter(adapter);
        String[] dongkouItems = getResources().getStringArray(R.array.sp_dongkou);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, dongkouItems);
        sp_dongkou.setAdapter(adapter);

        et_regusername=(EditText) findViewById(R.id.et_regusername);
        et_regpassword=(EditText) findViewById(R.id.et_regpassword);
        et_onceregpassword=(EditText) findViewById(R.id.et_onceregpassword);
        et_name=(EditText) findViewById(R.id.et_name);
        b_submit=(Button) findViewById(R.id.b_submit);
        cb_agree=(CheckBox) findViewById(R.id.cb_agree);

        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_agree.isChecked()) {
                    String um = et_regusername.getText().toString().trim();
                    String pw = et_regpassword.getText().toString().trim();
                    String oncepw = et_onceregpassword.getText().toString().trim();
                    String name = et_name.getText().toString().trim();
                    String bd = (String) sp_biaoduan.getSelectedItem();
                    String dk = (String) sp_dongkou.getSelectedItem();
                    if (pw.equals(oncepw)) {
                        try {
                            SharedPreferences.Editor editor = getSharedPreferences("data",
                                    MODE_PRIVATE).edit();
                            editor.putString("username", um);
                            editor.putString("password", pw);
                            editor.putString("name", name);
                            editor.putString("biaoduan", bd);
                            editor.putString("dongkou", dk);
                            editor.commit();
                            intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
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
}
