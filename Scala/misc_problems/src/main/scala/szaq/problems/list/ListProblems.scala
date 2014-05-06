package szaq.problems.list

object ListProblems {

  def last[T](arg: List[T]): T = {
    arg match {
      case head :: Nil => head
      case head :: tail => last(tail)
      case _ => throw new NoSuchElementException
    }
  }

  def penultimate[T](arg: List[T]): T = {
    arg match {
      case head :: tail if tail.size == 1 => head
      case head :: tail if tail.size > 1 => penultimate(tail)
      case _ => throw new NoSuchElementException
    }
  }

  def penultimateRecursive[A](arg: List[A]): A = arg match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  def nthElement[T](which: Int, arg: List[T]): T = (which, arg) match {
    case (0, head :: _) => head
    case (which, head :: _) => nthElement(which - 1, arg.tail)
    case _ => throw new NoSuchElementException
  }

  def length[T](arg: List[T]): Int = arg match {
    case Nil => 0
    case head :: tail => length(tail) + 1
    case _ => 0
  }

  def reverse[T](arg: List[T]): List[T] = arg match {
    case Nil => List()
    case head :: tail => reverse(tail) ::: List(head)
    case _ => List();
  }

  def flatten(arg: List[Any]): List[Any] = arg.flatMap({
    case x: List[_] => flatten(x)
    case e => List(e)
  })

  def dropDuplicated[T](arg: List[T]): List[T] = arg match {
    case Nil => Nil
    case head :: tail => head :: dropDuplicated(tail.dropWhile(_ == head))
  }

  def pack[T](arg: List[T]): List[List[T]] = {
    if (arg.isEmpty) {
      List(List())
    } else {
      val (packed, next) = arg span { _ == arg.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  def encode[T](arg: List[T]): List[(Int, T)] = {
    if (arg.isEmpty) {
      List()
    } else {
      val (packed, next) = arg span { _ == arg.head }
      if (next == Nil) {
        List((packed.size, arg.head))
      } else {
        List((packed.size, arg.head)) ::: encode(next)
      }
    }
  }

  def packAndEncode[T](arg: List[T]): List[(Int, T)] = {
    pack(arg).map(x => (x.length, x.head))
  }

  def decode[T](arg: List[(Int, T)]): List[T] = {
    // List.make(2,3) --> List[Int] = List(3, 3)
    arg flatMap { e => List.make(e._1, e._2) }
  }

}
