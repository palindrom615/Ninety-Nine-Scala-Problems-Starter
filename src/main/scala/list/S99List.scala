package list

import scala.util.Random

object S99List {
  def last[T](xs: List[T]): T =
    xs match {
      case x :: Nil => x
      case _ :: xs1 => last(xs1)
    }

  def penultimate[T](xs: List[T]): T =
    xs match {
      case x :: _ :: Nil => x
      case _ :: xs1 => penultimate(xs1)
    }

  def nth[T](k: Int, xs: List[T]): T =
    if (k == 0) xs.head
    else nth(k - 1, xs.tail)

  def length[T](xs: List[T]): Int = {
    def go (acc: Int, ys: List[T]): Int = ys match {
      case Nil => acc
      case _ => go(acc + 1, ys.tail)
    }
    go(0, xs)
  }

  def reverse[T](xs: List[T]): List[T] =
    xs match {
      case Nil => Nil
      case x :: xs1 => reverse(xs1) ::: x :: Nil
    }

  def isPalindrome[T](xs: List[T]): Boolean =
    xs match {
      case Nil => true
      case _ :: Nil => true
      case x :: y :: Nil => x == y
      case _ if xs.head == xs.last => isPalindrome(xs.tail.init)
      case _ => false
    }

  def flatten[T](xs: List[T]): List[T] =
    xs match {
      case Nil => Nil
      case (x: List[T]) :: xs1 => flatten(x) ::: flatten(xs1)
      case (x: T) :: xs1 => x :: flatten(xs1)
    }

  def compress[T](xs: List[T]): List[T] =
    xs match {
      case Nil => Nil
      case x :: y :: xs1 if x == y => compress(x :: xs1)
      case x :: xs1 => x :: compress(xs1)
    }

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case _ => xs.takeWhile(_ == xs.head) :: pack(xs.dropWhile(_ == xs.head))
  }

  def encode[T](xs: List[T]): List[(Int, T)] = xs match {
    case Nil => Nil
    case _ => (xs.takeWhile(_ == xs.head).size, xs.head) :: encode(xs.dropWhile(_ == xs.head))
  }

  def encodeModified[T](xs: List[T]): List[Any] = xs match {
    case Nil => Nil
    case x :: y :: _ if x != y => x :: encodeModified(xs.dropWhile(_ == xs.head))
    case _ => (xs.takeWhile(_ == xs.head).size, xs.head) :: encodeModified(xs.dropWhile(_ == xs.head))
  }

  def decode[T](xs: List[(Int, T)]): List[T] = xs match {
    case Nil => Nil
    case (num: Int, a: T) :: xs1 => List.fill(num)(a) ::: decode(xs1)
  }

  def encodeDirect[T](xs: List[T]): List[(Int, T)] = encode(xs)

  def duplicate[T](xs: List[T]): List[T] = xs match {
    case Nil => Nil
    case x :: xs1 => x :: x :: duplicate(xs1)
  }

  def duplicateN[T](n: Int, xs: List[T]): List[T] = xs match {
    case Nil => Nil
    case x :: xs1 => List.fill(n)(x) ::: duplicateN(n, xs1)
  }

  def drop[T](n: Int, xs: List[T]): List[T] = xs.zipWithIndex.filter{case (_: T, idx: Int) =>
    (idx  + 1) % n != 0
  }.map{case (x: T, _: Int) => x}

  def split[T](n: Int, xs: List[T]): List[List[T]] = xs.take(n) :: xs.drop(n) :: Nil

  def slice[T](from: Int, until: Int, xs: List[T]): List[T] = xs.slice(from, until)

  def rotate[T](n: Int, xs: List[T]): List[T] = xs.drop(n) ::: xs.take(n)

  def removeAt[T](k: Int, xs: List[T]): (List[T], T) = (xs.slice(0, k) ::: xs.slice(k + 1, xs.size), xs(k))

  def insertAt[T](elem: T, at: Int, xs: List[T]): List[T] = xs.slice(0, at) ::: elem :: xs.drop(at)

  def range(from: Int, to: Int): List[Int] = if (from == to) from :: Nil else from :: range(from + 1, to)

  def randomSelect[T](n: Int, xs: List[T]): List[T] = xs match {
    case Nil => Nil
    case _ =>
      val (last, elem) = removeAt(Random.nextInt(xs.size), xs)
      elem :: randomSelect(n - 1, last)
  }

  def lotto(n: Int, m: Int): List[Int] = randomSelect(n, List.range(1, m))

  def randomPermute[T](xs: List[T]): List[T] = randomSelect(xs.size, xs)

  def combinations[T](n: Int, xs: List[T]): List[List[T]] =
    n match {
      case _ if n > xs.size => List()
      case 1 => xs.map(List(_))
      case _ => combinations(n - 1, xs.tail).map(xs.head :: _) ::: combinations(n, xs.tail)
    }

  private def listMinus[T](subtractee: List[T], subtractor: List[T]): List[List[T]]
  = subtractor :: (subtractee.toSet -- subtractor).toList :: Nil

  def group3[T] (xs: List[T]): List[List[List[T]]] = group(List(2, 3, 4), xs)

  def group[T](gs: List[Int], xs: List[T]): List[List[List[T]]] = gs match {
    case Nil => List()
    case _ :: Nil => List(List(xs))
    case _ => combinations(gs.head, xs).map(listMinus(xs, _)).flatMap(i => group(gs.tail, i.last).map(i.init ::: _))
  }

  def lsort[T](listOfList: List[List[T]]): List[List[T]] = listOfList.sortBy(_.size)

  def lsortFreq[T](listOfList: List[List[T]]): List[List[T]] = listOfList.sortBy(eachList => listOfList.count(list => list.size == eachList.size))
}
