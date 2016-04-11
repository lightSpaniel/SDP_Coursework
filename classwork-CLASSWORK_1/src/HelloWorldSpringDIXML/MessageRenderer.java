package HelloWorldSpringDIXML;

/**
 * Created by jeremysmith on 19/01/2016.
 */
public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider provider);
}
