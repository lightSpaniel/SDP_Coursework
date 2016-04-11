package HelloWorldSpringDIXMLConstructorArg;

/**
 * Written by jeremysmith on 19/01/2016. Copied from worksheet
 */
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringDIXMLConstructorArg {

    public static void main(String[] args) throws Exception{

        BeanFactory factory = getBeanFactory();
        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws Exception {

        BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
        return factory;
    }
}
