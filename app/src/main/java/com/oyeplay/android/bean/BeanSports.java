package com.oyeplay.android.bean;

/**
 * Created by Yashwanth on 2/6/2016.
 */
public class BeanSports {

    private String title;
    private int image;
    private int id;
    private boolean isSelected;

    public BeanSports(String title, int image, int id) {
        this.title = title;
        this.image = image;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return "BeanSports{" +
                "title='" + title + '\'' +
                ", image=" + image +
                ", id=" + id +
                ", isSelected=" + isSelected +
                '}';
    }
}
