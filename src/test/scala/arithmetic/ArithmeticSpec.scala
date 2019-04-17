package arithmetic

import org.scalatest._

class ArithmeticSpec extends FunSpec with Matchers {
  import S99Int._

  describe("P31 (**) Determine whether a given integer number is prime."){
    7.isPrime shouldBe true
  }
  describe("P32 (**) Determine the greatest common divisor of two positive integer numbers."){}
  describe("P33 (*) Determine whether two positive integer numbers are coprime."){}
  describe("P34 (**) Calculate Euler's totient function phi(m)."){}
  describe("P35 (**) Determine the prime factors of a given positive integer."){}
  describe("P36 (**) Determine the prime factors of a given positive integer (2)."){}
  describe("P37 (**) Calculate Euler's totient function phi(m) (improved)."){}
  describe("P38 (*) Compare the two methods of calculating Euler's totient function."){}
  describe("P39 (*) A list of prime numbers."){}
  describe("P40 (**) Goldbach's conjecture."){}
  describe("P41 (**) A list of Goldbach compositions."){}
  describe("P46 (**) Truth tables for logical expressions."){}
  describe("P47 (*) Truth tables for logical expressions (2)."){}
  describe("P48 (**) Truth tables for logical expressions (3)."){}
  describe("P49 (**) Gray code."){}
  describe("P50 (***) Huffman code."){}
  describe("P54 Omitted; our tree representation will only allow well-formed trees."){}
  describe("P55 (**) Construct completely balanced binary trees."){}
  describe("P56 (**) Symmetric binary trees."){}
  describe("P57 (**) Binary search trees (dictionaries)."){}
  describe("P58 (**) Generate-and-test paradigm."){}
  describe("P59 (**) Construct height-balanced binary trees."){}
  describe("P60 (**) Construct height-balanced binary trees with a given number of nodes."){}
  describe("P61 (*) Count the leaves of a binary tree."){}
  describe("P62 (*) Collect the internal nodes of a binary tree in a list."){}
  describe("P62B (*) Collect the nodes at a given level in a list."){}
  describe("P63 (**) Construct a complete binary tree."){}
  describe("P64 (**) Layout a binary tree (1)."){}
  describe("P65 (**) Layout a binary tree (2)."){}
  describe("P66 (***) Layout a binary tree (3)."){}
  describe("P67 (**) A string representation of binary trees."){}
  describe("P68 (**) Preorder and inorder sequences of binary trees."){}
  describe("P69 (**) Dotstring representation of binary trees."){}
  describe("P70B Omitted; we can only create well-formed trees."){}
  describe("P70C (*) Count the nodes of a multiway tree."){}
  describe("P70 (**) Tree construction from a node string."){}
  describe("P71 (*) Determine the internal path length of a tree."){}
  describe("P72 (*) Construct the postorder sequence of the tree nodes."){}
  describe("P73 (**) Lisp-like tree representation."){}
  describe("P80 (***) Conversions."){}
  describe("P81 (**) Path from one node to another one."){}
  describe("P82 (*) Cycle from a given node."){}
  describe("P83 (**) Construct all spanning trees."){}
  describe("P84 (**) Construct the minimal spanning tree."){}
  describe("P85 (**) Graph isomorphism."){}
  describe("P86 (**) Node degree and graph coloration."){}
  describe("P87 (**) Depth-first order graph traversal."){}
  describe("P88 (**) Connected components."){}
  describe("P89 (**) Bipartite graphs."){}
  describe("P90 (**) Eight queens problem"){}
  describe("P91 (**) Knight's tour."){}
  describe("P92 (***) Von Koch's conjecture."){}
  describe("P93 (***) An arithmetic puzzle."){}
  describe("P94 (***) Generate K-regular simple graphs with N nodes."){}
  describe("P95 (**) English number words."){}
  describe("P96 (**) Syntax checker."){}
  describe("P97 (**) Sudoku. (alternate solution)"){}
  describe("P98 (***) Nonograms."){}
  describe("P99 (***) Crossword puzzle."){}
}
