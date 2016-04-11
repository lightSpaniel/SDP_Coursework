package HelloWorldDecoupledwFactory;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public interface MsgRenderer {
    void render();
    MsgProvider getMsgProvider();
    void setMsgprovider(MsgProvider provider);
}
