import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImpl extends UnicastRemoteObject implements IRemoteInterface{
    protected RemoteImpl() throws RemoteException {
    }

    @Override
    public String getHello() throws RemoteException {
        return "Hello World :)";
    }

    @Override
    public int Add(int a, int b) throws RemoteException {
        return a+b;
    }
}
