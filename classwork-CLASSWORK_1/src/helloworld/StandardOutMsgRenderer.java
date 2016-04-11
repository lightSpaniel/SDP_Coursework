package helloworld;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class StandardOutMsgRenderer {

    private HelloWorldMsgProvider msgProvider = null;

    public void render(){
        if (msgProvider==null){
        throw new RuntimeException("You must set the property msgProvider of class:"
        +StandardOutMsgRenderer.class.getName());
    }

        System.out.println(msgProvider.getMsg());
}

    public void setMsgProvider(HelloWorldMsgProvider provider){
        this.msgProvider=provider;
}

    public HelloWorldMsgProvider getMsgProvider() {
        return this.msgProvider;
    }
}