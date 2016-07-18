package com.zcl.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.logcollec.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CollectionActivity extends Activity {
    private TextView tv_colgongxu;
    private TextView tv_colpro;
    private TextView tv_colentertime;
    private TextView tv_colofftime;
    private EditText et_colnum;
    private Button b_colsubmit;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.collection);
        intent=getIntent();
        String gongxudata=intent.getStringExtra("col_data");
        String xiangmudata=intent.getStringExtra("col_xiangmu");
        tv_colgongxu=(TextView) findViewById(R.id.tv_colgongxu);
        tv_colpro=(TextView) findViewById(R.id.tv_colpro);
        b_colsubmit=(Button) findViewById(R.id.b_colsubmit);
        tv_colentertime=(TextView) findViewById(R.id.tv_colentertime);
        tv_colgongxu.setText(gongxudata);
        tv_colpro.setText(xiangmudata);
        if(tv_colentertime.getText().equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String time = df.format(new Date());
            tv_colentertime.setText(time);
        }
        b_colsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(CollectionActivity.this,YuLanActivity.class);
                startActivity(intent);
                finish();
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
