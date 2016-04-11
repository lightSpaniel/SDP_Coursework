package ConcurrentTracer

import akka.actor.{Actor, ActorRef, Props, ActorLogging}
import akka.routing.{ ActorRefRoutee, RoundRobinRoutingLogic,BalancingPool, Router }
import com.mildlyskilled.{Scene, Image, Coordinator, Trace}

import scala.concurrent.duration._

class Master(nrOfWorkers:Int, pixelsPerMessage:Int, listener:ActorRef, start:Long) extends Actor with ActorLogging{
	
	//val start: Long = System.currentTimeMillis
	val messagesPerRow = 800 / pixelsPerMessage
	val nrOfMessages = messagesPerRow * 600
	var nrOfResults:Int = 0
	
  	val router = context.actorOf(Props[Worker].withRouter(BalancingPool(nrOfWorkers)), name = "router")
  	
	def receive = {
		case ProduceImage(image, scene, t,  outfile) => 
			//println("message received by master from system")
			//do the stuff that only needs to be done once through helper method
			val frustum = (.5 * scene.angle * math.Pi / 180).toFloat
        	val cosf = math.cos(frustum).toFloat //made sure it's a float
        	val sinf = math.sin(frustum).toFloat //made sure it's a float
        	val ss = t.AntiAliasingFactor 
        	//println("The antialiasingfactor is ss = " + ss)
			//send each message, with the required starting row and nrOfRows
			//this is sent to the worker here, but will be deleted and sent to router
			for(i <- 0 until t.Height){ // for each row
				for(j <- 0 until messagesPerRow) { // for each message on that row
					//println("Master is about to send message " + i + " to the worker")
					// tell router to start at the pixel where the last message finished
					router ! Work(image, scene, t, i, j * pixelsPerMessage , pixelsPerMessage, cosf, sinf, ss)
				}
			}

		case Result =>
		// we receive list of images- one for each pixel- and append to results list
			nrOfResults += 1
			// if all messages have been returned, we compute the final image 
			// and send to listener
			if(nrOfResults == nrOfMessages)
				listener ! ReadyToPrint(nrOfWorkers, pixelsPerMessage, duration = (System.currentTimeMillis - start) millis)
		}
		// method for computing the final image once all images are created
}
