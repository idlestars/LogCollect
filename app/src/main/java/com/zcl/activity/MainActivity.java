package com.zcl.activity;


import com.example.logcollec.R;
import com.zcl.adapter.ImageGalleryAdapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Gallery;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity implements OnClickListener {
	private Fragment[] mFragments;
	private FragmentManager fragmentManager;
	private Gallery gallery;
	private View selectedMenu;
	private int selectedFragment = 0;
	private boolean kongzhi = false;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		View home = findViewById(R.id.iv_shouye);
		findViewById(R.id.iv_mylog).setOnClickListener(this);
		findViewById(R.id.iv_myself).setOnClickListener(this);
		home.setOnClickListener(this);
		findViewById(R.id.iv_meg).setOnClickListener(this);

		gallery = (Gallery) findViewById(R.id.gallery1);
		gallery.setAdapter(new ImageGalleryAdapter(this));

		mFragments = new Fragment[4];
		fragmentManager = getFragmentManager();
		mFragments[0] = fragmentManager.findFragmentById(R.id.fragement_main);
		mFragments[1] = fragmentManager.findFragmentById(R.id.fragement_mylog);
		mFragments[2] = fragmentManager.findFragmentById(R.id.fragement_meg);
		mFragments[3] = fragmentManager.findFragmentById(R.id.fragement_myself);

		hideAllFragments();
		onClick(home);
	}


	@Override
	public void onClick(View v) {
		if (v == selectedMenu) return;
		if (selectedMenu != null) {
			selectedMenu.setSelected(false);
		}
		v.setSelected(true);
		selectedMenu = v;

		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.hide(mFragments[selectedFragment]);

		switch (v.getId()) {
			case R.id.iv_shouye:
				selectedFragment = 0;
				break;
			case R.id.iv_mylog:
				selectedFragment = 1;
				break;
			case R.id.iv_meg:
				selectedFragment = 2;
				break;
			case R.id.iv_myself:
				selectedFragment = 3;
				break;
		}

		transaction.show(mFragments[selectedFragment]).commit();
	}

	private void hideAllFragments() {
		fragmentManager.beginTransaction()
				.hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2])
				.hide(mFragments[3]).commit();
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (kongzhi == false) {
				Toast.makeText(MainActivity.this, "再按一次退出",
						Toast.LENGTH_SHORT).show();
				kongzhi = true;
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						kongzhi = false;
					}
				};
				timer.schedule(task, 2000);
			} else {
				finish();
				System.exit(0);
			}

			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

}
