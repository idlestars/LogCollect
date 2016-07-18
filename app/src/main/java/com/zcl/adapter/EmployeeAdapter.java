package com.zcl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.logcollec.R;
import com.zcl.bean.EmployeeBean;

import java.util.List;

@SuppressWarnings("deprecation")
public class EmployeeAdapter extends ArrayAdapter<EmployeeBean> {
	private int resourceId;
	public EmployeeAdapter(Context context, int textViewResourceId,
						   List<EmployeeBean> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		EmployeeBean employee = getItem(position); // 获取当前项的yuangong实例
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		TextView empname = (TextView) view.findViewById(R.id.tv_employeename);
		TextView entrydate = (TextView) view.findViewById(R.id.tv_ementrydate);
		empname.setText(employee.getName());
		entrydate.setText(employee.getEntryDate());
		return view;
	}

}
