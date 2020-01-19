package com.cwp.sort

/**
  *
  * @author : 蔡文平
  * @date : 2020/01/02 09:36
  * @description :
  */
object QuickSort {
  def main(args: Array[String]): Unit = {
  }
  /**
    * 快排
    * 时间复杂度:平均时间复杂度为O(nlogn)
    *空间复杂度:O(logn)，因为递归栈空间的使用问题
    */
  def quickSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case List() => List()
    case head :: tail =>
      val (left, right) = tail.partition(_ < head)
      quickSort(left) ::: head :: quickSort(right)
  }

  /**
    * 归并
    * 时间复杂度:O(nlogn)
    * 空间复杂度:O(n)
    */
  def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
    case (Nil, _) => right
    case (_, Nil) => left
    case (x :: xTail, y :: yTail) =>
      if (x <= y) x :: merge(xTail, right)
      else y :: merge(left, yTail)
  }


}
