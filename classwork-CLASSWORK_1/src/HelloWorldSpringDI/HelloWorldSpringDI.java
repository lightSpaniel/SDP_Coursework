package HelloWorldSpringDI;

/**
 * Written by jeremysmith on 19/01/2016.Copied from worksheet
 */
import java.io.FileInputStream;
import java.util.Properties;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;



public class HelloWorldSpringDI {

    public static void main(String args[])throws Exception {

        BeanFactory factory = getBeanFactory();
        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }

        private static BeanFactory getBeanFactory() throws Exception{
        //Instantiates a bean factory
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //Gets properties reader to read from properties file
        PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(factory);

        //Load properties
        Properties props = new Properties();
        props.load(new FileInputStream("/Users/jeremysmith/IdeaProjects/helloWorld/src/HelloWorldSpringDI/beans.properties"));
        rdr.registerBeanDefinitions(props);

        return factory;

    }


    }


