package binarytree

import org.scalatest._

class binarytreeSpec extends FunSpec with Matchers {
  describe("Binary Trees") {
    // it("P54 Omitted; our tree representation will only allow well-formed trees.") {}
    it("P55 (**) Construct completely balanced binary trees.") {
      Tree.cBalanced(4, "x") shouldBe List(T(x T (x..) T (x.T(x..))), T(x T (x..) T (x T (x..).)),.
      ..
    }
    it("P56 (**) Symmetric binary trees.") {
      Node('a', Node('b'), Node('c')).isSymmetric shouldBe true
    }
    it("P57 (**) Binary search trees (dictionaries).") {
      val res0 = End.addValue(2)
      res0.toString shouldBe "T(2 . .)"
      val res1 = res0.addValue(3)
      res1.toString shouldBe "T(2 . T(3 . .))"
      val res2 = res1.addValue(0)
      res2.toString shouldBe "T(2 T(0 . .) T(3 . .))"

      Tree.fromList(List(3, 2, 5, 7, 1)).toString shouldBe "T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))"
      Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric shouldBe true
      Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric shouldBe false
    }
    it("P58 (**) Generate-and-test paradigm.") {
      Tree.symmetricBalancedTrees(5, "x") shouldBe List(T(x T (x.T(x..)) T (x T (x..).)), T(x T (x T (x..).) T (x.T(x..))))
    }
    it("P59 (**) Construct height-balanced binary trees.") {
      Tree.hbalTrees(3, "x") shouldBe List(T(x T (x T (x..) T (x..)) T (x T (x..) T (x..))), T(x T (x T (x..) T (x..)) T (x T (x..).)),.
      ..
    }
    it("P60 (**) Construct height-balanced binary trees with a given number of nodes.") {
      minHbalNodes(3) shouldBe 4
      maxHbalHeight(4) shouldBe 3
      Tree.hbalTreesWithNodes(4, "x") shouldBe List(T(x T (x T (x..).) T (x..)), T(x T (x.T(x..)) T (x..)),.
      ..
    }
    it("P61 (*) Count the leaves of a binary tree.") {
      Node('x', Node('x'), End).leafCount shouldBe 1

    }
    it("P61A (*) Collect the leaves of a binary tree in a list.") {
      Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList shouldBe List(b, d, e)
    }
    it("P62 (*) Collect the internal nodes of a binary tree in a list.") {
      Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList shouldBe List(a, c)
    }
    it("P62B (*) Collect the nodes at a given level in a list.") {
      Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2) shouldBe List(b, c)
    }
    it("P63 (**) Construct a complete binary tree.") {
      Tree.completeBinaryTree(6, "x") shouldBe T(x T (x T (x..) T (x..)) T (x T (x..).))

    }
    it("P64 (**) Layout a binary tree (1).") {
      Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree shouldBe T[3, 1](a T[1, 2] (b.T[2, 3](c..)) T[4, 2] (d..))

    }
    it("P65 (**) Layout a binary tree (2).") {
      Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2 shouldBe T[3, 1]('a T[1, 2] ('b.T[2, 3]('c..)) T[5, 2] ('d..
      ) )

    }
    it("P66 (***) Layout a binary tree (3).") {
      Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree3 shouldBe T[2, 1]('a T[1, 2] ('b.T[2, 3]('c..)) T[3, 2] ('d..
      ) )

    }
    it("P67 (**) A string representation of binary trees.") {
      Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))).toString shouldBe a(b(d, e), c(, f(g,)))
      Tree.fromString("a(b(d,e),c(,f(g,)))") shouldBe a(b(d, e), c(, f(g,)))
    }
    it("P68 (**) Preorder and inorder sequences of binary trees.") {
      it("a) Write methods preorder and inorder that construct the preorder and inorder sequence of a given binary tree, respectively. The results should be lists, e.g. List('a','b','d','e','c','f','g') for the preorder sequence of the example in problem P67.") {
        Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder shouldBe List(a, b, d, e, c, f, g)
        Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder shouldBe List(d, b, e, a, c, g, f)
      }
      it("b) If both the preorder sequence and the inorder sequence of the nodes of a binary tree are given, then the tree is determined unambiguously. Write a method preInTree that does the job.") {
        Tree.preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f')) shouldBe a(b(d, e), c(, f(g,)))
      }
    }
    describe("P69 (**) Dotstring representation of binary trees.") {
      Tree.string2Tree("a(b(d,e),c(,f(g,)))").toDotstring shouldBe "abd..e..c.fg..."

    }
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
