package com.oyeplay.android.bean;

/**
 * Created by hubbelsoftware on 2/16/16.
 */
public class BeanReview {

    /**
     * review
     */
    private String rev;
    /**
     * recommend
     */
    private Boolean re;
    /**
     * rating
     */
    private Integer ra;
    /**
     * userId
     */
    private Long ui;
    /**
     * userFirstName
     */
    private String fn;
    /**
     * userLastName
     */
    private String ln;

    /**
     * display image url
     */
    private String du;

    public String getDu() {
        return du;
    }
    public void setDu(String du) {
        this.du = du;
    }
    public String getRev() {
        return rev;
    }
    public void setRev(String rev) {
        this.rev = rev;
    }
    public Boolean getRe() {
        return re;
    }
    public void setRe(Boolean re) {
        this.re = re;
    }
    public Integer getRa() {
        return ra;
    }
    public void setRa(Integer ra) {
        this.ra = ra;
    }
    public Long getUi() {
        return ui;
    }
    public void setUi(Long ui) {
        this.ui = ui;
    }
    public String getFn() {
        return fn;
    }
    public void setFn(String fn) {
        this.fn = fn;
    }
    public String getLn() {
        return ln;
    }
    public void setLn(String ln) {
        this.ln = ln;
    }
}
