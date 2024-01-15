package org.example.rxjava3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Rxjava3Application {
    public static void main(String[] args) {
        String abc = null;
        System.out.println("System".equals(abc));

        Observable
                .range(1, 20)
                .subscribe(System.out::println);

        var subject = PublishSubject.create();
        subject.onNext(1);
    }
}
