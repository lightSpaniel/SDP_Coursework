package NamedAndDefault


class Item(name: String, price: Double) {
  val this.price = price
  val this.name = name

  def cost(grocery: Boolean=false,
           medication: Boolean=false,
           rate: Double=0.10): Double ={
    if ((grocery==true) || (medication==true)){
      return this.price
    }else{
      val taxPrice = this.price + (this.price*rate)
      return taxPrice
    }
  }
}

