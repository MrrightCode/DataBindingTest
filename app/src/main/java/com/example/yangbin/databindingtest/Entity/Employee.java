package com.example.yangbin.databindingtest.Entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.yangbin.databindingtest.BR;

/**
 * Created by yangbin on 2018/4/20.
 */
public class Employee extends BaseObservable {
    public String firstName;
    public String lastName;
    public boolean isFired;
    public String url;

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public Employee(String firstName, String lastName, boolean isFired) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isFired = isFired;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.firstName);
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }
}
