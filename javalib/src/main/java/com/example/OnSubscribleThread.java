package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuliang on 2017/5/18.
 */

public class OnSubscribleThread<T> implements OnSubscrible<T>{
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    Observable<T> source;

    public OnSubscribleThread(Observable<T> source) {
        this.source = source;
    }

    @Override
    public void call(Subscrilble<? super T> subscrilble) {
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                source.subscrible(subscrilble);
            }
        };
        executorService.submit(runnable);
    }


}
