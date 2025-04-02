package com.ecommerce.demo.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHandler {
    public static String fromDateToString(Date date) {
// Create an instance of SimpleDateFormat used for formatting
// the string representation of date according to the chosen pattern
        DateFormat df = new SimpleDateFormat("yyyy/dd/MM");
// Using DateFormat format method we can create a string
// representation of a date with the defined format.
        String todayAsString = df.format(date);

// Print the result!
        return todayAsString;
    }

    public static Date fromStringToDate(String date)  {

        String dateString = date;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/dd/MM");
        Date rs = null;
        try {
            rs = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
