package basics.lazyeval

object LazyEvaluation {

  val eagerVal = initalize;
  
  lazy val lazyVal = initalize;
  
  def initalize() {
    println("init")
  }
  
  def doStuff() = {
	println("Stuff");
	lazyVal
    6
  }

}