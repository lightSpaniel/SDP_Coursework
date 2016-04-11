package HelloWorldSpringDI;

/**
 * Created by jeremysmith on 19/01/2016.
 */
public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
