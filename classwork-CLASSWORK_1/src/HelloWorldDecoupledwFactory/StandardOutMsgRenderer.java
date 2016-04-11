package HelloWorldDecoupledwFactory;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class StandardOutMsgRenderer implements MsgRenderer{

    private MsgProvider msgProvider = null;
    @Override
    public void render(){
        if (msgProvider==null){
            throw new RuntimeException("You must set the property msgProvider of class:"
                    +StandardOutMsgRenderer.class.getName());
        }

        System.out.println(msgProvider.getMsg());
    }
    @Override
    public void setMsgprovider(MsgProvider provider){
        this.msgProvider=provider;
    }
    @Override
    public MsgProvider getMsgProvider() {
        return this.msgProvider;
    }
}
