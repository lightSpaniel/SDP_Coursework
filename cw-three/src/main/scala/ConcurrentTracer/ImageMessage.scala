package ConcurrentTracer

import akka.actor._
import com.mildlyskilled.{Scene, Image, Coordinator, Trace}
import scala.concurrent.duration._

sealed trait ImageMessage
case class ProduceImage(image:Image, scene:Scene, t:Trace, outfile : String) extends ImageMessage
case class Work(image:Image, scene:Scene, t:Trace, row:Int, startingPixel:Int , nrOfPixels:Int, cosf:Float, sinf:Float, ss:Int) extends ImageMessage
case object Result extends ImageMessage
case class ReadyToPrint(nrOfWorkers:Int, pixelsPerMessage:Int, duration: Duration) extends ImageMessage