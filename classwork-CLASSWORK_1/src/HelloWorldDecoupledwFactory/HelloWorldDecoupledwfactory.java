package HelloWorldDecoupledwFactory;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class HelloWorldDecoupledwfactory {


    public static void main(String[] args) {
        MsgRenderer mr = MsgSupportFactory.getInstance().getMsgRenderer();
        MsgProvider mp = MsgSupportFactory.getInstance().getMsgProvider();

        mr.setMsgprovider(mp);
        mr.render();
    }
}
