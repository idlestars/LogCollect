package com.zcl;


import com.example.logcollec.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class MainFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Intent intent;
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.index, container, false);
        ImageView iv_addcompany;
        iv_addcompany=(ImageView)view.findViewById(R.id.iv_addcompany);
        iv_addcompany.setOnClickListener(this);
        return view;
    }  

	@Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);    
    }

    @Override
    public void onClick(View view) {
        intent = new Intent(view.getContext(), YuLanActivity.class);
        startActivity(intent);
    }
}
