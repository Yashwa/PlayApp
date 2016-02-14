package com.oyeplay.android.bean;

import java.io.Serializable;

/**
 * Created by Yashwanth on 2/8/2016.
 */
public class BeanProfessionals implements Serializable {

    private String name;
    private String age;
    private String exp;
    private String address;
    private int dp;
    private float rating;
    private int expertise;

    public BeanProfessionals(String name, String age, String exp, String address, int dp, float rating, int expertise) {
        this.name = name;
        this.age = age;
        this.exp = exp;
        this.address = address;
        this.dp = dp;
        this.rating = rating;
        this.expertise = expertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getExpertise() {
        return expertise;
    }

    public void setExpertise(int expertise) {
        this.expertise = expertise;
    }
}
