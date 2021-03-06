package classargs

import atomic.AtomicTest._

object TestArgs extends App {
  val family1 = new Family("Mum", "Dad", "Sally", "Dick")
  family1.familySize() is 4

  val family2 = new Family("Dad", "Mom", "Harry")
  family2.familySize() is 3

  val family3 = new FamilyWithParents("Mum", "Dad", "Sally", "Dick")
  family1.familySize() is 4

  val family4 = new FamilyWithParents("Dad", "Mom", "Harry")
  family2.familySize() is 3


}

