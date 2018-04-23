package com.example.yangbin.databindingtest.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yangbin.databindingtest.BR;
import com.example.yangbin.databindingtest.Entity.Employee;
import com.example.yangbin.databindingtest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yangbin on 2018/4/19.
 * 这个类是为RecyalerView 创建的适配器类  主要的作用是做界面和数据的适配
 */
public class EmployeeAdapter  extends RecyclerView.Adapter<EmployeeAdapter.BindingViewHolder>{

    //定义不同Item的状态码 实现动态绑定
    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 0;

    private final LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnItemClickListener;
    private List<Employee> mEmployeeList;
    private Random mRandom = new Random(System.currentTimeMillis());

    //构造函数 主要是初始化数据来源
    public EmployeeAdapter(Context context ){
        //初始化LayoutInflater 在这里Inflater的主要作用是
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mEmployeeList = new ArrayList<>();
    }

    //一下的方法是复写的父类的方法

    /**
     * \
     * @param parent
     * @param viewType
     * @return 更具不用的ViewType 创建不同的ViewHolder，ViewHolder的主要的作用的实现获取界面的View
     */
    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding ;
        if(viewType == ITEM_VIEW_TYPE_ON){
            dataBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee_on,parent,false);
        }else {
            dataBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee_off,parent,false);
        }
        return new BindingViewHolder(dataBinding);
    }

    /**
     * 在这里是做的实际的数据和界面的绑定的操作,实际上这里做的事就是将Databinding 所对应的数据源做结合，但是我们并不知道
     * 当前所处的Item对应的是哪一个databinding ,所以我们为XML中我们使用了相同的Name
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
            final  Employee employee = mEmployeeList.get(position);
            //绑定实际数据
            holder.getmBinding().setVariable(BR.item,employee);
            //这里主要是实现及时的界面刷新
            holder.getmBinding().executePendingBindings();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onEmployeeClick(employee);
                }
            });

    }

    @Override
    public int getItemCount() {
        return mEmployeeList.size();
    }

    //返回每一行ItemView的type就是上面定义的两种类型
    @Override
    public int getItemViewType(int position) {
        Employee employee = mEmployeeList.get(position);
        if(employee.isFired){
            return ITEM_VIEW_TYPE_OFF;
        }else {
            return ITEM_VIEW_TYPE_ON;
        }
    }

    //因为使用了Databiding 所以这个类现在需要从Binding里面去获取View
    public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{
        private T mBinding;

        public BindingViewHolder(T binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public T getmBinding(){
            return mBinding;
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    //接口实现点击事件
    public interface OnItemClickListener{
        void onEmployeeClick(Employee employee);
    }




    public void addAll(List<Employee> list){
        mEmployeeList.addAll(list);
    }

    public void add(Employee employee){
        int position = mRandom.nextInt(mEmployeeList.size());
        mEmployeeList.add(position,employee);
        notifyItemInserted(position);
    }

    public void remove(){
        if(mEmployeeList.size() == 0){
            return;
        }
        int position = mRandom.nextInt(mEmployeeList.size());
        mEmployeeList.remove(position);
        notifyItemRemoved(position);
    }
}
