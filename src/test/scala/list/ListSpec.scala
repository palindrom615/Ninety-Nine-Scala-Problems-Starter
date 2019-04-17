package list

import org.scalatest._

class ListSpec extends FunSpec with Matchers {
  describe("Working with lists") {
    import S99List._

    it("P01 (*) Find the last element of a list.") {
      last(List(1, 1, 2, 3, 5, 8)) shouldBe 8
    }
    it("P02 (*) Find the last but one element of a list.") {
      penultimate(List(1, 1, 2, 3, 5, 8)) shouldBe 5
    }

    it("P03 (*) Find the Kth element of a list.") {
      nth(2, List(1, 1, 2, 3, 5, 8)) shouldBe 2
    }

    it("P04 (*) Find the number of elements of a list.") {
      S99List.length(List(1, 1, 2, 3, 5, 8)) shouldBe 6
    }

    it("P05 (*) Reverse a list.") {
      reverse(List(1, 1, 2, 3, 5, 8)) shouldEqual List(8, 5, 3, 2, 1, 1)
    }

    it("P06 (*) Find out whether a list is a palindrome.") {
      isPalindrome(List(1, 2, 3, 2, 1)) shouldBe true
    }

    it("P07 (**) Flatten a nested list structure.") {
      flatten(List(List(1, 1), 2, List(3, List(5, 8)))) shouldEqual List(1, 1, 2, 3, 5, 8)
    }

    it("P08 (**) Eliminate consecutive duplicates of list elements.") {
      compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List('a, 'b, 'c, 'a, 'd, 'e)
    }

    it("P09 (**) Pack consecutive duplicates of list elements into sublists.") {
      pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    }

    it("P10 (*) Run-length encoding of a list.") {
      encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    }

    it("P11 (*) Modified run-length encoding.") {
      encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldEqual List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
    }

    it("P12 (**) Decode a run-length encoded list.") {
      decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) shouldBe List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    }

    it("P13 (**) Run-length encoding of a list (direct solution).") {
      encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    }

    it("P14 (*) Duplicate the elements of a list.") {
      duplicate(List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    }

    it("P15 (**) Duplicate the elements of a list a given number of times.") {
      duplicateN(3, List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    }

    it("P16 (**) Drop every Nth element from a list.") {
      drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    }

    it("P17 (*) Split a list into two parts.") {
      split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List(List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    }

    it("P18 (**) Extract a slice from a list.") {
      slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('d, 'e, 'f, 'g)
    }

    it("P19 (**) Rotate a list N places to the left.") {
      rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
      rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    }

    it("P20 (*) Remove the Kth element from a list.") {
      removeAt(1, List('a, 'b, 'c, 'd)) shouldBe(List('a, 'c, 'd), 'b)
    }

    it("P21 (*) Insert an element at a given position into a list.") {
      insertAt('new, 1, List('a, 'b, 'c, 'd)) shouldBe List('a, 'new, 'b, 'c, 'd)
    }

    it("P22 (*) Create a list containing all integers within a≤given range.") {
      range(4, 9) shouldBe List(4, 5, 6, 7, 8, 9)
    }

//    it("P23 (**) Extract a given number of randomly selected elements from a list.") {
//      randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) shouldBe List('e, 'd, 'a)
//    }
//
//    it("P24 (*) Lotto: Draw N different random numbers from the set 1..M.") {
//      lotto(6, 49) shouldBe List(23, 1, 17, 33, 21, 37)
//    }
//
//    it("P25 (*) Generate a random permutation of the elements of a list.") {
//      randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) shouldBe List('b, 'a, 'd, 'c, 'e, 'f)
//    }

    it("P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.") {
      combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)) shouldBe List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), List('a, 'b, 'f), List('a, 'c, 'd), List('a, 'c, 'e), List('a, 'c, 'f), List('a, 'd, 'e), List('a, 'd, 'f), List('a, 'e, 'f), List('b, 'c, 'd), List('b, 'c, 'e), List('b, 'c, 'f), List('b, 'd, 'e), List('b, 'd, 'f), List('b, 'e, 'f), List('c, 'd, 'e), List('c, 'd, 'f), List('c, 'e, 'f), List('d, 'e, 'f))
    }

//      describe("P27 (**) Group the elements of a set into disjoint subsets.") {
//        it("a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.") {
//            group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) shouldBe List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
//        }
//        it("b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.") {
//          group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) shouldBe List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
//        }
//      }

    describe("P28 (**) Sorting a list of lists according to length of sublists.") {
      it("a) We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of the list according to their length. E.g. short lists first, longer lists later, or vice versa.") {
        lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) shouldBe List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
      }
      it("b) Again, we suppose that a list contains elements that are lists themselves. But this time the objective is to sort the elements according to their length frequency; i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.\n") {
        lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) shouldBe List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
      }
    }
  }
}
