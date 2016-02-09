package com.oyeplay.android.bean;

import java.util.ArrayList;

public class BeanGroup {
    private String Name;
    private ArrayList<BeanChild> Items;

    public void setName(String name) {

        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setItems(ArrayList<BeanChild> Items) {

        this.Items = Items;
    }

    public ArrayList<BeanChild> getItems() {

        return Items;
    }
}

