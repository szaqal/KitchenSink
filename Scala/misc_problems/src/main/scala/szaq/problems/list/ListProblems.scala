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

}