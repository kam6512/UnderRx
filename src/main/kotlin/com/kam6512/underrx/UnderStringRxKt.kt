package com.kam6512.underrx

import com.google.common.base.Strings
import io.reactivex.Observable

open class UnderStringRxKt {

    private val nonWordsReg: Regex = "[\\W\\_]+".toRegex()
    private val non: String = ""
    private val spaceReg: Regex = "\\s".toRegex()
    private val space: String = " "
    private val upper: Regex = "(\\p{Ll})(\\p{Lu})".toRegex()
    private val upperGroup: String = "$1 $2"


    fun camelCase(source: String): Observable<String> {
        return lowerCase(source)
                .map { replaceSpaceWithUpperCase(StringBuilder(it)).toString() }
                .map { it.replace(spaceReg, non) }
    }

    fun kebabCase(source: String): Observable<String> {
        return Observable.just(source)
                .filter { !Strings.isNullOrEmpty(it) }
                .map { it.replace(upper, upperGroup) }
                .map { it.replace(nonWordsReg, space) }
                .map { it.trim() }
                .map { replaceSpaceWithLowerCase(StringBuilder(it)).toString() }
                .map { it.replace(spaceReg, "-") }
                .map { it.substring(0, 1).toUpperCase().plus(it.substring(1)) }
                .map { it.toLowerCase() }
    }

    fun snakeCase(source: String): Observable<String> {
        return Observable.just(source)
                .filter { !Strings.isNullOrEmpty(it) }
                .map { it.replace(upper, upperGroup) }
                .map { it.replace(nonWordsReg, space) }
                .map { it.trim() }
                .map { replaceSpaceWithLowerCase(StringBuilder(it)).toString() }
                .map { it.replace(spaceReg, "_") }
                .map { it.substring(0, 1).toUpperCase().plus(it.substring(1)) }
                .map { it.toLowerCase() }
    }

    fun startCase(source: String): Observable<String> {
        return Observable.just(source)
                .filter { !Strings.isNullOrEmpty(it) }
                .map { it.replace(upper, upperGroup) }
                .map { it.replace(nonWordsReg, space) }
                .map { it.trim() }
                .map { replaceSpaceWithUpperCase(StringBuilder(it)).toString() }
                .map { it.substring(0, 1).toUpperCase().plus(it.substring(1)) }
    }

    private fun replaceSpaceWithUpperCase(source: StringBuilder): StringBuilder {
        var i = source.indexOf(space, 0)

        while (i != -1) {
            source.setCharAt(i + 1, Character.toUpperCase(source[i + 1]))
            i++
            i = source.indexOf(space, i + 1)
        }
        return source
    }

    private fun replaceSpaceWithLowerCase(source: StringBuilder): StringBuilder {
        var i = source.indexOf(space, 0)
        while (i != -1) {
            source.setCharAt(i + 1, Character.toLowerCase(source[i + 1]))
            i++
            i = source.indexOf(space, i + 1)
        }
        return source
    }

    fun upperFirst(source: String): Observable<String> {
        return Observable.just(source)
                .filter { !Strings.isNullOrEmpty(it) }
                .map { it.trim() }
                .map { it.substring(0, 1).toUpperCase().plus(it.substring(1)) }
    }

    fun lowerFirst(source: String): Observable<String> {
        return Observable.just(source)
                .filter { !Strings.isNullOrEmpty(it) }
                .map { it.trim() }
                .map { it.substring(0, 1).toLowerCase().plus(it.substring(1)) }
    }

    fun upperCase(source: String): Observable<String> {
        return Observable.just(source)
                .filter { !Strings.isNullOrEmpty(it) }
//                .map {  }
    }

    fun lowerCase(source: String): Observable<String> {
        return Observable.just(source)
                .filter { !Strings.isNullOrEmpty(it) }
                .map { it.replace(upper, upperGroup) }
                .map { it.replace(nonWordsReg, space) }
                .map { it.trim() }
                .map { it.toLowerCase() }
    }

}