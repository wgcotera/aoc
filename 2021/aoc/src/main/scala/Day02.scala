package io.github.wgcotera

import Util.readInputFile

import java.util
import scala.util.matching.Regex

def finalLocationOne(data: Seq[(String, Int)]): Int = {
    val location = data.foldLeft((0, 0)) {
        case ((x, y), ("forward", n)) => (x + n, y)
        case ((x, y), ("down", n)) => (x, y + n)
        case ((x, y), ("up", n)) => (x, y - n)
    }
    location(0) * location(1)
}

def finalLocationTwo(data: Seq[(String, Int)]): Int = {
    val location = data.foldLeft((0, 0, 0)) {
        case ((x, y, aim), ("forward", n)) => (x + n, y + (aim * n), aim)
        case ((x, y, aim), ("down", n)) => (x, y, aim + n)
        case ((x, y, aim), ("up", n)) => (x, y, aim - n)
    }
    location(0) * location(1)
}


case class Day02(puzzleInput: String) extends AoC[Int, Int] {

    val pattern: Regex = """(\w+) (\d+)""".r

    override def part1(): Int =
        finalLocationOne(puzzleInput.split("\n").toList.map { case pattern(a, b) => (a, b.toInt) })

    override def part2(): Int =
        finalLocationTwo(puzzleInput.split("\n").toList.map { case pattern(a, b) => (a, b.toInt) })
}











//case Day02(puzzleInput: String) extends AoC[(Int, Int), (Int, Int)] {
//
//}



