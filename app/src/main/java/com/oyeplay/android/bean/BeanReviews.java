package com.oyeplay.android.bean;

import java.io.Serializable;

/**
 * Created by Yashwanth on 2/8/2016.
 */
public class BeanReviews implements Serializable {

    private String name;
    private int dp;
    private String timestamp;
    private String review;
    private float rating;

    public BeanReviews(String name, int dp, String timestamp, String review, float rating) {
        this.name = name;
        this.dp = dp;
        this.timestamp = timestamp;
        this.review = review;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BeanReviews{" +
                "name='" + name + '\'' +
                ", dp=" + dp +
                ", timestamp='" + timestamp + '\'' +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }
}
