package counter


class Counter(start: Int){

  private var result = start

  def inc(num: Int=1): Counter ={
    val result  = start + num
    new Counter(result)
  }

  def dec(num: Int=1): Counter = {
    val result = start - num
    new Counter(result)
  }

  def count(): Int={
    result
  }

  def adjust(adder: Adder): Counter ={

    val counter = new Counter(adder.add(count()))
    return counter
  }

}

class Adder(amount: Int){
  def add(in: Int) = in + amount
}

object Counter {
  def main(args: Array[String]){
      var count = new Counter(10)
      val adder = new Adder(5)
      count = count.adjust(adder)
      println(count.count())
  }
}


