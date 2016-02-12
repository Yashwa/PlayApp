
package com.oyeplay.android.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class R {

    @SerializedName("ci")
    @Expose
    private Integer ci;
    @SerializedName("cn")
    @Expose
    private String cn;
    @SerializedName("cin")
    @Expose
    private String cin;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("du")
    @Expose
    private String du;
    @SerializedName("la")
    @Expose
    private String la;
    @SerializedName("lo")
    @Expose
    private String lo;
    @SerializedName("gn")
    @Expose
    private List<String> gn = new ArrayList<String>();
    @SerializedName("sba")
    @Expose
    private Boolean sba;
    @SerializedName("bty")
    @Expose
    private Object bty;
    @SerializedName("dt")
    @Expose
    private Object dt;
    @SerializedName("is")
    @Expose
    private Object is;
    @SerializedName("ar")
    @Expose
    private Object ar;
    @SerializedName("sp")
    @Expose
    private Object sp;

    /**
     * 
     * @return
     *     The ci
     */
    public Integer getCi() {
        return ci;
    }

    /**
     * 
     * @param ci
     *     The ci
     */
    public void setCi(Integer ci) {
        this.ci = ci;
    }

    /**
     * 
     * @return
     *     The cn
     */
    public String getCn() {
        return cn;
    }

    /**
     * 
     * @param cn
     *     The cn
     */
    public void setCn(String cn) {
        this.cn = cn;
    }

    /**
     * 
     * @return
     *     The cin
     */
    public String getCin() {
        return cin;
    }

    /**
     * 
     * @param cin
     *     The cin
     */
    public void setCin(String cin) {
        this.cin = cin;
    }

    /**
     * 
     * @return
     *     The area
     */
    public String getArea() {
        return area;
    }

    /**
     * 
     * @param area
     *     The area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 
     * @return
     *     The du
     */
    public String getDu() {
        return du;
    }

    /**
     * 
     * @param du
     *     The du
     */
    public void setDu(String du) {
        this.du = du;
    }

    /**
     * 
     * @return
     *     The la
     */
    public String getLa() {
        return la;
    }

    /**
     * 
     * @param la
     *     The la
     */
    public void setLa(String la) {
        this.la = la;
    }

    /**
     * 
     * @return
     *     The lo
     */
    public String getLo() {
        return lo;
    }

    /**
     * 
     * @param lo
     *     The lo
     */
    public void setLo(String lo) {
        this.lo = lo;
    }

    /**
     * 
     * @return
     *     The gn
     */
    public List<String> getGn() {
        return gn;
    }

    /**
     * 
     * @param gn
     *     The gn
     */
    public void setGn(List<String> gn) {
        this.gn = gn;
    }

    /**
     * 
     * @return
     *     The sba
     */
    public Boolean getSba() {
        return sba;
    }

    /**
     * 
     * @param sba
     *     The sba
     */
    public void setSba(Boolean sba) {
        this.sba = sba;
    }

    /**
     * 
     * @return
     *     The bty
     */
    public Object getBty() {
        return bty;
    }

    /**
     * 
     * @param bty
     *     The bty
     */
    public void setBty(Object bty) {
        this.bty = bty;
    }

    /**
     * 
     * @return
     *     The dt
     */
    public Object getDt() {
        return dt;
    }

    /**
     * 
     * @param dt
     *     The dt
     */
    public void setDt(Object dt) {
        this.dt = dt;
    }

    /**
     * 
     * @return
     *     The is
     */
    public Object getIs() {
        return is;
    }

    /**
     * 
     * @param is
     *     The is
     */
    public void setIs(Object is) {
        this.is = is;
    }

    /**
     * 
     * @return
     *     The ar
     */
    public Object getAr() {
        return ar;
    }

    /**
     * 
     * @param ar
     *     The ar
     */
    public void setAr(Object ar) {
        this.ar = ar;
    }

    /**
     * 
     * @return
     *     The sp
     */
    public Object getSp() {
        return sp;
    }

    /**
     * 
     * @param sp
     *     The sp
     */
    public void setSp(Object sp) {
        this.sp = sp;
    }

}
