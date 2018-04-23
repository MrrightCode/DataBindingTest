package com.example.yangbin.databindingtest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.yangbin.databindingtest.Entity.Employee;
import com.example.yangbin.databindingtest.databinding.ActivityCustomizeAttributeBinding;

/**
 * Created by yangbin on 2018/4/23.
 */
public class CustomizeAttributeActivity  extends Activity{

    ActivityCustomizeAttributeBinding mBinding ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Employee employee = new Employee("hi","hi",false);
        employee.setUrl("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3433686578,475386795&fm=200&gp=0.jpg");
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_customize_attribute);
        mBinding.setEmployee(employee);
    }
}
