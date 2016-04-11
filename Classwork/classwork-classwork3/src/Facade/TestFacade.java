package Facade;

public class TestFacade {

    public static void main(String args[]){

        ServerStartFacade facade = new ServerStartFacade();
        //This is all the client needs to start and stop a server instance
        facade.startServer();
        facade.stopServer();
    }
}
