package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Advent of Code 2020 - Day 8: Handheld Halting -
 * Problem Description: http://adventofcode.com/2020/day/8
 */
@DisplayName("Day 8")
class Day08Test {

    @Nested
    @DisplayName("Part One")
    inner class Part1 {
        @Test
        fun `Test example input`() {

            // Given
            val list = Resources.resourceAsList("testFile08.in")

            // When
            val answer = Day08(list).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Test input file Day08in`() {
            // When
            val answer = Day08(Resources.resourceAsList("Day08.in")).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(1814)
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class Part2 {
        @Test
        fun `Test example input`() {

            // Given
            val list = Resources.resourceAsList("testFile08.in")

            // When
            val answer = Day08(list).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Test input file Day08in`() {
            // When
            val answer = Day08(Resources.resourceAsList("Day08.in")).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(1056)
        }
    }
}