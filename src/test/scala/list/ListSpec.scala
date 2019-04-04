package list

import org.scalatest._

class ListSpec extends FunSpec with Matchers {
  import list._

  describe("P01 (*) Find the last element of a list.") {
      last(List(1, 1, 2, 3, 5, 8)) shouldBe 8
  }
  describe("P02 (*) Find the last but one element of a list.") {
    penultimate(List(1, 1, 2, 3, 5, 8)) shouldBe 5
  }

  describe("P03 (*) Find the Kth element of a list.") {
    nth(2, List(1, 1, 2, 3, 5, 8)) shouldBe 2
  }

  describe("P04 (*) Find the number of elements of a list.") {
    list.length(List(1, 1, 2, 3, 5, 8)) shouldBe 6
  }

  describe("P05 (*) Reverse a list.") {
    reverse(List(1, 1, 2, 3, 5, 8)) shouldEqual List(8, 5, 3, 2, 1, 1)
  }

  describe("P06 (*) Find out whether a list is a palindrome.") {
    isPalindrome(List(1, 2, 3, 2, 1)) shouldBe true
  }

  describe("P07 (**) Flatten a nested list structure.") {
    flatten(List(List(1, 1), 2, List(3, List(5, 8)))) shouldEqual List(1, 1, 2, 3, 5, 8)
  }

  describe("P08 (**) Eliminate consecutive duplicates of list elements.") {
    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List('a, 'b, 'c, 'a, 'd, 'e)
  }

  describe("P09 (**) Pack consecutive duplicates of list elements into sublists.") {
      pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  }

  describe("P10 (*) Run-length encoding of a list.") {
    encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  }

  describe("P11 (*) Modified run-length encoding."){
    encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  }

  describe("P12 (**) Decode a run-length encoded list."){
    decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) shouldBe List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  }
  describe("P13 (**) Run-length encoding of a list (direct solution)."){}
  describe("P14 (*) Duplicate the elements of a list."){}
  describe("P15 (**) Duplicate the elements of a list a given number of times."){}
  describe("P16 (**) Drop every Nth element from a list."){}
  describe("P17 (*) Split a list into two parts."){}
  describe("P18 (**) Extract a slice from a list."){}
  describe("P19 (**) Rotate a list N places to the left."){}
  describe("P20 (*) Remove the Kth element from a list."){}
  describe("P21 (*) Insert an element at a given position into a list."){}
  describe("P22 (*) Create a list containing all integers within a given range."){}
  describe("P23 (**) Extract a given number of randomly selected elements from a list."){}
  describe("P24 (*) Lotto: Draw N different random numbers from the set 1..M."){}
  describe("P25 (*) Generate a random permutation of the elements of a list."){}
  describe("P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list."){}
  describe("P27 (**) Group the elements of a set into disjoint subsets."){}
  describe("P28 (**) Sorting a list of lists according to length of sublists."){}

}
