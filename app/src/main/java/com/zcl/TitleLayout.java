package com.zcl;

import com.example.logcollec.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TitleLayout extends FrameLayout implements OnClickListener {

	Intent intent;
	TextView biaoduan;
	TextView dongkou;
	ImageView yulan;
	String bd;
	String dk;
	public TitleLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TitleLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.title, this);
		biaoduan=(TextView) findViewById(R.id.tv_biaoduan);
		dongkou=(TextView) findViewById(R.id.tv_dongkou);
		yulan=(ImageView) findViewById(R.id.iv_yulan);
		yulan.setOnClickListener(this);
		SharedPreferences pref = getContext().getSharedPreferences("data",
				getContext().MODE_PRIVATE);
		bd = pref.getString("biaoduan", "");
		dk = pref.getString("dongkou", "");
		biaoduan.setText(bd);
		dongkou.setText(dk);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
        
        case R.id.iv_yulan:        	
        	intent = new Intent(getContext(), YuLanActivity.class);
        	getContext().startActivity(intent);
            break;
        default:
            Toast.makeText(getContext(), "???", Toast.LENGTH_SHORT).show();
        }
	}
}
