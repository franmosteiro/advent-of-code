package io.franmosteiro.aoc2020

/**
 * Advent of Code 2020 - Day 9: Encoding Error -
 * Problem Description: http://adventofcode.com/2020/day/9
 */
class Day09(input: List<String>) {

    private val seriesOfNumbers = input.map{ it.toLong() }
    private var invalidNumber = -1
    private val requiredSum: Long = 1398413738

    fun resolvePartOne(preambleBatchSize: Int = 5): Int =
            seriesOfNumbers.windowed(preambleBatchSize + 1, 1)
                .first { !it.isValid() }
                .last()
                .also { invalidNumber = it.toInt() }.toInt()

    fun resolvePartTwo(): Int {
        val slice = contiguousRangeSlice(seriesOfNumbers)
        return (slice.minOrNull()!! + slice.maxOrNull()!!).toInt()
    }

    private fun List<Long>.isValid(): Boolean =
            any { itNumber -> ((last() - itNumber) in this) && (last() != itNumber) && ((last() - itNumber) != itNumber) }

    private fun contiguousRangeSlice(seriesOfNumbers: List<Long>): List<Long> {
        var acc = 0L
        var first = 0
        var second = 0
        while( second < seriesOfNumbers.size) {
            if(acc == requiredSum) {
                return seriesOfNumbers.slice(first..second)
            }
            if(acc > requiredSum) {
                acc -= seriesOfNumbers[first++]
                continue
            }
            acc += seriesOfNumbers[second++]
        }
        error("No slice equal to $requiredSum")
    }
}

