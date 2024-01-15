package org.example.rxjava3

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Executors

fun main() {

    Observable.just(40)
        .subscribe {
            println("Thread ${Thread.currentThread().id} $it")
        }

    Observable.just(55)
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation())

        .flatMap {
            println("Thread ${Thread.currentThread().name} flatMap")
            Observable.just(it.toString())
        }
//        .observeOn(Schedulers.computation())
//        .subscribeOn(Schedulers.from(Executors.newSingleThreadExecutor()))
        .subscribe {
            println("Thread ${Thread.currentThread().name} $it")
        }
}