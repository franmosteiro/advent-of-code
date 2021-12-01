package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Advent of Code 2020 - Day 9: Encoding Error -
 * Problem Description: http://adventofcode.com/2020/day/9
 */
@DisplayName("Day 9")
class Day09Test {

    @Nested
    @DisplayName("Part One")
    inner class Part1 {
        @Test
        fun `Test example input`() {

            // Given
            val list = Resources.resourceAsList("testFile09.in")

            // When
            val answer = Day09(list).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(127)
        }

        @Test
        fun `Test input file Day09in`() {
            // When
            val answer = Day09(Resources.resourceAsList("Day09.in")).resolvePartOne(25)

            // Then
            assertThat(answer).isEqualTo(1398413738)
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class Part2 {

        @Test
        fun `Test input file Day09in`() {
            // When
            val answer = Day09(Resources.resourceAsList("Day09.in")).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(169521051)
        }
    }
}