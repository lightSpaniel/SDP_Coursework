package classargs


class Family(persons:String*) {

  val personArgs = persons
  var count = 0

  personArgs.foreach(person=>count+=1)

  def familySize():Int={count}

}

class FamilyWithParents(mum: String, dad: String, children:String*) {

  var count = 0
  val mother = mum
  val father = dad

  if(mother!=null){count+=1}
  if(father!=null){count+=1}

  val childrenNum = children


  childrenNum.foreach(person=>count+=1)

  def familySize():Int={count}

}
