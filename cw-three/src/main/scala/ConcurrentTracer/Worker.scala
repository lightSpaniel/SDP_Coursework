package ConcurrentTracer

import akka.actor.{Actor, ActorRef, Props, ActorLogging}
import com.mildlyskilled._

class Worker extends Actor with ActorLogging{
	def receive = {
		case Work(image, scene, t, row, startingPixel, nrOfPixels, cosf, sinf, ss) =>
			//println("Worker has received message from master asking to trace images for row " + start + " to row " + (start + rowsPerMessage))
			// we use the helper method to compute images and return them to master
			traceImagesFor(image, scene, t, row, startingPixel, nrOfPixels, cosf, sinf, ss)
			sender ! Result
	}

	def traceImagesFor(image:Image, scene:Scene, t:Trace, y:Int, startingPixel:Int , nrOfPixels:Int, cosf:Float, sinf:Float, ss:Int) = {
		//need to implement using the original code
		// no need for y loop as y is constant here - ie we stay on the same row for this message
			for (x <- startingPixel until (startingPixel + nrOfPixels)) {
				//copy in from original scene.traceImage(width, height) method
				var colour = Colour.black

		        for (dx <- 0 until ss) {
		          for (dy <- 0 until ss) {

		            // Create a vector to the pixel on the view plane formed when
		            // the eye is at the origin and the normal is the Z-axis.
		            val dir = Vector(
		              (sinf * 2 * ((x + dx.toFloat / ss) / image.width - .5)).toFloat,
		              (sinf * 2 * (image.height.toFloat / image.width) * (.5 - (y + dy.toFloat / ss) / image.height)).toFloat,
		              cosf.toFloat).normalized

		            val c = scene.trace(Ray(scene.eye, dir)) / (ss * ss) // only do once
		            colour += c
		          }
		        }
		        if (Vector(colour.r, colour.g, colour.b).norm < 1)
          			t.darkCount += 1
        		if (Vector(colour.r, colour.g, colour.b).norm > 1)
          			t.lightCount += 1

        		Coordinator.set(x, y, colour)
			}
	}
}