package com.kam6512.underrx;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * UnderRx is a java port of "Array" in Lodash
 *
 * @author kam6512
 */
public class UnderArrayRx {

    public Observable<List<? extends List<?>>> chunk(List<?> list, int size) {
        return Observable.create(emitter -> {
            if (checkList(list)) {
                emitter.onNext(Lists.newArrayList());
                emitter.onComplete();
                return;
            }
            emitter.onNext(Lists.partition(list, size));
            emitter.onComplete();
        });
    }

    public Observable<List<Integer>> compactInteger(List<Integer> list) {
        return Observable.create(emitter -> {
            if (checkList(list)) {
                emitter.onNext(Lists.newArrayList());
                emitter.onComplete();
                return;
            }
            ArrayList<Integer> result = Lists.newArrayList(list);
            result.removeIf(item -> item == 0);
            emitter.onNext(result);
            emitter.onComplete();
        });
    }

    public Observable<List<Float>> compactFloat(List<Float> list) {
        return Observable.create(emitter -> {
            if (checkList(list)) {
                emitter.onNext(Lists.newArrayList());
                emitter.onComplete();
                return;
            }
            ArrayList<Float> result = Lists.newArrayList(list);
            result.removeIf(item -> item == 0f);
            emitter.onNext(result);
            emitter.onComplete();
        });
    }

    public Observable<List<String>> compactString(List<String> list) {
        return Observable.create(emitter -> {
            if (checkList(list)) {
                emitter.onNext(Lists.newArrayList());
                emitter.onComplete();
                return;
            }
            ArrayList<String> result = Lists.newArrayList(list);
            result.removeIf(Strings::isNullOrEmpty);
            emitter.onNext(result);
            emitter.onComplete();
        });
    }

    // concat is passed -> use add or addAll

    public Observable<List<Integer>> diff(List<Integer> diffList, List<Integer> filterList) {
        return Observable.create(emitter -> {
            if (checkList(diffList) || checkList(filterList)) {
                emitter.onNext(Lists.newArrayList());
                emitter.onComplete();
                return;
            }
            ArrayList<Integer> result = Lists.newArrayList(diffList);
            result.removeAll(filterList);
            emitter.onNext(result);
            emitter.onComplete();
        });
    }

    public Observable<List<?>> drop(List<?> list) {
        return drop(list, 1);
    }

    public Observable<List<?>> drop(List<?> list, int count) {
        return Observable.create(emitter -> {
            if (checkList(list)) {
                emitter.onNext(Lists.newArrayList());
                emitter.onComplete();
                return;
            }
            ArrayList<?> result = Lists.newArrayList(list);
            result.subList(count,  list.size());
            emitter.onNext(result);
            emitter.onComplete();
        });
    }

    public Observable<List<?>> dropRight(List<?> list) {
        return dropRight(list, 1);
    }

    public Observable<List<?>> dropRight(List<?> list, int count) {
        return Observable.create(emitter -> {
            if (checkList(list)) {
                emitter.onNext(Lists.newArrayList());
                emitter.onComplete();
                return;
            }
            ArrayList<?> result = Lists.newArrayList(list);
            int subLength = list.size() - count;
            result.subList(0, subLength);
            emitter.onNext(result);
            emitter.onComplete();
        });
    }

    private static boolean checkList(List list) {
        return (list == null || list.isEmpty());
    }
}
