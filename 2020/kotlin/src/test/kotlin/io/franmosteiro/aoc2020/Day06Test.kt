package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Advent of Code 2020 - Day 6: Custom Customs -
 * Problem Description: http://adventofcode.com/2020/day/6
 */
@DisplayName("Day 6")
class Day06Test {

    @Nested
    @DisplayName("Part One")
    inner class Part1 {
        @Test
        fun `Test example input`() {

            // Given
            val input = Resources.resourceAsText("testFile06.in")

            // When
            val answer = Day06(input).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(11)
        }

        @Test
        fun `Test input file Day06in`() {
            // When
            val answer = Day06(Resources.resourceAsText("Day06.in")).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(6878)
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class Part2 {

        @Test
        fun `Test example input`() {

            // Given
            val input = Resources.resourceAsText("testFile06.in")

            // When
            val answer = Day06(input).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Test input file Day06sin`() {
            // When
            val answer = Day06(Resources.resourceAsText("Day06.in")).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(3464)
        }
    }
}