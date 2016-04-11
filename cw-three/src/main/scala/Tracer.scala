import java.io.File
import ConcurrentTracer._
import com.mildlyskilled.{Scene, Image, Coordinator, Trace}
import akka.actor._

/* this is the starting point  We create a Tracer, and then caller the run method inside the Tracer, passing it 6000 workers and 400 pixelsPerMessage because that is the optimized amount 
(This automatically implies that the nrOfmessages will be (totalPixels/400))
*/
object OptimizedTracerApp extends App{
  val t = new Tracer
  t.run(6000 , 400)
} 

class Tracer {
  def run(nrOfWorkers:Int , pixelsPerMessage:Int) = {
    val start: Long = System.currentTimeMillis
    val (infile, outfile) = ("src/main/resources/input.dat", "output.png")
    val scene = Scene.fromFile(infile)
    val t = new Trace
    render(scene, outfile, t.Width, t.Height)

    println("rays cast " + t.rayCount)
    println("rays hit " + t.hitCount)
    println("light " + t.lightCount)
    println("dark " + t.darkCount)

    def render(scene: Scene, outfile: String, width: Int, height: Int) = {
      val image = new Image(width, height)
      //println("Image created with width " + image.width + " and height " + image.height)
      // Init the coordinator -- must be done before starting it.
      Coordinator.init(image, outfile)

      // TODO: Start the Coordinator actor.
      val system = ActorSystem("TracerSystem")
      val listener = system.actorOf(Props[Listener], name = "listener")
      //println("actor system created, and listener: " + listener.toString)

      //make master for 20 workers and 10 messages
      val master = system.actorOf(Props(new Master(nrOfWorkers, pixelsPerMessage, listener, start)), name = "master")
      //println("master created: " + master.toString)
      master ! ProduceImage(image, scene, t, outfile)
      //println("ProduceImage message sent to master")

      //this method has been replaced by traceImagesFor in worker
      //scene.traceImage(width, height)
    }
  }
}
  
/*This object is for testing various combinations of nrOfWorkers and pixelsPerMessage. This App was used to ascertain the values for the OptimizedTracerApp above
It runs the code multiple times, with a sleep command to ensure that the tests are accurate
*/
object DurationTestingApp {
  val t = new Tracer
  
    // the workers increase as the pixelsPerMessage decrease
  for(workers <- 1 until 30000 by 5000 ){   
      println("starting app with workers: " + workers + " and pixelsPerMessage: 1")  
      t.run(workers, 1)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 20")   
      t.run(workers, 20)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 50")   
      t.run(workers, 50)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 200")   
      t.run(workers, 200)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 400")  
      t.run(workers, 400)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 800")   
      t.run(workers, 800)
      Thread.sleep(10000)
    }
      // now the workers increase as the pixelsPerMessage increase too
    for(workers <- 1 until 30000 by 5000 ){   
      println("starting app with workers: " + workers + " and pixelsPerMessage: 1")  
      t.run(workers, 800)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 20")   
      t.run(workers, 400)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 50")   
      t.run(workers, 200)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 200")   
      t.run(workers, 50)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 400")  
      t.run(workers, 20)
      Thread.sleep(10000)
      println("starting app with workers: " + workers + " and pixelsPerMessage: 800")   
      t.run(workers, 1)
      Thread.sleep(10000)
    }
  /* in the following, each level is run 3 times to get an average
  in order to pinpoint the optimal values
  */
  
  t. run(6000 , 400)
  Thread.sleep(10000)
  t. run(6000 , 400)
  Thread.sleep(10000)
  t. run(6000 , 400)
  Thread.sleep(10000)
  t. run(5000 , 400)
  Thread.sleep(10000)
  t. run(5000 , 400)
  Thread.sleep(10000)
  t. run(5000 , 400)
  Thread.sleep(10000)

}
