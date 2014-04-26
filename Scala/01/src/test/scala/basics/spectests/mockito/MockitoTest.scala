package basics.spectests.mockito

import org.mockito.Matchers._
import org.specs2.mutable._
import org.specs2.mock.Mockito
import basics.mockito.EchoSample

/**
 *
 * see more https://code.google.com/p/specs/wiki/UsingMockito
 */
object MockitoTest extends Specification with Mockito {

  val echo = mock[EchoSample];

  echo.echo("sss") returns "SSS"

  echo.echo("sss")

  there was one(echo).echo("sss")

}