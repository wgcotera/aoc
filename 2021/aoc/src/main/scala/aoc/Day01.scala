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

    println(s"Measurements that are larger than the previous measurement:\t $part01")
    println(s"Sums of measurements that are larger than the previous sum:\t $part02")



    /*

    //    METHOD 2: Using patter matching

    private def countIncreasingPairs(data:Seq[Int]): Int = {
        data match {
            case Nil => 0
            case d1 :: d2 :: tail => (if (d1 < d2) 1 else 0) + countIncreasingPairs(d2 :: tail)
            case _ => 0
        }
    }

    private def countIncreasingTriples(data: Seq[Int]): Int = {
        data match {
            case Nil => 0
            case d1 :: d2 :: d3 :: d4 :: tail => (if((d1+d2+d3) < (d2+d3+d4)) 1 else 0) + countIncreasingTriples(d2 :: d3 :: d4 :: tail)
            case _ => 0
        }
    }

    */



    /*

    //    METHOD 3: Using for comprehension

    private def countIncreasingPairs(data:Seq[Int]): Int = {
        val pairs = data.zip(data.tail)
        val increasingPairs = for {
            (a, b) <- pairs
            if a < b
        } yield 1
        increasingPairs.sum
    }

    private def countIncreasingTriples(data: Seq[Int]): Int = {
        val triples = data.sliding(3).toList
        val triplesPairs = triples.zip(triples.tail)
        val increasingTriples = for {
            (a, b) <- triplesPairs
            if (a.sum < b.sum)
        } yield 1
        increasingTriples.sum
    }

    */
}
