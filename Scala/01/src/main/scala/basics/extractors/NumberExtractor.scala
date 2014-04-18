package basics.extractors

object NumberExtractor {

  def apply(x: Int): Int = x;

  def unapply(x: Int): Option[Int] = Option(x)
}