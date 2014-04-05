package basics.optionals

object OptionalSample {

  def sampleSome(arg: String): Option[String] = Some(arg);
  
  def sampleNone(arg: String): Option[String] = None;
  
}