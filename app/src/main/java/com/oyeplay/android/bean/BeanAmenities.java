package com.oyeplay.android.bean;

import java.io.Serializable;

/**
 * Created by Yashwanth on 2/8/2016.
 */
public class BeanAmenities implements Serializable {

    private String name;

    public BeanAmenities(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanAmenities{" +
                "name='" + name + '\'' +
                '}';
    }
}
