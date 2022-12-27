package aoc

import aoc.Util.readInputFile

object Day01 extends App{

    private val input: Seq[Int] = readInputFile("01").map(s => s.toInt).toList

    private def countIncreasingPairs(data: Seq[Int]): Int = {
        val pairs = data.zip(data.tail)
        pairs.count {case (a, b) => a < b}
    }


    private def countIncreasingTriples(data: Seq[Int]): Int = {
        val triples = data.sliding(3).toList
        val triplesPairs = triples.zip(triples.tail)
        triplesPairs.count {case (a, b) => a.sum < b.sum}
    }


    private val part01 = countIncreasingPairs(input)
    private val part02 = countIncreasingTriples(input)

    println(s"Measurements that are larger than the previous measurement:\t ${part01}")
    println(s"Sums of measurements that are larger than the previous sum:\t ${part02}")
}
