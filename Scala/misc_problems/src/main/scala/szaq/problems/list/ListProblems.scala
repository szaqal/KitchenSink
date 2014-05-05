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
  
  def reverse[T](arg: List[T]):List[T] = arg match {
    case Nil => List()
    case head :: tail => reverse(tail) ::: List(head)
    case _ => List();
  }

}
