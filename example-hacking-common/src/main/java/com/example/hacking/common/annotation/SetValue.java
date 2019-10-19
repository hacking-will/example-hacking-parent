package com.example.hacking.common.annotation;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.*;
import java.util.Properties;

/**
 * 注解的使用练习: 自定义类似@Value 获取properties的值然后初始化给字段属性
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/12
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SetValue {
    //注解的属性也叫做成员变量
    //以“无形参的方法”形式来声明
    String value();

    Type tag() default Type.STRING;

    enum Type {
        NUMBER, STRING, DATE
    }

}

