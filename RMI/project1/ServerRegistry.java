import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRegistry {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            RemoteImpl obj = new RemoteImpl();
            Naming.bind("helloRemote", obj);
            System.out.println("Server is ready");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
