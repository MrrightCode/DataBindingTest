package com.example.yangbin.databindingtest.Entity;

/**
 * Created by yangbin on 2018/4/20.
 */
public class Employee  {
    public String firstName;
    public String lastName;
    public boolean isFired;

    public Employee(String firstName, String lastName, boolean isFired) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isFired = isFired;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }
}
