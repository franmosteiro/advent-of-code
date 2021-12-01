package io.franmosteiro.aoc2020

/**
 * Advent of Code 2020 - Day 7: Handy Haversacks -
 * Problem Description: http://adventofcode.com/2020/day/7
 */
class Day07(input: List<String>) {

    private val allBags: List<Bag>
    private val MY_BAG = "shiny gold"

    companion object {
        private val bagPattern = """(\w+ \w+) bags contain (.*)""".toRegex()
        private val bagChildsPattern = """(\d+) (\w+ \w+) bags?""".toRegex()

        fun fromString(line: String): Bag {
            val (name, rest) = bagPattern.matchEntire(line)!!.destructured
            val contains = bagChildsPattern.findAll(rest).map { match ->
                val (c, n) = match.destructured
                c.toInt() to Bag(n, emptyList())
            }.toList()
            return Bag(name, contains)
        }
    }

    init {
        val bags = input.map { fromString(it) }

        fun buildRules(name: String): Bag {
            val containedBags = bags.first { it.color == name }.contains.map {
                it.first to buildRules(it.second.color)
            }
            return Bag(name, containedBags)
        }

        allBags = bags.map { buildRules(it.color) }
    }

    fun resolvePartOne(): Int =
            allBags.count { it.canHold(MY_BAG) }

    fun resolvePartTwo(): Int =
            allBags.first { it.color == MY_BAG }.numContains()


    data class Bag(val color : String,
                           val contains : List<Pair<Int, Bag>> = emptyList()){

        fun canHold(what: String): Boolean {
            return contains.any { it.second.color == what || it.second.canHold(what) }
        }

        fun numContains(): Int {
            return contains.sumBy {
                it.first * (it.second.numContains() + 1)
            }
        }

    }
}

