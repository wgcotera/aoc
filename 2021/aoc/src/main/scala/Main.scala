package io.github.wgcotera

import Util.getPuzzleInput

import scala.io.StdIn

@main def main(): Unit = {
    println("Enter the day to execute:")
    val day = StdIn.readInt()

    val dayFormatted = s"${"%02d".format(day)}"
    val dayClass = s"io.github.wgcotera.Day${dayFormatted}"

    try {
        val clazz = Class.forName(dayClass)
        val instance = clazz.getDeclaredConstructor(classOf[String]).newInstance(getPuzzleInput(day))

        val part1Method = clazz.getMethod(s"part1")
        val part2Method = clazz.getMethod(s"part2")

        val part1 = part1Method.invoke(instance)
        val part2 = part2Method.invoke(instance)

        println(s"Day ${dayFormatted}")
        println(s"Part 01: $part1")
        println(s"Part 02: $part2")
    } catch {
        case _: ClassNotFoundException => println(s"Invalid day: $day")
        case _: NoSuchMethodException => println(s"Method not found for Day $dayFormatted")
    }
}