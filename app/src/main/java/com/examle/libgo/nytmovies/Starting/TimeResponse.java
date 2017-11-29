package com.examle.libgo.nytmovies.Starting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by libgo on 30.11.2017.
 */

public class TimeResponse {


    public String getTime(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
}
