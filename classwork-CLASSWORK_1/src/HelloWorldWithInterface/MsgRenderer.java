package HelloWorldWithInterface;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public interface MsgRenderer {

    public void render();
    public void setMsgProvider(MsgProvider provider);
    public MsgProvider getMsgProvider();
}
