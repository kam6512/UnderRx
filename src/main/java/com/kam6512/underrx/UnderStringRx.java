package com.kam6512.underrx;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import io.reactivex.Observable;

import java.text.Normalizer;
import java.util.List;

public class UnderStringRx {

    private static final String nonWordsReg = "[\\W\\_]+";
    private static final String non = "";
    private static final String spaceReg = "\\s";
    private static final String space = " ";
    private static final String upper = "(\\p{Ll})(\\p{Lu})";
    private static final String upperGroup = "$1 $2";


    public Observable<String> camelCase(String source) {
        return lowerCase(source)
//                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> replaceSpaceWithUpperCase(new StringBuilder(string)).toString())
                .map(string -> string.replaceAll(spaceReg, non));
    }

    public Observable<String> kebabCase(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.replaceAll(upper, upperGroup))
                .map(string -> string.replaceAll(nonWordsReg, space))
                .map(String::trim)
                .map(string -> replaceSpaceWithLowerCase(new StringBuilder(string)).toString())
                .map(string -> string.replaceAll(spaceReg, "-"))
                .map(string -> string.substring(0, 1).toUpperCase().concat(string.substring(1)))
                .map(String::toLowerCase);
    }

    public Observable<String> snakeCase(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.replaceAll(upper, upperGroup))
                .map(string -> string.replaceAll(nonWordsReg, space))
                .map(String::trim)
                .map(string -> replaceSpaceWithLowerCase(new StringBuilder(string)).toString())
                .map(string -> string.replaceAll(spaceReg, "_"))
                .map(string -> string.substring(0, 1).toUpperCase().concat(string.substring(1)))
                .map(String::toLowerCase);
    }

    public Observable<String> startCase(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.replaceAll(upper, upperGroup))
                .map(string -> string.replaceAll(nonWordsReg, space))
                .map(String::trim)
                .map(string -> replaceSpaceWithUpperCase(new StringBuilder(string)).toString())
                .map(string -> string.substring(0, 1).toUpperCase() + string.substring(1));
    }


    private static StringBuilder replaceSpaceWithUpperCase(StringBuilder source) {
        for (int i = -1; (i = source.indexOf(space, i + 1)) != -1; i++) {
            source.setCharAt(i + 1, Character.toUpperCase(source.charAt(i + 1)));
        }
        return source;
    }

    private static StringBuilder replaceSpaceWithLowerCase(StringBuilder source) {
        for (int i = -1; (i = source.indexOf(space, i + 1)) != -1; i++) {
            source.setCharAt(i + 1, Character.toLowerCase(source.charAt(i + 1)));
        }
        return source;
    }

    public Observable<String> upperFirst(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(String::trim)
                .map(string -> string.substring(0, 1).toUpperCase() + string.substring(1));
    }


    public Observable<String> lowerFirst(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(String::trim)
                .map(string -> string.substring(0, 1).toLowerCase() + string.substring(1));
    }


    public Observable<String> upperCase(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.replaceAll(upper, upperGroup))
                .map(string -> string.replaceAll(nonWordsReg, space))
                .map(String::trim)
                .map(String::toUpperCase);
    }

    public Observable<String> lowerCase(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.replaceAll(upper, upperGroup))
                .map(string -> string.replaceAll(nonWordsReg, space))
                .map(String::trim)
                .map(String::toLowerCase);
    }

    public Observable<String> capitalize(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(String::trim)
                .map(String::toLowerCase)
                .map(string -> string.substring(0, 1).toUpperCase().concat(string.substring(1)));
    }

    public Observable<String> deburr(String source) {
        final String regex = "\\p{InCombiningDiacriticalMarks}+";
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> Normalizer.normalize(string, Normalizer.Form.NFD))
                .map(normalized -> normalized.replaceAll(regex, non));
    }

    public Observable<String> repeat(String source, int repeatCount) {
        return Observable.just(source).repeat(repeatCount).scan(String::concat).takeLast(1);
    }


    public Observable<List<String>> splitToList(String source, String splitBy, int takeCount) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.split(splitBy))
                .map(Lists::newArrayList)
                .map(strings -> strings.subList(0, takeCount));
    }


    public Observable<String> trimStart(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.replaceAll("^\\s+", non));
    }

    public Observable<String> trimEnd(String source) {
        return Observable.just(source)
                .filter(string-> !Strings.isNullOrEmpty(string))
                .map(string -> string.replaceAll("\\s+$", non));
    }


    public Observable<List<String>> word(String source) {
        return Observable.just(source)
                .filter(string -> !Strings.isNullOrEmpty(string))
                .map(string -> string.split("\\W+"))
                .map(Lists::newArrayList);
    }
}
