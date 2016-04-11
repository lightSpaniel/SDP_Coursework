package HelloWorldSpring;

import java.io.FileInputStream;
import java.util.Properties;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class HelloWorldSpring {
    public static void main(String[] args) throws Exception{
        BeanFactory factory = getBeanFactory();

        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        MessageProvider mp = (MessageProvider) factory.getBean("provider");

        mr.setMessageProvider(mp);
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws Exception {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(factory);
        Properties props = new Properties();
        props.load(new FileInputStream("/Users/jeremysmith/IdeaProjects/helloWorld/src/HelloWorldSpring/beans.properties"));

        rdr.registerBeanDefinitions(props);

        return factory;
    }

}
