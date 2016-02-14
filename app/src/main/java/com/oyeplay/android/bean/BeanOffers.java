package com.oyeplay.android.bean;

import java.io.Serializable;

/**
 * Created by Yashwanth on 2/8/2016.
 */
public class BeanOffers implements Serializable {

    private String heading;
    private String offer;
    private String timestamp;
    private String originalPrice;
    private String offerPrice;
    private int noOfTickets;


    public BeanOffers(String heading, String offer, String timestamp, String originalPrice, String offerPrice, int noOfTickets) {
        this.heading = heading;
        this.offer = offer;
        this.timestamp = timestamp;
        this.originalPrice = originalPrice;
        this.offerPrice = offerPrice;
        this.noOfTickets = noOfTickets;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "BeanOffers{" +
                "heading='" + heading + '\'' +
                ", offer='" + offer + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", offerPrice='" + offerPrice + '\'' +
                ", noOfTickets=" + noOfTickets +
                '}';
    }
}
