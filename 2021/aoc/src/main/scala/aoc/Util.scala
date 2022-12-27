package aoc

import scala.io.Source

object Util{
    def readInputFile(day: String) = {
        val file = getClass.getClassLoader.getResource(s"day_${day}.in").getFile
       Source.fromFile(file).getLines
    }
}
