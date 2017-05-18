package com.example;

import sun.jvm.hotspot.utilities.BitMap;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("threadName:"+Thread.currentThread().getName());
        send3();
    }
    public static void send(){
         Observable.create(new OnSubscrible<String>() {
               @Override
             public void call(Subscrilble<? super String> subscrilble) {
                 subscrilble.onNext("走: 看电影");
             }
         }).subscrible(new Subscrilble<String>() {
             @Override
             public void onNext(String o) {
                 System.out.println("通知:"+o);
                 System.out.println("可以一起看电影");
             }
         });
    }
    /**
     *
     * String 代表看电影
     * 不关心兄弟把lp给他，他老婆怎么样把闺蜜给他的
     * bitMap 代表开发
     * url 转bitMap
     *
     * */
    public static void send2(){
        Observable.create(new OnSubscrible<String>() {

            @Override
            public void call(Subscrilble<? super String> subscrilble) {
                subscrilble.onNext("男生看电影");
            }
        }).map(new Func1<String,BitMap>() {

            @Override
            public BitMap call(String s) {
                System.out.println(s);
                System.out.println("---老婆不愿意去开发");
                return null;
            }
        }).subscrible(new Subscrilble<BitMap>() {

            @Override
            public void onNext(BitMap bitMap) {
                System.out.println("bitmap:"+bitMap);
                System.out.println("开发女生，走，开发去。");
            }
        });
    }

    /**
     *
     * String 代表看电影
     * 不关心兄弟把lp给他，他老婆怎么样把闺蜜给他的
     * bitMap 代表开发
     * url 转bitMap
     *
     * */
    public static void send3(){
        Observable.create(new OnSubscrible<String>() {
            @Override
            public void call(Subscrilble<? super String> subscrilble) {
                subscrilble.onNext("男生看电影");
                System.out.println("threadName:"+Thread.currentThread().getName());
            }
        }).map(new Func1<String,BitMap>() {

            @Override
            public BitMap call(String s) {
                System.out.println(s);
                System.out.println("---老婆不愿意去开发");
                return null;
            }
        }).subscriOnIO().subscrible(new Subscrilble<BitMap>() {

            @Override
            public void onNext(BitMap bitMap) {
                System.out.println("bitmap:"+bitMap);
                System.out.println("开发女生，走，开发去。");
            }
        });
    }
}
