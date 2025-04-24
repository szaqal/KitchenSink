package szaq.fibonacci

object Fibonacci {
  
  def compute(arg: Int): Int = {
    arg match {
      case 0 => 0
      case 1 => 1
      case _ => compute(arg-1) + compute(arg-2)
    }
  }
}