package com.jiaheqi.jiaheqiorder;

public class test {

    public void test1(){


    }

    public static void main(String[] args) {
        int m = 1;
        int n = 1;
        System.out.println(m==n);
        System.out.println(m.equals(n));
//        String str1 = "hello";
//        String str2 = "hello";
//        System.out.println(str1==str2);

        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));

//        String str = new String("hello");
//        String str5 = str;
//        System.out.println(str==str5);
//        System.out.println(str.equals(str5));
    }
}
