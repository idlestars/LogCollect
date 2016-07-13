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
import android.widget.EditText;
import android.widget.Spinner;

import com.example.logcollec.R;


public class AddStaffActivity extends Activity {
    Spinner sp_staffbiaoduan;
    Spinner sp_staffdongkou;
    Spinner sp_staffunit;
    Spinner sp_stafworkface;
    Spinner sp_staftype;
    Button b_submitperson;
    EditText et_staffname;
    EditText et_staffage;
    EditText et_stafftel;
    Intent intent;
    String[] items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addstaff);
        sp_staffbiaoduan = (Spinner) findViewById(R.id.sp_staffbiaoduan);
        sp_staffdongkou = (Spinner) findViewById(R.id.sp_staffdongkou);
        sp_staffunit = (Spinner) findViewById(R.id.sp_staffunit);
        sp_stafworkface = (Spinner) findViewById(R.id.sp_stafworkface);
        sp_staftype = (Spinner) findViewById(R.id.sp_staftype);
        /**
         * spinner定制
         * */
        items = getResources().getStringArray(R.array.sp_biaoduan);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        sp_staffbiaoduan.setAdapter(adapter);
        items = getResources().getStringArray(R.array.sp_dongkou);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        sp_staffdongkou.setAdapter(adapter);
        items = getResources().getStringArray(R.array.sp_unit);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        sp_staffunit.setAdapter(adapter);
        items = getResources().getStringArray(R.array.sp_workface);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        sp_stafworkface.setAdapter(adapter);
        items = getResources().getStringArray(R.array.sp_type);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        sp_staftype.setAdapter(adapter);

        /**
         * 人员信息存储
         * */
        et_staffname=(EditText) findViewById(R.id.et_staffname);
        et_staffage=(EditText) findViewById(R.id.et_staffage);
        et_stafftel=(EditText) findViewById(R.id.et_stafftel);
        b_submitperson=(Button) findViewById(R.id.b_submitperson);

        b_submitperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String um = et_staffname.getText().toString().trim();
                String age = et_staffage.getText().toString().trim();
                String tel = et_stafftel.getText().toString().trim();
                String bd = (String) sp_staffbiaoduan.getSelectedItem();
                String dk = (String) sp_staffdongkou.getSelectedItem();
                String unit = (String) sp_staffunit.getSelectedItem();
                String workface = (String) sp_stafworkface.getSelectedItem();
                String type = (String) sp_staftype.getSelectedItem();
                    try {
                        SharedPreferences.Editor editor = getSharedPreferences("ac",
                                MODE_PRIVATE).edit();
                        editor.putString("name", um);
                        editor.putString("age", age);
                        editor.putString("tel", tel);
                        editor.putString("bd", bd);
                        editor.putString("dk", dk);
                        editor.putString("unit", unit);
                        editor.putString("face", workface);
                        editor.putString("type", type);
                        editor.commit();
                        intent = new Intent(AddStaffActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
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
