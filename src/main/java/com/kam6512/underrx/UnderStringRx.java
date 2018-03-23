package com.kam6512.underrx;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnderStringRx {

    private static String nonWordsReg = "[\\W\\_]+";
    private static String non = "";
    private static String spaceReg = "\\s";
    private static String space = " ";
    private static String upper = "(\\p{Ll})(\\p{Lu})";
    private static String upperGroup = "$1 $2";


    public Observable<String> camelCase(String source) {
        return lowerCase(source)
                .map(string -> replaceSpaceWithUpperCase(new StringBuilder(string)).toString())
                .map(string -> string.replaceAll(spaceReg, non));
    }

    public Observable<String> capitalize(String source) {
        return Observable.just(source)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(string -> string.substring(0, 1).toUpperCase() + string.substring(1));
    }

    public Observable<String> deburr(String source) {
        String regex = "\\p{InCombiningDiacriticalMarks}+";
        return Observable.just(source)
                .map(string -> Normalizer.normalize(string, Normalizer.Form.NFD))
                .map(normalized -> normalized.replaceAll(regex, non));
    }

    // endsWith is passed -> use String.endsWith
    // escape / escapeRegExp use Apache Lang3

    public Observable<String> kebabCase(String source) {
        return Observable.just(source)
                .map(string -> string.replaceAll(upper, upperGroup))
                .map(string -> string.replaceAll(nonWordsReg, space))
                .map(String::trim)
                .map(string -> replaceSpaceWithLowerCase(new StringBuilder(string)).toString())
                .map(string -> string.replaceAll(spaceReg, "-"))
                .map(string -> string.substring(0, 1).toLowerCase() + string.substring(1))
                .map(String::toLowerCase);
    }

    public Observable<String> lowerCase(String source) {
        return Observable.just(source)
                .map(string -> string.replaceAll(upper, upperGroup))
                .map(string -> string.replaceAll(nonWordsReg, space))
                .map(String::trim)
                .map(String::toLowerCase);
    }

    public Observable<String> lowerFirst(String source) {
        return Observable.just(source)
                .map(String::trim)
                .map(string -> string.substring(0, 1).toLowerCase() + string.substring(1));
    }

    private static StringBuilder replaceSpaceWithUpperCase(StringBuilder source) {
        for (int i = -1; (i = source.indexOf(" ", i + 1)) != -1; i++) {
            source.setCharAt(i + 1, Character.toUpperCase(source.charAt(i + 1)));
        }
        return source;
    }

    private static StringBuilder replaceSpaceWithLowerCase(StringBuilder source) {
        for (int i = -1; (i = source.indexOf(" ", i + 1)) != -1; i++) {
            source.setCharAt(i + 1, Character.toLowerCase(source.charAt(i + 1)));
        }
        return source;
    }
}
