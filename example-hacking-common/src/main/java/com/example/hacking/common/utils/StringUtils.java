package com.example.hacking.common.utils;

import java.util.UUID;

/**
 * 字符串处理工具类
 *
 * @author jintingying
 * Created on 2019/10/11
 * @version 1.0
 */
public class StringUtils {

    public static final String SQL_FILED_CONDITION_ALL_FLAG = "*";

    private static final String emailRegx = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$";

    private static final String phoneRegx = "^(13[0-9]|15[01]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$";

    /**
     * 判断一个字符串是否不为null且不为空
     *
     * @param  str
     * @return boolean
     */
    public static boolean isNotEy(String str){
        return null != str && !"".equals(str);
    }

    /**
     * 使用UUID生成字符串ID
     *
     * @return String
     */
    public static String randomUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断字符串是否为邮箱格式
     *
     * @param  str
     * @return boolean
     */
    public static boolean isEmail(String str){
       if(isNotEy(str)) return str.matches(emailRegx);
       else return false;
    }

    /**
     * 判断字符串是否为手机号格式
     *
     * @param  str
     * @return boolean
     */
    public static boolean isPhone(String str){
        if(isNotEy(str)) return str.matches(phoneRegx);
        else return false;
    }



}
