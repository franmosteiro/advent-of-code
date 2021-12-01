package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Advent of Code 2020 - Day 3: Toboggan Trajectory -
 * Problem Description: http://adventofcode.com/2020/day/3
 */
@DisplayName("Day 3")
class Day03Test {

    @Nested
    @DisplayName("Part One")
    inner class Part1 {
        @Test
        fun `Test example listOf`() {

            // Given
            val list = Resources.resourceAsList("testFile03.in")

            // When
            val answer = Day03(list).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(7L)
        }

        @Test
        fun `Test input file Day03in`() {
            // When
            val answer = Day03(Resources.resourceAsList("Day03.in")).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(207L)
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class Part2 {
        @Test
        fun `Test example input`() {

            // Given
            val list = Resources.resourceAsList("testFile03.in")

            // When
            val answer = Day03(list).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(252L)
        }

        @Test
        fun `Test input file Day03in`() {
            // When
            val answer = Day03(Resources.resourceAsList("Day03.in")).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(2655892800L)
        }
    }
}