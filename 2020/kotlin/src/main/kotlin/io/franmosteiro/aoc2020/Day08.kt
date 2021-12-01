package io.franmosteiro.aoc2020

/**
 * Advent of Code 2020 - Day 8: Handheld Halting -
 * Problem Description: http://adventofcode.com/2020/day/8
 */
class Day08(input: List<String>) {

    private val orders: List<Order> = input.map {
        val (name, offset) = it.split("\\s".toRegex())
        Order(name, offset.toInt())
    }

    fun resolvePartOne(): Int {
        val (position, accumulator) =  Program().run(orders)
        return accumulator
    }

    fun resolvePartTwo(): Int {
        orders.forEachIndexed { i, order ->
            when (order.name) {
                "jmp" -> orders.toMutableList().also { orders -> orders[i] = Order("nop", order.offset) }
                "nop" -> orders.toMutableList().also { orders -> orders[i] = Order("jmp", order.offset) }
                else -> null
            }?.let {
                val (position, accumulator) = Program().run(it)
                if (position == orders.size) {
                    return accumulator
                }
            }
        }
        return -1
    }

    data class Program(
            var position: Int = 0,
            var accumulator: Int = 0,
            var executedOrdersPositions: MutableSet<Int> = mutableSetOf()) {

        fun run(orders: List<Order>): Pair<Int, Int> {
            while (true) {

                if (position in executedOrdersPositions || position >= orders.size) {
                    return position to accumulator
                }

                executedOrdersPositions.add(position)

                val currentOrder = orders[position]

                when (currentOrder.name) {
                    "jmp" -> position += currentOrder.offset
                    "nop" -> position++
                    "acc" -> {
                        accumulator += currentOrder.offset
                        position++
                    }
                }
            }
        }
    }

    data class Order(
            val name: String,
            val offset: Int,
    )
}

