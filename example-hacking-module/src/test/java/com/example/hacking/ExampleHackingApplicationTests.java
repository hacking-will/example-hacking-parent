package com.example.hacking;

import com.example.hacking.modules.javaCoreTechnologyOne.practice.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleHackingApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void tets() {
        CalendarDemo asa = new CalendarDemo();
        asa.showCalendarOfDay(LocalDate.now());
        asa.showCalendarOfDay(LocalDate.of(1999, 9, 26));
    }

    @Test
    public void test2() {
        int size = 10;
        int arr[] = new int[size];

        ArrayList<Integer> arrList = new ArrayList();
    }

    @Test
    public void test3() {
        GenericsDemo<gdas> demo = new GenericsDemo<>();

        Map<String, Object> map = null;
        try {
            map = demo.getObject(CalendarDemo.class, gdas.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(map.get("CalendarDemo"));
        System.out.println(map.get("gdas") );
    }

    @Test
    public void test4() {
        System.out.println(new VNOfParameters().max(121.0, 12,122,98));//122.0
        Integer i = 0;
        //一个 Class 对象实际上表示的是一个类型，而这个类型未必一定是一种类
        Class ci = int.class;
        Class cl = i.getClass();
        System.out.println(ci); //int
        System.out.println(cl); //class java.lang.Integer
    }

    @Test
    public void lambdaDemo() {

        LambdaDemo lambdaDemo = new LambdaDemo();
        LambdaDemo.MathOpt add = (a, b)-> a+b;
        LambdaDemo.MathOpt sub = (int a, int b)-> a-b;
        LambdaDemo.MathOpt mul = (a, b)->{return a*b;};

        System.out.println(lambdaDemo.opt(5,2,add));
        System.out.println(lambdaDemo.opt(5,2,sub));
        System.out.println(lambdaDemo.opt(5,2,mul));

    }
}
