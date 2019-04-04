package arithmetic

import scala.math.sqrt

class S99Int(val start: Int) {
  import S99Int._
  def isPrime: Boolean = {
    def isAnyMeasure(r: List[Int]): Boolean = r match {
      case List() => false
      case first :: rest => start % first == 0 || isAnyMeasure(rest.filter(_ % first != 0))
    }
    !isAnyMeasure((2 to sqrt(start).toInt + 1).toList)
  }

  def isCoprimeTo(sub: Int): Boolean = S99Int.gcd(start, sub) == 1

  def totient: Int = (1 to start + 1).count(start.isCoprimeTo(_))

  private def getMeasure(can: List[Int], remain: Int): List[Int] = can match {
    case _ if remain == 1 => Nil
    case List() => remain :: Nil
    case first :: _ if remain % first == 0 => first :: getMeasure(can, remain / first)
    case first :: rest => getMeasure(rest.filter(_ % first != 0), remain)
  }
  def primeFactors2: List[Int] = {
    getMeasure((2 to sqrt(start).toInt + 1).toList, start)
  }

}

object S99Int {
  def gcd(a: Int, b: Int): Int = {
    val (min, max) = if(a < b) (a, b) else (b, a)
    if(max % min == 0) min
    else gcd(max - min, min)
  }
  implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
}

