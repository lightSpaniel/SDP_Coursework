package ConcurrentTracer

import akka.actor._
import com.mildlyskilled.{Scene, Image, Coordinator, Trace}
import scala.concurrent.duration._

class Listener extends Actor with ActorLogging{
	def receive = {
		case ReadyToPrint(nrOfWorkers, pixelsPerMessage, duration) => 
			println("workers: " + nrOfWorkers + "  pixelsPerMessage: " + pixelsPerMessage + "  duration: " + duration)
			Coordinator.print
			context.system.terminate()
	}
}