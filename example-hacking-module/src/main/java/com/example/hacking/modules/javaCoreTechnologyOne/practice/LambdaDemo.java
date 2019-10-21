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
public class LambdaDemo {

    public int opt(int a, int b, MathOpt opt){
        return opt.twoParam(a, b);
    }

    public interface MathOpt{
        int twoParam(int a, int b);
    }
}
