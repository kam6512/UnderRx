package com.kam6512.underrx;

import com.google.common.collect.Iterables;
import com.google.common.collect.Range;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

import java.util.Random;
import java.util.SplittableRandom;

public class UnderNumberRx {

    public Observable<Integer> clamp(int source, int min, int max) {
        return Observable.create(emitter -> {
            if ((min == 0 && max == 0) || min > max) {
                emitter.onComplete();
                return;
            }
            if (min >= source) {
                emitter.onNext(min);
            } else if (max <= source) {
                emitter.onNext(max);
            } else {
                emitter.onNext(source);
            }
            emitter.onComplete();
        });
    }

    public Observable<Long> clamp(long source, long min, long max) {
        return Observable.create(emitter -> {
            if ((min == 0 && max == 0) || min > max) {
                emitter.onComplete();
                return;
            }
            if (min >= source) {
                emitter.onNext(min);
            } else if (max <= source) {
                emitter.onNext(max);
            } else {
                emitter.onNext(source);
            }
            emitter.onComplete();
        });
    }

    public Observable<Boolean> inRange(int source, int end) {
        return inRange(source, 0, end);
    }

    public Observable<Boolean> inRange(int source, int start, int end) {
        return Observable.just(source > start && source < end);
    }

    public Observable<Boolean> inRange(long source, long end) {
        return inRange(source, 0, end);
    }

    public Observable<Boolean> inRange(long source, long start, long end) {
        return Observable.just(source > start && source < end);
    }

    public Observable<Boolean> inRange(double source, double end) {
        return inRange(source, 0, end);
    }

    public Observable<Boolean> inRange(double source, double start, double end) {
        return Observable.just(source > start && source < end);
    }

    public Observable<Integer> random(int count, int end) {
        return random(1, 0, end);
    }

    public Observable<Long> random(int count, long end) {
        return random(1, 0, end);
    }

    public Observable<Double> random(int count, double end) {
        return random(1, 0, end);
    }

    public Observable<Integer> random(int count, int start, int end) {
        if (count <= 0 || start >= end) { return Observable.empty(); }
        return Observable.create(emitter -> getRandomInstance().ints(count, start, end).forEach(emitter::onNext));
    }


    public Observable<Long> random(int count, long start, long end) {
        if (count <= 0 || start >= end) { return Observable.empty(); }
        return Observable.create(emitter -> getRandomInstance().longs(count, start, end).forEach(emitter::onNext));
    }

    public Observable<Double> random(int count, double start, double end) {
        if (count <= 0 || start >= end) { return Observable.empty(); }
        return Observable.create(emitter -> getRandomInstance().doubles(count, start, end).forEach(emitter::onNext));

    }

    public SplittableRandom getRandomInstance() {
        return new SplittableRandom();
    }
}
