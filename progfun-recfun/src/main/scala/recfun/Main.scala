package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0) 1
    else if (c > r) 0
    else pascal(c, r - 1) + pascal(c - 1, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balance(chars: List[Char], n: Int): Boolean =
      if (n < 0) false
      else if (chars.isEmpty)
        n == 0
      else
        balance(chars.tail, changeN(chars.head, n))

    def changeN(c: Char, n: Int): Int =
      if (c == '(') n + 1
      else if (c == ')') n - 1
      else n

    balance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (coins.isEmpty) 0
    else if (money == 0) 1
    else if (money < 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)

}
