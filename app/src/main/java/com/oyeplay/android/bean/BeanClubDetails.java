package com.oyeplay.android.bean;

import java.io.Serializable;

/**
 * Created by Yashwanth on 2/8/2016.
 */
public class BeanClubDetails implements Serializable {

    private String name;
    private String address;
    private int rating;
    private int imgBanner;
    private int imgLogo;
    private double price;
    private double lat;
    private double lng;

//    public BeanClubDetails() {
//    }

    public BeanClubDetails(String name, String address, int rating, int imgBanner, int imgLogo, double price, double lat, double lng) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.imgBanner = imgBanner;
        this.imgLogo = imgLogo;
        this.price = price;
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(int imgBanner) {
        this.imgBanner = imgBanner;
    }

    public int getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(int imgLogo) {
        this.imgLogo = imgLogo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BeanClubDetails{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", imgBanner=" + imgBanner +
                ", imgLogo=" + imgLogo +
                ", price=" + price +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
