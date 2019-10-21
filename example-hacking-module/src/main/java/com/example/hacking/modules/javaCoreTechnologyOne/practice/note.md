
#### 2019-10-21
## 类关系：依赖/聚合/继承
+ 依赖：如果一个类的方法操纵另一个类的对象，我们就说一个类依赖于另一个类。
> 应该尽可能地将相互依赖的类减至最少，用软件工程的术语来说，就是让类之间的耦合度最小。
+ 聚合：聚合关系意味着类 A 的对象包含类 B 的对象。

## UTC
>时间是用距离一个固定时间点的毫秒数（可正
可负） 表示的， 这个点就是所谓的纪元（ epoch), 它 是 UTC 时间 1970 年 1 月 1 日 00:00:00。
UTC 是 Coordinated Universal Time 的缩写，与大家熟悉的 GMT ( 即 Greenwich Mean Time,
格林威治时间）一样，是一种具有实践意义的科学标准时间。

## Date 与 LocalDate
>类库设计者决定将保存时间与给时间点命名分开。所以标准 Java 类库分别包含了两个类：
一个是用来表示时间点的 Date 类；另一个是用来表示大家熟悉的日历表示法的 LocalDate 类。

## 运行时确定数组大小特性与泛型数组列表
```
int size = 0;
int arr[] = new int[size];
ArrayList<Integer> arrList = new Arraylist();
```

#### 自定义泛型类（接口）、方法
```
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
```

## 装箱 与 拆箱
```
ArrayList<int> arrList = new Arraylist(); // error
ArrayList<Integer> arrList = new Arraylist();
```
>有时， 需要将 int 这样的基本类型转换为对象。所有的基本类型都冇一个与之对应的类。
例如，Integer 类对应基本类型 int。通常， 这些类称为包装器 （ wrapper ) 这些对象包装器类
拥有很明显的名字：Integer、Long、Float、Double、Short、Byte、Character 、Void 和 Boolean (前 6 个类派生于公共的超类 Number)。对象包装器类是不可变的，即一旦构造了包装器，就不
允许更改包装在其中的值

>装箱和拆箱是编译器认可的，而不是虚拟机

## 参数数量可变
```
public static double max (double... values){
        double large  = Double.NEGATIVE_INFINITY;
        for(double v : values) large = v > large ? v : large;
        return large;
    }
```
> 最后一个；可传入数组；

## 反射
+ 运行时分析类的能力
+ 运行时查看对象
+ 实现通用的数组操作代码
+ 利用Method对象（很像C++中的函数指针）
#### Class类
```
Integer i = 0;
//一个 Class 对象实际上表示的是一个类型，而这个类型未必一定是一种类
Class ci = int.class;
Class cl = i.getClass();
```
>鉴于历史原 getName 方法在应用于数组类型的时候会返回一个很奇怪的名字：

>•Double[ ] class.getName( ) 返回“ [Ljava.lang.Double;’’

>•int[ ].class.getName( ) 返回“ [I ” ，


## 接口
 > interface  / implements
```
public interface InterfaceDemo<T> {
    int a = 0; // final

    static int sset(int sa){
        return sa;
    }
    default int gget(){return 0;}

    T com(T coms);
}
```

## 对象克隆 —— Cloneable接口


## lambda
Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。

Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
```
(parameters) -> expression
或
(parameters) ->{ statements; }
```
lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。

>lambda表达式可以方便我们使用(边实现边用)接口中定义的方法

## assert 断言

`assert 3 / 0 == 1`


##
> 在Java 程序设计语言中，所有链表实际上都是双向链接的(doubly linked)—即每个结点还存放着指向前驱结点的引用