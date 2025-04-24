package szaq.factorial

object Factorial {

  def compute(arg: Int): Int = {
    arg match {
      case 0 => 1
      case _ => arg * compute(arg-1)
    }
  }
}