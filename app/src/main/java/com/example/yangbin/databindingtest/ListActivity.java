package com.example.yangbin.databindingtest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.yangbin.databindingtest.Adapter.EmployeeAdapter;
import com.example.yangbin.databindingtest.Entity.Employee;
import com.example.yangbin.databindingtest.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yangbin on 2018/4/19.
 */
public class ListActivity extends Activity{

    ActivityListBinding binding;
    private EmployeeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_list);
        Presenter presenter = new Presenter();
        binding.setPresenter(presenter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new EmployeeAdapter(this);
        binding.recyclerview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void onEmployeeClick(Employee employee) {
                Toast.makeText(ListActivity.this,"别点了",Toast.LENGTH_SHORT).show();
            }
        });


        //模拟数据来源
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("李","实名",false));
        list.add(new Employee("李","bai",false));
        list.add(new Employee("wang","wei",false));
        list.add(new Employee("chang","zhang",true));

        mAdapter.addAll(list);

    }

    public class Presenter{
        public void addClick(){
            mAdapter.add(new Employee("new","name",false));
        }

        public void deleteClick(){
            mAdapter.remove();
        }
    }
}
