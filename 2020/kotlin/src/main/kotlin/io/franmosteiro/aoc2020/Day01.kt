package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.*

/**
 * Advent of Code 2020 - Day 1: Report Repair -
 * Problem Description: http://adventofcode.com/2020/day/1
 */
class Day01(input: List<String>) {

    private val listOfReports: List<Int> = input.map { it.toInt() }

    fun resolvePartOne(): Int {
        listOfReports.allDuples().forEach {
            if (it.first + it.second == 2020) return it.first * it.second
        }
        throw IllegalStateException("No matches found")
    }

    fun resolvePartTwo(): Int {
        listOfReports.allTriples().forEach {
            if (it.first + it.second + it.third == 2020) return it.first * it.second * it.third
        }
        throw IllegalStateException("No matches found")
    }
}

