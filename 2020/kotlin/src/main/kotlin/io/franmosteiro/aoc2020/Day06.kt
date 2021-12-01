package io.franmosteiro.aoc2020

/**
 * Advent of Code 2020 - Day 6: Custom Customs -
 * Problem Description: http://adventofcode.com/2020/day/6
 */
class Day06(input: String) {

    private val answers = input.split("\n\n").map {
        it.split("\n").filter(String::isNotBlank).map(String::toSet)
    }

    fun resolvePartOne(): Int = answers.sumBy {
        it.reduce { a, b -> a.union(b) }.size
    }

    fun resolvePartTwo(): Int = answers.sumBy {
        it.reduce { a, b -> a.intersect(b) }.size
    }

}

