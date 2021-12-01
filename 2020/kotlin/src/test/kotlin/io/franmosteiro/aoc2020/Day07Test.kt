package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Advent of Code 2020 - Day 7: Handy Haversacks -
 * Problem Description: http://adventofcode.com/2020/day/7
 */
@DisplayName("Day 7")
class Day07Test {

    @Nested
    @DisplayName("Part One")
    inner class Part1 {
        @Test
        fun `Test example input`() {

            // Given
            val list = Resources.resourceAsList("testFile07.in")

            // When
            val answer = Day07(list).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Test input file Day07in`() {
            // When
            val answer = Day07(Resources.resourceAsList("Day07.in")).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(252)
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class Part2 {
        @Test
        fun `Test example input`() {

            // Given
            val list = Resources.resourceAsList("testFile07_2.in")

            // When
            val answer = Day07(list).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(126)
        }

        @Test
        fun `Test input file Day07in`() {
            // When
            val answer = Day07(Resources.resourceAsList("Day07.in")).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(35487)
        }
    }
}