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
    it("P54 Omitted; our tree representation will only allow well-formed trees.") {}
    it("P55 (**) Construct completely balanced binary trees.") {}
    it("P56 (**) Symmetric binary trees.") {}
    it("P57 (**) Binary search trees (dictionaries).") {}
    it("P58 (**) Generate-and-test paradigm.") {}
    it("P59 (**) Construct height-balanced binary trees.") {}
    it("P60 (**) Construct height-balanced binary trees with a given number of nodes.") {}
    it("P61 (*) Count the leaves of a binary tree.") {}
    it("P62 (*) Collect the internal nodes of a binary tree in a list.") {}
    it("P62B (*) Collect the nodes at a given level in a list.") {}
    it("P63 (**) Construct a complete binary tree.") {}
    it("P64 (**) Layout a binary tree (1).") {}
    it("P65 (**) Layout a binary tree (2).") {}
    it("P66 (***) Layout a binary tree (3).") {}
    it("P67 (**) A string representation of binary trees.") {}
    it("P68 (**) Preorder and inorder sequences of binary trees.") {}
    it("P69 (**) Dotstring representation of binary trees.") {}
    it("P70B Omitted; we can only create well-formed trees.") {}
    it("P70C (*) Count the nodes of a multiway tree.") {}
    it("P70 (**) Tree construction from a node string.") {}
    it("P71 (*) Determine the internal path length of a tree.") {}
    it("P72 (*) Construct the postorder sequence of the tree nodes.") {}
    it("P73 (**) Lisp-like tree representation.") {}
    it("P80 (***) Conversions.") {}
    it("P81 (**) Path from one node to another one.") {}
    it("P82 (*) Cycle from a given node.") {}
    it("P83 (**) Construct all spanning trees.") {}
    it("P84 (**) Construct the minimal spanning tree.") {}
    it("P85 (**) Graph isomorphism.") {}
    it("P86 (**) Node degree and graph coloration.") {}
    it("P87 (**) Depth-first order graph traversal.") {}
    it("P88 (**) Connected components.") {}
    it("P89 (**) Bipartite graphs.") {}
    it("P90 (**) Eight queens problem") {}
    it("P91 (**) Knight's tour.") {}
    it("P92 (***) Von Koch's conjecture.") {}
    it("P93 (***) An arithmetic puzzle.") {}
    it("P94 (***) Generate K-regular simple graphs with N nodes.") {}
    it("P95 (**) English number words.") {}
    it("P96 (**) Syntax checker.") {}
    it("P97 (**) Sudoku. (alternate solution)") {}
    it("P98 (***) Nonograms.") {}
    it("P99 (***) Crossword puzzle.") {}
  }
}
