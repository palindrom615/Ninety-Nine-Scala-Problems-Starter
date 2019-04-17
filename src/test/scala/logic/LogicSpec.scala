package logic

import org.scalatest._

class LogicSpec extends FunSpec with Matchers {

  import logic.S99Logic._

  describe("Logic and Codes") {
    it("P46 (**) Truth tables for logical expressions.") {
      and(true, true) shouldBe true
      xor(true, true) shouldBe false
      val stream = new java.io.ByteArrayOutputStream()
      Console.withOut(stream) {
        table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
        stream shouldBe
          """
            |A     B     result
            |true  true  true
            |true  false true
            |false true  false
            |false false false
          """.stripMargin
      }
    }
    it("P47 (*) Truth tables for logical expressions (2).") {
      val stream = new java.io.ByteArrayOutputStream()
      Console.withOut(stream) {
        table2((a: Boolean, b: Boolean) => a and (a or not(b)))
        stream shouldBe
          """
            |A     B     result
            |true  true  true
            |true  false true
            |false true  false
            |false false false
          """.stripMargin
      }
    }
    // it("P48 (**) Truth tables for logical expressions (3).") {}
    it("P49 (**) Gray code.") {
      gray(3) shouldBe List("000", "001", "011", "010", "110", "111", "101", "100")
    }
    it("P50 (***) Huffman code.") {
      huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))) shouldBe List(("a", "0"), ("b", "101"), ("c", "100"), ("d", "111"), ("e", "1101"), ("f", "1100"))
    }
  }
}
