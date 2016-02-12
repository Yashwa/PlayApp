package com.oyeplay.android.utility;

/**
 * Created by Gaurav Badarkhe on 2/9/16.
 */
public class Api {

    public static String ip = "http://52.10.47.23/";
    public static String getcities = ip+"bmc-api/get_cities";
    public static String getclubcount = ip+"bmc-api/get_club_count/Bangalore";
    public static String getgrounds = ip+"bmc-api/find_grounds?game=%s&city=%s";
    public static String getgrounds2 = ip+"bmc-api/find_grounds?game=%s&city=%s&lat=%s&lon=%s&area=";
    public static String getclubdetails = ip+"bmc-api/get_club_detail/";

}
