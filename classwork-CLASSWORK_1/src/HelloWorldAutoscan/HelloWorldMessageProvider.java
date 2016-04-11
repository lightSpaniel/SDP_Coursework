package HelloWorldAutoscan;

/**
 * Created by jeremysmith on 19/01/2016.
 */
import org.springframework.stereotype.Component;

public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World! --- with Autoscan! How does that work?";
    }

}
