/*package ConcurrentTracer

import akka.actor._
import com.mildlyskilled.{Scene, Image, Coordinator, Trace}

object ConcurrentTracer extends App{

	val(infile , outfile) = ("src/main/resources/input.dat", "output.png")
	val scene = Scene.fromFile(infile)
	val t = new Trace
	render(scene, outfile, t.Width, t.Height, 20, 10)

//nrofMessages determined by height, width and rowsPerMessage
	def render(scene:Scene, outfile:String, width:Int, height:Int, nrOfWorkers:Int, rowsPerMessage:Int) = {
		val image = new Image(width, height)
		val system = ActorSystem("TracerSystem")
		val listener = system.actorOf(Props[Listener], name = "listener")
		val master = system.actorOf(Props(new Master(nrOfWorkers, rowsPerMessage, listener)), name = "master")

		master ! ProduceImage(image, scene, outfile)
	}

}
*/