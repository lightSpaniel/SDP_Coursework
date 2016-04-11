package HelloWorldSpring;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
