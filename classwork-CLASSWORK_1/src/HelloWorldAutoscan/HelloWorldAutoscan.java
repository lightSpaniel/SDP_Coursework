package HelloWorldAutoscan;

/**
 * Created by jeremysmith on 19/01/2016.
 */
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloWorldAutoscan {
    public static void main(String[] args) throws Exception {

        // get the bean factory
        BeanFactory factory = getBeanFactory();
        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws Exception {
        // create a bean factory from anno.xml
        BeanFactory factory = new ClassPathXmlApplicationContext("autoscan.xml");
        return factory;
    }
}
