package com.zcl.fragment;


import com.example.logcollec.R;
import com.zcl.activity.AddStaffActivity;
import com.zcl.activity.MainActivity;
import com.zcl.activity.ProcessActivity;
import com.zcl.adapter.CompanyAdapter;
import com.zcl.adapter.EmployeeAdapter;
import com.zcl.adapter.EquipmentAdapter;
import com.zcl.bean.CompanyBean;
import com.zcl.bean.EmployeeBean;
import com.zcl.bean.EquipmentBean;
import com.zcl.transformer.RotateDownPageTransformer;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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
    private EmployeeAdapter employeeAdapter;
    private EquipmentAdapter equipmentAdapter;
    private List List;
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    private int[] imgRes = {R.drawable.a, R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

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
         * viewpage
         * */
        mViewPager = (ViewPager) view.findViewById(R.id.vp_img);
        //设置Page间间距
        mViewPager.setPageMargin(10);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter = new PagerAdapter()
        {
            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                ImageView view = new ImageView(getActivity());
                view.setImageResource(imgRes[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView((View) object);
            }

            @Override
            public int getCount()
            {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o)
            {
                return view == o;
            }
        });

        mViewPager.setPageTransformer(true,new RotateDownPageTransformer());

        /**
         * company
         * */
        List = new ArrayList<CompanyBean>();
        CompanyBean companyBean=new CompanyBean("哇咔咔咔咔");
        CompanyBean companyBean1=new CompanyBean("我们都是小青蛙");
        CompanyBean companyBean2=new CompanyBean("百度影音");
        List.add(companyBean);
        List.add(companyBean1);
        List.add(companyBean2);
        companyAdapter = new CompanyAdapter(getActivity(),
                R.layout.companyiteminfo, List);
        ListView cplistview = (ListView) view.findViewById(R.id.lv_company);
        cplistview.setAdapter(companyAdapter);

        /**
         * employee
         * */
        List = new ArrayList<EmployeeBean>();
        EmployeeBean emp1=new EmployeeBean("张三");
        EmployeeBean emp2=new EmployeeBean("李四");
        EmployeeBean emp3=new EmployeeBean("王五");
        List.add(emp1);
        List.add(emp2);
        List.add(emp3);
        employeeAdapter = new EmployeeAdapter(getActivity(),
                R.layout.employeeiteminfo, List);
        ListView emplistview = (ListView) view.findViewById(R.id.lv_renyuan);
        emplistview.setAdapter(employeeAdapter);

        /**
         * equipment
         * */
        List = new ArrayList<EquipmentBean>();
        EquipmentBean equ1=new EquipmentBean("挖掘机");
        EquipmentBean equ2=new EquipmentBean("装载机");
        EquipmentBean equ3=new EquipmentBean("叉车");
        List.add(equ1);
        List.add(equ2);
        List.add(equ3);
        equipmentAdapter = new EquipmentAdapter(getActivity(),
                R.layout.equipmentiteminfo, List);
        ListView equlistview = (ListView) view.findViewById(R.id.lv_shebei);
        equlistview.setAdapter(equipmentAdapter);

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
