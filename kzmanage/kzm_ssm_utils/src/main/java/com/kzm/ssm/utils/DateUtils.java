package com.kzm.ssm.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换成字符串
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        String s = sf.format(date);
        return s;
    }

    //字符串转换成日期
    public static Date stringToDate(String date, String pattern) throws ParseException {
        SimpleDateFormat sf=new SimpleDateFormat(pattern);
       Date parse = sf.parse(date);
       return parse;
    }
}
