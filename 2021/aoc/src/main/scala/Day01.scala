package io.github.wgcotera

import Util.getPuzzleInput

def countIncreasingPairs(data: Seq[Int]): Int = {
    val pairs = data.zip(data.tail)
    pairs.count { case (a, b) => a < b }
}

def countIncreasingTriples(data: Seq[Int]): Int = {
    val triples = data.sliding(3).toList
    val triplesPairs = triples.zip(triples.tail)
    triplesPairs.count { case (a, b) => a.sum < b.sum }
}


case class Day01(puzzleInput: String) extends AoC[Int, Int] {

    override def part1(): Int = countIncreasingPairs(puzzleInput.split("\n").map(s => s.toInt).toList)

    override def part2(): Int = countIncreasingTriples(puzzleInput.split("\n").map(s => s.toInt).toList)
}

/*
//    METHOD 2: Using patter matching
def countIncreasingPairs(data:Seq[Int]): Int = {
    data match {
        case Nil => 0
        case d1 :: d2 :: tail => (if (d1 < d2) 1 else 0) + countIncreasingPairs(d2 :: tail)
        case _ => 0
    }
}
def countIncreasingTriples(data: Seq[Int]): Int = {
    data match {
        case Nil => 0
        case d1 :: d2 :: d3 :: d4 :: tail => (if((d1+d2+d3) < (d2+d3+d4)) 1 else 0) + countIncreasingTriples(d2 :: d3 :: d4 :: tail)
        case _ => 0
    }
}
*/


/*
//    METHOD 3: Using for comprehension
def countIncreasingPairs(data:Seq[Int]): Int = {
    val pairs = data.zip(data.tail)
    val increasingPairs = for {
        (a, b) <- pairs
        if a < b
    } yield 1
    increasingPairs.sum
}
def countIncreasingTriples(data: Seq[Int]): Int = {
    val triples = data.sliding(3).toList
    val triplesPairs = triples.zip(triples.tail)
    val increasingTriples = for {
        (a, b) <- triplesPairs
        if (a.sum < b.sum)
    } yield 1
    increasingTriples.sum
}
*/
