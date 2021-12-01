package io.franmosteiro.aoc2020

import io.franmosteiro.aoc2020.utils.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Advent of Code 2020 - Day 2: Password Philosophy -
 * Problem Description: http://adventofcode.com/2020/day/2
 */
@DisplayName("Day 2")
class Day02Test {

    @Nested
    @DisplayName("Part One")
    inner class Part1 {
        @Test
        fun `Test example listOfPasswords`() {

            // Given
            val listOfPasswords = Resources.resourceAsList("testFile02.in")

            // When
            val answer = Day02(listOfPasswords).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Test input file Day02in`() {
            // When
            val answer = Day02(Resources.resourceAsList("Day02.in")).resolvePartOne()

            // Then
            assertThat(answer).isEqualTo(396)
        }
    }

    @Nested
    @DisplayName("Part Two")
    inner class Part2 {
        @Test
        fun `Test example input`() {

            // Given
            val list = Resources.resourceAsList("testFile02.in")

            // When
            val answer = Day02(list).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Test input file Day02in`() {
            // When
            val answer = Day02(Resources.resourceAsList("Day02.in")).resolvePartTwo()

            // Then
            assertThat(answer).isEqualTo(428)
        }
    }
}