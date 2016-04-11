package HelloWorldDecoupledwFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class MsgSupportFactory {

    private static MsgSupportFactory instance = null;
    private Properties props = null;
    private MsgRenderer renderer = null;
    private MsgProvider provider = null;

    private MsgSupportFactory(){
        props = new Properties();

        try {

            props.load(new FileInputStream("src/HelloWorldDecoupledwFactory/bean.properties"));

            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MsgRenderer) Class.forName(rendererClass).newInstance();
            provider = (MsgProvider) Class.forName(providerClass).newInstance();

        }catch(FileNotFoundException y){
            System.out.println("File not found");

        }catch(Exception x){
            System.out.println("Failed to complete factory method");
            x.printStackTrace();
        }

    }

    static {instance = new MsgSupportFactory();}

    public static MsgSupportFactory getInstance(){ return instance;}

    public MsgRenderer getMsgRenderer(){ return renderer;}

    public MsgProvider getMsgProvider(){ return provider;}


}
