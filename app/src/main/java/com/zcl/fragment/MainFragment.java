package com.zcl.fragment;


import com.example.logcollec.R;
import com.zcl.activity.AddStaffActivity;
import com.zcl.activity.MainActivity;
import com.zcl.activity.ProcessActivity;
import com.zcl.adapter.CompanyAdapter;
import com.zcl.bean.CompanyBean;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Intent intent;
    private ImageView iv_addcompany;
    private ImageView iv_addperson;
    private ImageView iv_addequitment;
    private GridView gv_prj;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private CompanyAdapter companyAdapter;
    private List<CompanyBean> comList;

    private int[] icon = { R.drawable.biandinggong, R.drawable.diban,
            R.drawable.gangzhicheng, R.drawable.gongjia, R.drawable.guanjiang,
            R.drawable.maogan, R.drawable.rgzb, R.drawable.tbm};
    private String[] iconName = { "边顶拱", "底板", "钢支撑", "拱架", "灌浆", "锚杆", "人工钻爆",
            "TBM开挖"};
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.index, container, false);

        iv_addcompany=(ImageView)view.findViewById(R.id.iv_addcompany);
        iv_addperson=(ImageView)view.findViewById(R.id.iv_addperson);
        iv_addequitment=(ImageView)view.findViewById(R.id.iv_addequitment);
        iv_addcompany.setOnClickListener(this);
        iv_addperson.setOnClickListener(this);
        iv_addequitment.setOnClickListener(this);

        /**
         * company
         * */
        comList = new ArrayList<CompanyBean>();
        CompanyBean companyBean=new CompanyBean("哇咔咔咔咔");
        CompanyBean companyBean1=new CompanyBean("我们都是小青蛙");
        CompanyBean companyBean2=new CompanyBean("百度影音");
        comList.add(companyBean);
        comList.add(companyBean1);
        comList.add(companyBean2);
        companyAdapter = new CompanyAdapter(getActivity(),
                R.layout.companyiteminfo, comList);
        ListView cplistview = (ListView) view.findViewById(R.id.lv_company);
        cplistview.setAdapter(companyAdapter);
        /**
         * xiangmu
         * */
        gv_prj = (GridView) view.findViewById(R.id.gv_prj);
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String [] from ={"image","text"};
        int [] to = {R.id.iv_image,R.id.tv_text};
        sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.griditeminfo, from, to);
        //配置适配器
        gv_prj.setAdapter(sim_adapter);
        gv_prj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "biandinggong");
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "diban");
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "gangzhicheng");
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "gongjia");
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "guanjiang");
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "maogan");
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "rgzb");
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(view.getContext(), ProcessActivity.class);
                        intent.putExtra("extra_data", "tbm");
                        startActivity(intent);
                        break;
                }
            }
        });
        return view;
    }

    public List<Map<String, Object>> getData(){
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);    
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_addcompany:
                intent = new Intent(view.getContext(), AddStaffActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_addperson:
                intent = new Intent(view.getContext(), AddStaffActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_addequitment:
                intent = new Intent(view.getContext(), AddStaffActivity.class);
                startActivity(intent);
                break;
        }

    }
}
