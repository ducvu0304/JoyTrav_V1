package com.JoyTrav.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateFormater {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public Date coverToDate (String date) {
        try {
            return simpleDateFormat.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
