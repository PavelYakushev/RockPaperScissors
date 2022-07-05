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
      System.out.println(opponent_action,
        if (player_action == opponent_action)
          "Tie"
        else if (opponent_action == (player_action + 1) % 3)
          "Victory"
        else
          "Loss"
      )
      play()
    }
  }

  def prompt(): Int = {
    val in: Int = scanner.nextInt()
    if(in > 3 || in < 0)
      3
    else
      in
  }

  def roll(): Int = {
    rng.nextInt(0, 3)
  }
}