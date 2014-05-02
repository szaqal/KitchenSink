package szaq.sorting

object BubbleSort {

  def sortIterative(input: Array[Int]): Array[Int] = {
    val limit = input.size - 1
    for (a <- 1 to limit) {
      for (b <- limit to a by -1) {
        if (input(b) < input(b - 1)) {
          val x = input(b)
          input(b) = input(b - 1)
          input(b - 1) = x
        }
      }
    }
    input
  }

  def sortRecursive(input: List[Int]): List[Int] = {
    if (input != Nil) {
      val head = input.head
      val tail = input.tail
      if (tail != Nil) {

        if (head > tail.head) {
          val result = sortRecursive(List(tail.head, head) ::: tail.tail)
          result
        } else {
          val sortResult = sortRecursive(tail)
          if (sortResult.head < head) {
            val result = sortRecursive(List(sortResult.head, head) ::: sortResult.tail)
            result
          } else {
            val result = List(head) ::: sortResult
            result
          }
        }
      } else {
        input
      }
    } else {
      input
    }
  }

}