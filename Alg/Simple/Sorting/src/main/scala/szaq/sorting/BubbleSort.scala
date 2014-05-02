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
    if (input != Nil && input.tail != Nil) {
      if (input.head > input.tail.head) {
        sortRecursive(List(input.tail.head, input.head) ::: input.tail.tail)
      } else {
        val sortResult = sortRecursive(input.tail)
        if (sortResult.head < input.head) sortRecursive(List(sortResult.head, input.head) ::: sortResult.tail) else List(input.head) ::: sortResult
      }
    } else {
      input
    }
  }

}