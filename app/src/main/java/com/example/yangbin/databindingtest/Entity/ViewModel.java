package com.example.yangbin.databindingtest.Entity;

/**
 * Created by yangbin on 2018/4/19.
 */
public class ViewModel {
    public String mTvTest1;
    public String mTvTest2;

    public ViewModel(String mTvTest1, String mTvTest2) {
        this.mTvTest1 = mTvTest1;
        this.mTvTest2 = mTvTest2;
    }

    public String getmTvTest1() {
        return mTvTest1;
    }

    public void setmTvTest1(String mTvTest1) {
        this.mTvTest1 = mTvTest1;
    }

    public String getmTvTest2() {
        return mTvTest2;
    }

    public void setmTvTest2(String mTvTest2) {
        this.mTvTest2 = mTvTest2;
    }
}
