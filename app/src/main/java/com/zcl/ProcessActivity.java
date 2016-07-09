package com.zcl;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.logcollec.R;


public class ProcessActivity extends Activity {

    private String[] biandinggong = {"仓号准备", "钢筋制安（超前）", "钢模台车就位", "模板校核",
            "止水带挂设及封堵（除小边摸）", "底角清理、台车加固及仓号验收", "小边模堵头模板封堵", "混凝土浇筑", "混凝土等强", "堵头模板拆除","外观处理"};
    private String[] diban = {"仓号准备", "钢筋制安（超前）", "止水带挂设及封堵（除小边摸）",  "混凝土浇筑", "混凝土等强", "堵头模板拆除","外观处理","养护"};
    ListView listView;
    ArrayAdapter<String> adapter;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.process);
        Intent intent = getIntent();
        data = intent.getStringExtra("extra_data");
        listView = (ListView) findViewById(R.id.lv_process);
        if(data.equals("biandinggong")) {
            Log.d("SecondActivity", data);
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, biandinggong);
            listView.setAdapter(adapter);
        }else if (data.equals("diban")) {
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, diban);
            listView.setAdapter(adapter);
        }
        else if (data.equals("gangzhicheng")) {
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, biandinggong);
            listView.setAdapter(adapter);
        }
        else if (data.equals("gongjia")) {
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, biandinggong);
            listView.setAdapter(adapter);
        }
        else if (data.equals("rgzb")) {
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, biandinggong);
            listView.setAdapter(adapter);
        }
        else if (data.equals("guanjiang")) {
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, biandinggong);
            listView.setAdapter(adapter);
        }
        else if (data.equals("maogan")) {
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, biandinggong);
            listView.setAdapter(adapter);
        }
        else if (data.equals("tbm")) {
            adapter = new ArrayAdapter<String>(ProcessActivity.this, android.R.layout.simple_list_item_1, biandinggong);
            listView.setAdapter(adapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
