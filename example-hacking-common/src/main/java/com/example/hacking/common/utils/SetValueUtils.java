package com.example.hacking.common.utils;

import com.example.hacking.common.annotation.SetValue;
import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Properties;

/**
 * @author jintingying
 * @version 1.0
 * @date 2019/10/12
 */
@Data
public class SetValueUtils {

    /**
     * @param key
     * @return java.lang.String
     * @方法说明 根据Key值 获取properties文件的值
     */
    private static String getValue(String key) {
        String propertiesFilePath = "E:\\devlopment_project\\example-hacking-parent\\example-hacking-module\\src\\main\\resources\\application.properties";
        String value = "";

        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(propertiesFilePath);
            properties.load(new InputStreamReader(in, "utf-8"));
            if (key == null || "".equals(key)) {
                throw new NullPointerException("key值为空");
            }
            value = properties.getProperty(key);

            System.out.println(value + value );

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return value;
        }
    }

    /**
     * @param obj
     * @return void
     * @方法说明
     */
    public static void setValue(Object obj) throws Exception {
        Class<?> clz = obj.getClass();
        // 解析字段上是否有注解
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            //有SetValue注解时
            boolean fieldHasAnno = field.isAnnotationPresent(SetValue.class);
            if (fieldHasAnno) {
                SetValue valueAnnoation = field.getAnnotation(SetValue.class);
                // 获取注解的值
                String value = valueAnnoation.value();
                // 通过注解设置的值获取properties的值
                String propertiedValue = Objects.requireNonNull(getValue(value));
                // 获取属性的名字
                String name = field.getName();
                // 将属性的首字符大写， 构造get，set方法
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                // 获取属性的类型
                String type = field.getGenericType().toString();
                // 如果type是类类型，则前面包含"class "，后面跟类名
                // String 类型
                if (type.equals("class java.lang.String")) {
                    Method m = clz.getMethod("set" + name, String.class);
                    // invoke方法传递实例对象，因为要对实例处理，而不是类
                    m.invoke(obj, propertiedValue);
                }
                // int Integer类型
                if (type.equals("class java.lang.Integer")) {
                    Method m = clz.getMethod("set" + name, Integer.class);
                    m.invoke(obj, Integer.parseInt(propertiedValue));
                }
                if (type.equals("int")) {
                    Method m = clz.getMethod("set" + name, int.class);
                    m.invoke(obj, (int) Integer.parseInt(propertiedValue));
                }
                // boolean Boolean类型
                if (type.equals("class java.lang.Boolean")) {
                    Method m = clz.getMethod("set" + name, Boolean.class);
                    if (propertiedValue.equalsIgnoreCase("true")) {
                        m.invoke(obj, true);
                    }
                    if (propertiedValue.equalsIgnoreCase("false")) {
                        m.invoke(obj, true);
                    }
                }
                if (type.equals("boolean")) {
                    Method m = clz.getMethod("set" + name, boolean.class);
                    if (propertiedValue.equalsIgnoreCase("true")) {
                        m.invoke(obj, true);
                    }
                    if (propertiedValue.equalsIgnoreCase("false")) {
                        m.invoke(obj, true);
                    }
                }
                // long Long 数据类型
                if (type.equals("class java.lang.Long")) {
                    Method m = clz.getMethod("set" + name, Long.class);
                    m.invoke(obj, Long.parseLong(propertiedValue));
                }
                if (type.equals("long")) {
                    Method m = clz.getMethod("set" + name, long.class);
                    m.invoke(obj, Long.parseLong(propertiedValue));
                }
                // 时间数据类型
                if (type.equals("class java.util.Date")) {
//                    Method m = clz.getMethod("set" + name, java.util.Date.class);
//                    m.invoke(obj, DataConverter.convert(propertiedValue));
                }
            }
        }

    }
}
