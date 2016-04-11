import colourGuess._
import org.scalatest.FunSuite

class PegsTest extends FunSuite{

  val blueTest = blue
  test("Blue should have colour 'B'"){
    assert(blueTest.colour=='B')
  }

}

