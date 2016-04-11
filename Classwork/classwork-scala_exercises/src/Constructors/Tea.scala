package Constructors


class Tea (decaf: Boolean=false,
           milk: Boolean=false,
           sugar: Boolean=false,
           name: String="Earl Grey"){
  val this.decaf = decaf
  val this.milk = milk
  val this.sugar = sugar
  val this.name = name

  def describe(): String ={
    var desc = this.name

    if(decaf){desc += " decaf"}
    if(milk){desc += " + milk"}
    if(sugar){desc += " + sugar"}

    desc
  }

  def calories(): Int ={

    var cals = 0

    if(sugar){cals +=16}
    if(milk){cals +=100}
    cals
  }


}
