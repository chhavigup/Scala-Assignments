package com.knoldus.edu
class PatternMatching{

  def max(list: List[Int]): Int = list match {
    case Nil => throw new NoSuchElementException("The list is empty")
    case List(x: Int) => x
    case x :: y :: rest => max((if (x > y) x else y) :: rest)
  }

  def min(list: List[Int]): Int = list match {
    case Nil => throw new NoSuchElementException("The list is empty")
    case List(x: Int) => x
    case x :: y :: rest => min((if (x < y) x else y) :: rest)
  }

  def length(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: tail => 1 + length(tail)
  }

  def lastNthElement(list: List[Int], num :Int ): Int = list match {
    case Nil => throw new NoSuchElementException("the list is empty")
    case x :: tail => {
      if (num == tail.length) tail.head
      else lastNthElement(tail,num)
    }
  }
}



