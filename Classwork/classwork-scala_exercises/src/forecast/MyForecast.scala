package forecast


class MyForecast {

  def forecast(temp: Int): Unit ={

    temp match{
      case 100 => println("Sunny")
      case 80 => println("Mostly Sunny")
      case 50 => println("Partly Sunny")
      case 20 => println("Mostly Cloudy")
      case 0 => println("Cloudy")
      case _ => println("Unknown")

    }

  }

}

object run{

  def main(args: Array[String]){
    val sunnyData = Vector(100, 80, 50, 20, 0, 15)
    val myForecast = new MyForecast
    for(temp <- sunnyData){myForecast.forecast(temp)}
  }

}

