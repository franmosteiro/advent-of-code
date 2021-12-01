package io.franmosteiro.aoc2020

/**
 * Advent of Code 2020 - Day 2: Password Philosophy -
 * Problem Description: http://adventofcode.com/2020/day/2
 */
class Day02(listOfPasswords: List<String>) {

    private val parsedOcurrences = listOfPasswords.map{ line ->
        val (ocurrences, keyChar, password) = line.split(" ")
        val (first, last) = ocurrences.split("-").map { it.toInt() }
        Ocurrence(first, last, keyChar.first(), password)
    }

    fun resolvePartOne(): Int {
        return parsedOcurrences.count{ ocurrence ->
            ocurrence.password.count { it == ocurrence.keyChar } in ocurrence.first..ocurrence.last
        }
    }

    fun resolvePartTwo(): Int {
        return parsedOcurrences.count{ ocurrence ->
            val (isInFirst, isInLast) = (ocurrence.password[ocurrence.first - 1] == ocurrence.keyChar) to
                    (ocurrence.password[ocurrence.last - 1] == ocurrence.keyChar)
            isInFirst xor isInLast
        }
    }

    private data class Ocurrence(val first: Int, val last: Int, val keyChar: Char, val password: String)
}

