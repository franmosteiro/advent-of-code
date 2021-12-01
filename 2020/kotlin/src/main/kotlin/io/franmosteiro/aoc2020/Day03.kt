package io.franmosteiro.aoc2020

import java.awt.Point

/**
 * Advent of Code 2020 - Day 3: Toboggan Trajectory -
 * Problem Description: http://adventofcode.com/2020/day/3
 */
class Day03(list: List<String>) {

    private val listOfPoints = list
    private val gridWidth = listOfPoints.first().length
    private val gridHeight = listOfPoints.size

    fun resolvePartOne(): Long =
            locateTrees(Point(3,1))

    fun resolvePartTwo(): Long {
        return listOf(
                Point(1,1),
                Point(3,1),
                Point(5,1),
                Point(7,1),
                Point(1,2),
        ).map{
            locateTrees(it)
        }.fold(1L) { totalAccTrees, currentSlopeAccTrees -> totalAccTrees * currentSlopeAccTrees }
    }

    private fun locateTrees(slope: Point): Long {
        val currentLocation = Point(0, 0)
        var locatedTrees: Long = 0

        while (currentLocation.y < gridHeight) {
            if (listOfPoints[currentLocation.y][currentLocation.x] == '#') {
                locatedTrees++
            }
            currentLocation.x = (currentLocation.x + slope.x) % gridWidth
            currentLocation.y += slope.y
        }

        return locatedTrees
    }
}

