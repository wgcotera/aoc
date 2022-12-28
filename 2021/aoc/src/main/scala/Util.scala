package io.github.wgcotera
import scala.io.Source

object Util{

    def readInputFile(day: String): String= {
        val file = getClass.getClassLoader.getResource(s"day_${day}.in").getFile
        Source.fromFile(file).mkString
    }

}