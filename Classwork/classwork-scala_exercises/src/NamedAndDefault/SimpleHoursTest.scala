package NamedAndDefault


import atomic.AtomicTest._

object SimpleHoursTest extends App{

  val t = new SimpleTime(hours=5, minutes=30)

  t.gethours() is 5
  t.getminutes() is 30


}
