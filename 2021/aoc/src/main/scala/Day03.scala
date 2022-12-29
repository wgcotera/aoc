package io.github.wgcotera

import Util.readInputFile

/**
 * @param counts a sequence of tuples (countOfOnes, countOfZeros)
 * @return gamma rate
 */
def gammaRate(counts: Seq[(Int, Int)]): Int = {
    val gamma = counts.map { case (ones, zeroes) => if (ones > zeroes) '1' else '0' }.mkString
    BigInt(gamma, 2).toInt
}

/**
 * @param counts a sequence of tuples (countOfOnes, countOfZeros)
 * @return epsilon rate
 */
def epsilonRate(counts: Seq[(Int, Int)]): Int = {
    val epsilon = counts.map { case (ones, zeroes) => if (ones < zeroes) '1' else '0' }.mkString
    BigInt(epsilon, 2).toInt
}

case class Day03(puzzleInput: String) extends AoC[Int, Int] {

    private val linesData: Seq[String] = puzzleInput.split("\n").toSeq
    private val transposeData: Seq[String] = linesData.transpose.map(_.mkString)
    private val counts: Seq[(Int, Int)] = transposeData
        .map(_.groupBy(identity))
        .map { map => map.values }
        .map(e => (e.head.length, e.tail.head.length))

    override def part1(): Int = gammaRate(counts) * epsilonRate(counts)

    override def part2(): Int = 0
}