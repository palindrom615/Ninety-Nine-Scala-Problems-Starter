package arithmetic

import org.scalatest._

class ArithmeticSpec extends FunSpec with Matchers {

  import S99Int._

  describe("Arithmetic") {
    it("P31 (**) Determine whether a given integer number is prime.") {
      7.isPrime shouldBe true
    }
    it("P32 (**) Determine the greatest common divisor of two positive integer numbers.") {
      gcd(36, 63) shouldBe 9
    }
    it("P33 (*) Determine whether two positive integer numbers are coprime.") {
      35.isCoprimeTo(64) shouldBe true
    }
    it("P34 (**) Calculate Euler's totient function phi(m).") {
      10.totient shouldBe 4
    }
    it("P35 (**) Determine the prime factors of a given positive integer.") {
      315.primeFactors shouldBe List(3, 3, 5, 7)

    }
    it("P36 (**) Determine the prime factors of a given positive integer (2).") {
      315.primeFactorMultiplicity shouldBe List((3, 2), (5, 1), (7, 1))
    }
    it("P37 (**) Calculate Euler's totient function phi(m) (improved).") {

    }
    it("P38 (*) Compare the two methods of calculating Euler's totient function.") {

    }
    it("P39 (*) A list of prime numbers.") {
      listPrimesinRange(7 to 31) shouldBe List(7, 11, 13, 17, 19, 23, 29, 31)

    }
    it("P40 (**) Goldbach's conjecture.") {
      28.goldbach shouldBe(5, 23)
    }
    it("P41 (**) A list of Goldbach compositions.") {
      val streamA = new java.io.ByteArrayOutputStream()
      Console.withOut(streamA) {
        printGoldbachList(9 to 20)
        streamA shouldBe
          """
            |10 = 3 + 7
            |12 = 5 + 7
            |14 = 3 + 11
            |16 = 3 + 13
            |18 = 5 + 13
            |20 = 3 + 17
          """.stripMargin
      }
      val streamB = new java.io.ByteArrayOutputStream()
      Console.withOut(streamB) {
        printGoldbachListLimited(1 to 2000, 50)
        streamB shouldBe
          """
            |992 = 73 + 919
            |1382 = 61 + 1321
            |1856 = 67 + 1789
            |1928 = 61 + 1867
          """
      }
    }
  }
}
