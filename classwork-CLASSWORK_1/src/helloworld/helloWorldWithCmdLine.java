package helloworld;

/**
 * Written by jeremysmith on 18/01/2016.Copied from worksheet
 */
public class helloWorldWithCmdLine {

    public static void main(String[] args){

        if(args.length>0){
            System.out.println(args[0]);
        }else{
            System.out.println("Hello World");
        }

    }
}
