package com.example;

/**
 * Created by yuliang on 2017/5/17.
 * 黑屋子，平安夜
 * T 代表着电影
 *
 */

public class Observable <T> {
    private OnSubscrible<T> onSubscrible;

    public  Observable(OnSubscrible<T> onSubscrible) {
        this.onSubscrible = onSubscrible;
    }

    public static <T> Observable create(OnSubscrible<T> onSubscrible){
        return new Observable(onSubscrible);

    }
    public void subscrible(Subscrilble<? super T> subscrible){
        onSubscrible.call(subscrible);
    }
    public <R> Observable<R> map(Func1 <? super  T, ? extends  R> func1){
        return new Observable<R>(new OnSubscribleLift<T,R>(onSubscrible,func1));
    }
    public Observable<T> subscriOnIO(){
        return create(new OnSubscribleThread<T>(this));
    }
}

