package colourGuess

sealed trait peg{
  val colour: Char
}
//case object easy to use, just needs a character value
case object blue extends peg{
  val colour = 'B'}
case object green extends peg{
  val colour = 'G'}
case object orange extends peg{
  val colour = 'O'}
case object purple extends peg{
  val colour = 'P'}
case object red extends peg{
  val colour = 'R'}
case object yellow extends peg{
  val colour = 'Y'}

