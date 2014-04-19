package basics.json
import com.codahale.jerkson.Json._

object JsonParse {

  val json = """{"a":"a"}"""

  def getKeys = parse[Map[String,String]](json);
}