package com.oyeplay.android.bean;

public class BeanChild {
    private String Name;
    private String Unit;
    private String Quantity;
    private String Price;
    private boolean box;

    public BeanChild() {
    }

    public BeanChild(String name, String unit, String quantity, String price, boolean box) {
        Name = name;
        Unit = unit;
        Quantity = quantity;
        Price = price;
        this.box = box;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public boolean isBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "BeanChild{" +
                "Name='" + Name + '\'' +
                ", Unit='" + Unit + '\'' +
                ", Quantity='" + Quantity + '\'' +
                ", Price='" + Price + '\'' +
                ", box=" + box +
                '}';
    }
}

