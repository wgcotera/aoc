package io.github.wgcotera

import io.github.aloussase.httpclient.{FromResponseBody, HttpClient, HttpError, HttpSuccess}

import java.net.URI
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.io.Source
import scala.util.Using

object Util {

    /**
     * @param day 1 to 25 int that represents the day of the Advent of Code
     * @return puzzle input from the advent of code page
     */
    def getPuzzleInput(day: Int): String = {
        val response = Await.result(HttpClient(url = URI.create(s"https://adventofcode.com/2021/day/${day}/input"))
            .addCookie("session", System.getenv("AOC_SESSION"))
            .get[String], 10.seconds)
        response.asInstanceOf[HttpSuccess[String]].get
    }

    /**
     * @param day 1 to 25 int that represents the day of the Advent of Code
     * @return puzzle input from a File stored in the resources folder
     */
    def getPuzzleInputFromFile(day: Int): String = {
        val file = getClass.getClassLoader.getResource(s"day_${"%02d".format(day)}.in").getFile
        Using.resource(Source.fromFile(file))(_.mkString)
    }
}