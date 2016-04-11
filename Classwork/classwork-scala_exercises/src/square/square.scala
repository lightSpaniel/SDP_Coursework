package square


class square {

  def squareThem(nums: Int*):Int ={
    var result = 0
    val numList = List(nums)

    for(num<-nums){
      result += num * num
    }

    result
  }
}
