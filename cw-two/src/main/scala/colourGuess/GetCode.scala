package colourGuess

object GetCode{
  /*
  in order to increase the range of colours:
  1. change this value
  2. Add to the above list of case classes.
  3. Add to the match
   */
  val NUMBER_OF_COLOURS = 6

  def shapeFactory(numOfPegs:Int=4):String= {
    //Start with Stringbuilder (mutable string)
    //which we add characters to
    val secretCode = new StringBuilder

    val range = 1 to numOfPegs

    //Loop through length of user defined length of string
    //to add randomly selected colour object colour chars to
    //that string
    for (num <- range) {

      val rand = ((Math.random * NUMBER_OF_COLOURS )+1).toInt

      rand match {
        case 1 => secretCode += blue.colour
        case 2 => secretCode += green.colour
        case 3 => secretCode += orange.colour
        case 4 => secretCode += purple.colour
        case 5 => secretCode += red.colour
        case 6 => secretCode += yellow.colour
      }
    }
    secretCode.toString()
  }
}

