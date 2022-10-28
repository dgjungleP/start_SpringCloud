package com.jungle.cloud;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.junit.Test;
import rx.Emitter;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

@Slf4j
public class TestRxJava {


    @Test
    public void simpleRxJava() {
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Apple");
            emitter.onNext("Banana");
            emitter.onNext("Pear");
            emitter.onCompleted();
        }, Emitter.BackpressureMode.NONE);

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                log.info("On completed");
            }

            @Override
            public void onError(Throwable e) {
                log.info("On error");
            }

            @Override
            public void onNext(String s) {
                log.info("On next:{}", s);
            }
        };
        observable.subscribe(subscriber);
        observable.subscribe(subscriber);

    }

}
