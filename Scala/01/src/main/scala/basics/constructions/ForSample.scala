package basics.constructions

object ForSample {

  def doFilter(x: List[Int]): Int = {
    val result = for (arg <- x if arg > 5) yield arg
    result.size
  }
}