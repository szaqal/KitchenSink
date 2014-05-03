package szaq.sorting

object QuickSort {

  def sort(arg: List[Int]): List[Int] = {
    if (arg != Nil) {
      val partitioned = arg.tail.partition(_ < arg.head)
      sort(partitioned._1) ::: List(arg.head) ::: sort(partitioned._2)
    } else {
      List()
    }
  }
}