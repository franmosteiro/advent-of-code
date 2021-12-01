package io.franmosteiro.aoc2020.utils

fun <T> List<T>.allDuples(): Sequence<Pair<T, T>> = sequence {
    for (i in 0..lastIndex) {
        for (j in i+1..lastIndex) {
            yield(get(i) to get(j))
        }
    }
}

fun <T> List<T>.allTriples(): Sequence<Triple<T, T, T>> = sequence {
    for (i in 0..lastIndex) {
        for (j in i+1..lastIndex) {
            for (k in j+1..lastIndex) {
                yield(Triple(get(i), get(j), get(k)))
            }
        }
    }
}