package com.example.hacking.modules.javaCoreTechnologyOne.practice;

/**
 * <p>
 *
 * </p>
 *
 * @author jintingying
 * @version 1.0
 * @date 2019/10/21
 */
public class VNOfParameters {

    public  static double max (double... values){
        double large  = Double.NEGATIVE_INFINITY;
        for(double v : values) large = v > large ? v : large;
        return large;
    }
}
