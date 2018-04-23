package com.example.yangbin.databindingtest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.yangbin.databindingtest.Entity.Presenter;
import com.example.yangbin.databindingtest.Entity.ViewModel;
import com.example.yangbin.databindingtest.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        ViewModel viewModel = new ViewModel("MMB","你大爷");
        Presenter presenter = new Presenter();
        onButtonClick onButtonClick = new onButtonClick();
        binding.setOnbuttonClick(onButtonClick);
        binding.setPresenter(presenter);
        binding.setViewModel(viewModel);
    }


    public class onButtonClick{
        public void buttonClick(ViewModel viewModel){
            Toast.makeText(MainActivity.this,viewModel.getmTvTest1(),Toast.LENGTH_SHORT).show();
        }

        public void intentToList(){
            startActivity(new Intent(MainActivity.this,ListActivity.class));
        }
    }
}
