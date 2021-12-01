package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Advent of Code 2020 - Day 4: Passport Processing -
 * Problem Description: http://adventofcode.com/2020/day/4
 */
@DisplayName("Day 4")
class Day04Test {

    @Nested
    @DisplayName("Part One")
    inner class Part1 {
        @Test
        fun `Test example listOf`() {

            // Given
            val input = Resources.resourceAsText("testFile04_2.in")

            // When
            val answer = Day04(input).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Test input file Day04in`() {
            // When
            val answer = Day04(Resources.resourceAsText("Day04.in")).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(228)
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class Part2 {
        @Test
        fun `Test example input`() {

            // Given
            val input = Resources.resourceAsText("testFile04.in")

            // When
            val answer = Day04(input).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Test input file Day03in`() {
            // When
            val answer = Day04(Resources.resourceAsText("Day04.in")).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(175)
        }
    }
}