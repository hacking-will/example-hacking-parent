package com.example.hacking.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间处理工具类
 *
 * @author jintingying
 * Created on 2019/10/11
 * @version 1.0
 */
public class DateUtils {
    public static final SimpleDateFormat simpleDateFormat_YDM = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat simpleDateFormat_YDM_HMS = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Date stringToDate(String string, String fmt){
        Date date = null;
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);
            date = simpleDateFormat.parse(string);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static String  dateToString(Date date, String fmt){
        return new SimpleDateFormat(fmt).format(date);
    }
}
