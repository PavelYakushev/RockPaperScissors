package org.training
import java.util.Scanner
import java.util.concurrent.ThreadLocalRandom
import scala.annotation.tailrec

object Main {
  val scanner = new Scanner(System.in)
  val rng: ThreadLocalRandom = ThreadLocalRandom.current()

  def main(args: Array[String]): Unit = {
    play()
  }

  @tailrec
  def play(): Unit = {
    val player_action = prompt()
    if(player_action == 3) {

    } else {
      val opponent_action = roll()
      System.out.println(
        if(opponent_action == 0)
         "r"
        else if(opponent_action == 1)
          "p"
        else
          "s"
        ,
        if (player_action == opponent_action)
          "Tie"
        else if (player_action == (opponent_action + 1) % 3)
          "Victory"
        else
          "Loss"
      )
      play()
    }
  }

  @tailrec
  def prompt(): Int = {
    System.out.println("Please choose from (r)ock, (p)aper, (s)cissors or (e)nd")
    val in: String = scanner.nextLine()
    if(in == "r")
      0
    else if(in == "p")
      1
    else if(in == "s")
      2
    else if(in == "e")
      3
    else {
      System.out.print("Incorrect input. ")
      prompt()
    }
  }

  def roll(): Int = {
    rng.nextInt(0, 3)
  }
}