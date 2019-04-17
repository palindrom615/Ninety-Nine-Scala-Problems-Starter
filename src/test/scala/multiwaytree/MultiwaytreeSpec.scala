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
  }
}
