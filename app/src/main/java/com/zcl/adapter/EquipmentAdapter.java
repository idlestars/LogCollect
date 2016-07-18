package com.zcl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.logcollec.R;
import com.zcl.bean.EmployeeBean;
import com.zcl.bean.EquipmentBean;

import java.util.List;

@SuppressWarnings("deprecation")
public class EquipmentAdapter extends ArrayAdapter<EquipmentBean> {
	private int resourceId;
	public EquipmentAdapter(Context context, int textViewResourceId,
							List<EquipmentBean> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		EquipmentBean equipment = getItem(position); // 获取当前项的yuangong实例
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		TextView equname = (TextView) view.findViewById(R.id.tv_equipmentname);
		TextView entrydate = (TextView) view.findViewById(R.id.tv_eqentrydate);
		equname.setText(equipment.getName());
		entrydate.setText(equipment.getEntryDate());
		return view;
	}

}
