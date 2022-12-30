package io.github.wgcotera

import Util.getPuzzleInput

/**
 * @param data a sequence of strings
 * @return a secuence of tuples (countOfOnes, countOfZeros)
 */
def countsOfOccurrencesPerStr(data: Seq[String]): Seq[(Int, Int)] = {
    data
        .map(_.groupBy(identity))
        .map { map => map.values }
        .map(e => (e.head.length, e.tail.head.length))
}

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
    private val counts: Seq[(Int, Int)] = countsOfOccurrencesPerStr(transposeData)

    override def part1(): Int = gammaRate(counts) * epsilonRate(counts)

    override def part2(): Int = 0
}

//@main def main(): Unit = {
//    val puzzleInput = "00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010"
//    val linesData: Seq[String] = puzzleInput.split("\n").toSeq
//    val transposeData: Seq[String] = linesData.transpose.map(_.mkString)
//    val iterables = countsOfOccurrencesPerStr(transposeData)

//}