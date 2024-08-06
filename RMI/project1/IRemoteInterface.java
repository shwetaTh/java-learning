import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteInterface extends Remote {
    String getHello()throws RemoteException;
    int Add(int a, int b) throws RemoteException;
}
