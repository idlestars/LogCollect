package com.zcl.fragment;

import com.example.logcollec.R;
import com.zcl.activity.AuthorActivity;
import com.zcl.activity.LoginActivity;
import com.zcl.activity.ProcessActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MySelfFragment extends Fragment implements View.OnClickListener {
	private TextView tv_mymes;
	private TextView tv_mylog;
	private TextView tv_mynews;
	private TextView tv_author;
	private TextView tv_cancel;
	private Intent intent;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.myself, container, false);
		tv_mymes=(TextView)view.findViewById(R.id.tv_mymes);
		tv_mylog=(TextView)view.findViewById(R.id.tv_mylog);
		tv_mynews=(TextView)view.findViewById(R.id.tv_mynews);
		tv_author=(TextView)view.findViewById(R.id.tv_author);
		tv_cancel=(TextView)view.findViewById(R.id.tv_cancel);
		tv_mymes.setOnClickListener(this);
		tv_mylog.setOnClickListener(this);
		tv_mynews.setOnClickListener(this);
		tv_author.setOnClickListener(this);
		tv_cancel.setOnClickListener(this);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.tv_mymes:
				Toast.makeText(getActivity(), "wakaka", Toast.LENGTH_SHORT).show();
				break;
			case R.id.tv_mylog:
				Toast.makeText(getActivity(), "wakaka", Toast.LENGTH_SHORT).show();
				break;
			case R.id.tv_mynews:
				Toast.makeText(getActivity(), "wakaka", Toast.LENGTH_SHORT).show();
				break;
			case R.id.tv_author:
				intent = new Intent(v.getContext(), AuthorActivity.class);
				startActivity(intent);
				break;
			case R.id.tv_cancel:
				intent = new Intent(v.getContext(), LoginActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				break;
		}
	}
}
