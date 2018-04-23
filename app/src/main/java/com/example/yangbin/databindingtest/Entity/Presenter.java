package com.example.yangbin.databindingtest.Entity;

import android.view.View;
import android.widget.Toast;

/**
 * Created by yangbin on 2018/4/19.
 */
public class Presenter{

    public void onClickCommond(View view){
        Toast.makeText(view.getContext(),"点你大爷",Toast.LENGTH_SHORT).show();
    }
}