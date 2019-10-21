package com.example.hacking.common.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期时间处理工具类
 *
 * @author jintingying
 * Created on 2019/10/11
 * @version 1.0
 */
@Slf4j
public class DateUtil {
    private static final List<String> formarts = new ArrayList<>();
    static {
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }

    public static Date convert(String source) {
        if(!StringUtils.isNotEy(source))
            return null;
        source = source.trim();
        if (source.matches("^\\d{4}-\\d{1,2}$")) {
            return parseDate(source, formarts.get(0));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return parseDate(source, formarts.get(1));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, formarts.get(2));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, formarts.get(3));
        } else {
            throw new IllegalArgumentException("Invalid format value '" + source + "'");
        }
    }

    public static Date parseDate(String string,
                                 String fmt){
        Date date = null;
        log.info(" string "+ string);
        log.info(" fmt "+ fmt);
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);
            date = simpleDateFormat.parse(string);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info(" date "+ date);
        return date;
    }

    public static String  dateToString(Date date, String fmt){
        return new SimpleDateFormat(fmt).format(date);
    }
}
