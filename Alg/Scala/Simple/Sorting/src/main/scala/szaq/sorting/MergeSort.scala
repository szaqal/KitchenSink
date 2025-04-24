package szaq.sorting

object MergeSort {

  def sort(arg: List[Int]): List[Int] = {
    if (arg.size == 1) {
      return arg
    }
    val split = arg.splitAt(arg.length / 2)
    merge(sort(split._1), sort(split._2))
  }

  private def merge(left: List[Int], right: List[Int]): List[Int] = {

    if (left != Nil && right != Nil) {
      if (left.head < right.head) List(left.head) ::: merge(left.tail, right) else List(right.head) ::: merge(left, right.tail)
    } else {
      if (left != Nil) left else right
    }
  }

}