import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        IRemoteInterface stub = (IRemoteInterface) Naming.lookup("rmi://localhost/helloRemote");
        System.out.println(stub.getHello());
        System.out.println(stub.Add(1,2));
    }
}
