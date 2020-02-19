package com.example.justs.demo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test();
    }

    private void test(){


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.d(TAG,"subscribe 1");
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"onSubscribe 1 Disposable: " + d);
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.d(TAG,"onNext 1 value: " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"onError 1 ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG,"onComplete 1");
                    }
                });

        Observable.just("1","2","3","4")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"onSubscribe 2 Disposable: " + d);
            }

            @Override
            public void onNext(String value) {
                Log.d(TAG,"onNext 2 value: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError 2 ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"onComplete 2");
            }
        });

        int[] a = {1,2,3,4};
        Observable.fromArray(a)
        .observeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<int[]>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"onSubscribe 3 Disposable: " + d);
            }

            @Override
            public void onNext(int[] value) {
                Log.d(TAG,"onNext 2 value: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError 3 ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"onComplete 3");
            }
        });

        Observable.just("123")
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String s) throws Exception {
                        return null;
                    }
                })
                .map(new Function<Bitmap, String>() {
                    @Override
                    public String apply(Bitmap bitmap) throws Exception {
                        return null;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });

        Observable.just("1", "2")
                .distinct()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s != null;
                    }
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                });

        Observable.interval(3,2,TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        Observable.just("1","2","3","2")
                .skip(1)
                .take(8)
                .distinct()
                .debounce(500,TimeUnit.MILLISECONDS)
                .scan(new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String s, String s2) throws Exception {
                        return null;
                    }
                })
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return false;
                    }
                })
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        Observable.just("")
                .flatMap(new Function<String, ObservableSource<Object>>() {
                    @Override
                    public ObservableSource<Object> apply(String s) throws Exception {
                        return null;
                    }
                })
                .flatMap(new Function<Object, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Object o) throws Exception {
                        return null;
                    }
                }).map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) throws Exception {
                        return null;
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {

                    }
        });

    }



}
