package com.example.hacking.modules.javaCoreTechnologyOne.practice;

import org.apache.poi.ss.formula.functions.T;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/21
 */
public interface InterfaceDemo<T> {
    int a = 0; // final

    static int sset(int sa){
        return sa;
    }
    default int gget(){return 0;}

    T com(T coms);
}
