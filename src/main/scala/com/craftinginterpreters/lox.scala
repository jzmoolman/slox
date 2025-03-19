package com.craftinginterpreters

import java.io._
import java.nio.charset.StandardCharsets
import java.util.Scanner

import scala.io.StdIn.readLine


object Main {
  def runFile(path: String): Unit = {
      val in = new FileInputStream(path)
      val byteLength = in.available()
      val bytesArray = new Array[Byte](byteLength)
      in.read(bytesArray)
      in.close()
      val str = String(bytesArray,StandardCharsets.UTF_8);
      println( s"TEST => $str")
      ()
  }

  def runPrompt(): Unit = {
    var line: String = null
    while { print("> "); line = readLine; line.nonEmpty} do
      println(line.isEmpty)
      run(line)

  }

  def run(source: String): Unit = {
    val scanner =  Scanner(source)
    val tokens = scanner.tokens()
    tokens.forEach( t => println(t) )
  }
}

@main def helloworld(params: String*): Unit =
    if params.size > 1 then
        println("Usage: slox [script]")
    else if params.size == 1 then
        println("runFile")
        Main.runFile("/Users/zach/text.txt")
    else
        println("runPromt")
        Main.runPrompt()

    println("")