package multiwaytree

import org.scalatest._

class binarytreeSpec extends FunSpec with Matchers {
  describe("Multiway Trees") {
    // it("P70B Omitted; we can only create well-formed trees.") {}
    it("P70C (*) Count the nodes of a multiway tree.") {
      MTree('a', List(MTree('f'))).nodeCount shouldBe 2

    }
    it("P70 (**) Tree construction from a node string.") {
      MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))).toString shouldBe "afg^^c^bd^e^^^"
    }
    it("P71 (*) Determine the internal path length of a tree.") {
      "afg^^c^bd^e^^^".internalPathLength shouldBe 9

    }
    it("P72 (*) Construct the postorder sequence of the tree nodes.") {
      "afg^^c^bd^e^^^".postorder shouldBe List(g, f, c, d, e, b, a)
    }
    it("P73 (**) Lisp-like tree representation.") {
      MTree("a", List(MTree("b", List(MTree("c"))))).lispyTree shouldBe "(a (b c))"
    }
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
