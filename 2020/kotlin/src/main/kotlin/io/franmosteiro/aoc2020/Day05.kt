package io.franmosteiro.aoc2020

/**
 * Advent of Code 2020 - Day 5: Binary Boarding -
 * Problem Description: http://adventofcode.com/2020/day/5
 */
class Day05(input: List<String>) {

    private val seatsList = input

    val rowFactorRange = (1..128 * 8)

    private fun takenSeatsList(): List<Int> {

        var row: Int
        var column: Int

        return seatsList.map { seat ->
            val translatedSeats = seat
                    .replace("[FL]".toRegex(), "0")
                    .replace("[BR]".toRegex(), "1")

            row = translatedSeats.take(7).toInt(2)
            column = translatedSeats.takeLast(3).toInt(2)

            row * 8 + column
        }

    }

    fun resolvePartOne(): Int = takenSeatsList().maxOrNull() ?: 0

    fun resolvePartTwo(): Int = takenSeatsList().let { takenSeat ->
        rowFactorRange.first {
                !takenSeat.contains(it) &&
                        (takenSeat.contains(it - 1) && takenSeat.contains(it + 1)) }
        }

}

