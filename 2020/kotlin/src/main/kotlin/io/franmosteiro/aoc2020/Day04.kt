package io.franmosteiro.aoc2020

/**
 * Advent of Code 2020 - Day 4: Passport Processing -
 * Problem Description: http://adventofcode.com/2020/day/4
 */
class Day04(input: String) {

    private val passports = input.split("\\n\\n".toRegex()).map { line ->
        line.split("\\s".toRegex()).associate {
            val (field, value) = it.split(":")
            field to value
        }
    }

    fun resolvePartOne(): Int {

        val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

        return passports.count { passport -> requiredFields.all { it in passport } }
    }

    fun resolvePartTwo(): Int = passports.count { valid(it) }

    private fun valid(field: Map<String, String>): Boolean {

        return field["byr"]?.toIntOrNull() in 1920..2002 &&
                field["iyr"]?.toIntOrNull() in 2010..2020 &&
                field["eyr"]?.toIntOrNull() in 2020..2030 &&
                field["ecl"] in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") &&
                field["pid"]?.matches("\\d{9}".toRegex()) == true &&
                field["hcl"]?.matches("#[0-9a-f]{6}".toRegex()) == true &&
                when (field["hgt"]?.takeLast(2)) {
                    "cm" -> field["hgt"]?.dropLast(2)?.toIntOrNull() in 150..193
                    "in" -> field["hgt"]?.dropLast(2)?.toIntOrNull() in 59..76
                    else -> false
                }
    }

}

