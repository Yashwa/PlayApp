
package com.oyeplay.android.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("tr")
    @Expose
    private Integer tr;
    @SerializedName("pa")
    @Expose
    private Integer pa;
    @SerializedName("ps")
    @Expose
    private Integer ps;
    @SerializedName("rs")
    @Expose
    private List<R> rs = new ArrayList<R>();

    /**
     * 
     * @return
     *     The tr
     */
    public Integer getTr() {
        return tr;
    }

    /**
     * 
     * @param tr
     *     The tr
     */
    public void setTr(Integer tr) {
        this.tr = tr;
    }

    /**
     * 
     * @return
     *     The pa
     */
    public Integer getPa() {
        return pa;
    }

    /**
     * 
     * @param pa
     *     The pa
     */
    public void setPa(Integer pa) {
        this.pa = pa;
    }

    /**
     * 
     * @return
     *     The ps
     */
    public Integer getPs() {
        return ps;
    }

    /**
     * 
     * @param ps
     *     The ps
     */
    public void setPs(Integer ps) {
        this.ps = ps;
    }

    /**
     * 
     * @return
     *     The rs
     */
    public List<R> getRs() {
        return rs;
    }

    /**
     * 
     * @param rs
     *     The rs
     */
    public void setRs(List<R> rs) {
        this.rs = rs;
    }

}
