package square

import atomic.AtomicTest._

object SquareThemTest extends App{

  var sqr = new square()
  sqr.squareThem(2) is 4
  sqr.squareThem(2, 4) is 20
  sqr.squareThem(1, 2, 4) is 21

}

