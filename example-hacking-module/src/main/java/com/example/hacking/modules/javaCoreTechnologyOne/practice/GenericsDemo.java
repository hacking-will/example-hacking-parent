package com.example.hacking.modules.javaCoreTechnologyOne.practice;

import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/21
 */
public class GenericsDemo<E> {

    public <T> Map<String, Object> getObject(Class<T> t1, Class<E> e1) throws IllegalAccessException, InstantiationException {
        T t = t1.newInstance();
        E e = e1.newInstance();
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put(t.getClass().getName(), t);
        resultMap.put(e.getClass().getName(), e);
        return resultMap;
    }
}
