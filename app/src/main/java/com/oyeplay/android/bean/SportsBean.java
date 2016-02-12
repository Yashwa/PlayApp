package com.oyeplay.android.bean;

/**
 * Created by hubbelsoftware on 2/10/16.
 */
public class SportsBean {

    private String name;
    private int intcount;
    private int image;

    public SportsBean(String name, int intcount, int image) {
        this.name = name;
        this.intcount = intcount;
        this.image = image;
    }


    public int getIntcount() {
        return intcount;
    }

    public void setIntcount(int intcount) {
        this.intcount = intcount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
