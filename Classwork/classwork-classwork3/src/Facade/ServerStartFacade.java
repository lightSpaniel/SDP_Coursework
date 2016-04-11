package Facade;

//Sparse implementation
public class ServerStartFacade {

    StartServer server;

    public void startServer(){

        StartServer server = new StartServer();
        this.server=server;

        server.startBooting();
        server.readSystemConfigFile();
        server.init();
        server.initializeContext();
        server.initializeListeners();
        server.destoryListeners();
        server.createSystemObjects();
        System.out.println("Start working......");
        System.out.println("After work done.......");
    }

    public void stopServer(){

        server.releaseProcesses();
        server.destory();
        server.destroySystemObjects();
        server.destoryListeners();
        server.destoryContext();
        server.shutdown();

    }
}
