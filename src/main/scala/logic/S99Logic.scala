package logic

object S99Logic {
  def and(a: Boolean, b: Boolean): Boolean = {}
  def xor(a: Boolean, b: Boolean): Boolean = {}
  def not(a: Boolean): Boolean = {}
  def table2(logicExpression: (Boolean, Boolean) => Boolean): Unit = {}

  class S99Boolean(val start: Boolean) {
    def and(rOperand: Boolean): Boolean = {}
    def or(rOperand: Boolean): Boolean = {}
  }
  implicit def boolean2S99Boolean(i: Boolean) = new S99Boolean(i)
}
