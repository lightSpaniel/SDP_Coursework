package HelloWorldSpringDIXMLConstructorArg;

/**
 * Written by jeremysmith on 19/01/2016. Copied from worksheet
 */
public interface MessageRenderer {

    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider provider);
}
