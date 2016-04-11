package HelloWorldSpring;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public interface MessageRenderer {
    void render();
    MessageProvider getMessageProvider();
    void setMessageProvider(MessageProvider provider);
}
