package basics.functions

object FunctionComposition {
  val doubleVal = (arg: Int) => arg * 2
  val tripleVal = (arg: Int) => arg * 3
  
  //f(g(x))
  val composed = doubleVal compose tripleVal
  
  //g(f(x))
  val composed2 = doubleVal andThen tripleVal
  
  def computeComposed = composed(2)
  
  def computeComposed2 = composed2(2)
}