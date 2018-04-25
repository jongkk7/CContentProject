package com.nainfox.choc2_content01.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yjk on 2018. 4. 17..
 */

public class DateFactory {
    private SimpleDateFormat format;



    private long getNow(){
        return System.currentTimeMillis();
    }
    private Date getDate(long now){
        return new Date(now);
    }





    public int getHour(){
        format = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");

        String date = format.format(getDate(getNow()));

        return getHourString(date);
    }


    private int getHourString(String date){
        String[] arr = date.split("/");

        return Integer.parseInt(arr[3]);
    }

}
