package HelloWorldSpringDIXMLConstructorArg;

/**
 * Written by jeremysmith on 19/01/2016. Copied from worksheet
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
