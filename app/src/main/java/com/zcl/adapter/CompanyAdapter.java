package com.zcl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.logcollec.R;
import com.zcl.bean.CompanyBean;

import java.util.List;

@SuppressWarnings("deprecation")
public class CompanyAdapter extends ArrayAdapter<CompanyBean> {
	private int resourceId;
	public CompanyAdapter(Context context, int textViewResourceId,
						List<CompanyBean> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CompanyBean company = getItem(position); // 获取当前项的company实例
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		TextView companyname = (TextView) view.findViewById(R.id.tv_companyname);
		TextView entrydate = (TextView) view.findViewById(R.id.tv_entrydate);
		companyname.setText(company.getName());
		entrydate.setText(company.getEntryDate());
		return view;
	}

}
