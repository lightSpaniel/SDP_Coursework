package HelloWorldWithInterface;
/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class HelloWorldDecoupledInterface {

    public static void main(String[] args){
        StandardOutMsgRenderer mr = new StandardOutMsgRenderer();
        HelloWorldMsgProvider mp = new HelloWorldMsgProvider();

        mr.setMsgProvider(mp);
        mr.render();
    }
}
