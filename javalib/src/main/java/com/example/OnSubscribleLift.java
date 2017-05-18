package com.example;

/**
 * Created by yuliang on 2017/5/18.
 * 好兄弟借xf，没问题，先借你十天半月
 * xf不同意，就打算把gm借给他
 * gm最后跟ns看kaifang了
 * T 好兄弟
 * R gm
 */

public class OnSubscribleLift<T,R> implements OnSubscrible<R>{
    //man
    OnSubscrible<T> boy;
    private Func1<? super T,? extends R> transfromer;

    public OnSubscribleLift(OnSubscrible<T> boy, Func1<? super T, ? extends R> transfromer) {
        this.boy = boy;
        this.transfromer = transfromer;
    }

    /**
     * 想看电影的女生传进去
     *
     * */

    @Override
    public void call(Subscrilble<? super R> subscrilble) {
        Subscrilble<? super T> wifi = new OperaChangge<>(subscrilble,transfromer);
        boy.call(wifi);
    }

    //他媳妇
    class OperaChangge<T,R> extends Subscrilble<T>{
        Subscrilble<? super  R> actual;
        private  Func1<? super T,? extends R> transform;

        public OperaChangge(Subscrilble<? super R> actual, Func1<? super T, ? extends R> transform) {
            this.actual = actual;
            this.transform = transform;
        }

        @Override
        public void onNext(T t) {
            /**
             * 自己替换闺蜜
            *
            * */

            R r = this.transform.call(t);
            actual.onNext(r);

        }
    }
}
