package NetworkPorg;

import java.net.*;
import java.util.Enumeration;

public class InternetAddressEg {
    public static void main(String[] args) {
            try {
                //get by name
                InetAddress inetAddress = InetAddress.getByName("www.google.com");
                System.out.println(inetAddress);

                //get host name
                InetAddress inethost = InetAddress.getByName("216.58.196.164");
                System.out.println(inethost.getHostName());

                //get all by name
                InetAddress[] inetAll = InetAddress.getAllByName("www.google.com");
                for (int i = 0; i < inetAll.length; i++) {
                    System.out.println("Address " + i + " "+inetAll[i]);
                }

                //get local host
                InetAddress inetlocalhost = InetAddress.getLocalHost();
                System.out.println("Local host: " + inetlocalhost);

                //get by address in byte form
                byte[] addressByte = {107, 23, (byte)216, (byte) 196};
                InetAddress inetbyte = InetAddress.getByAddress(addressByte);
                System.out.println("Get by address: "+inetbyte.getHostName());

                //get by address in byte 2 parameter
                InetAddress inetbyte2 = InetAddress.getByAddress("www.google.com",addressByte);
                System.out.println("Get by address: "+inetbyte2.getHostAddress());

                //get canonical host name
                InetAddress inetcanohost = InetAddress.getByName("216.58.196.164");
                System.out.println(inetcanohost.getCanonicalHostName());

                //get address
                InetAddress inetadd = InetAddress.getByName("216.58.196.164");
                System.out.println(inetcanohost.getAddress());

                //address type
                InetAddress inetaddtype = InetAddress.getByName("142.250.193.132");
                System.out.println("Any local address: "+inetaddtype.isAnyLocalAddress());
                System.out.println("loopback address: "+inetaddtype.isLoopbackAddress());
                System.out.println("link local address: "+inetaddtype.isLinkLocalAddress());
                System.out.println("site local address: "+inetaddtype.isSiteLocalAddress());
                System.out.println("multicast address: "+inetaddtype.isMulticastAddress());
                System.out.println("MC global address: "+inetaddtype.isMCGlobal());
                System.out.println("MC node address: "+inetaddtype.isMCNodeLocal());
                System.out.println("MC link local address: "+inetaddtype.isMCLinkLocal());
                System.out.println("MC site address: "+inetaddtype.isMCSiteLocal());
                System.out.println("MC org local address: "+inetaddtype.isMCOrgLocal());

                // is rechable
                System.out.println("rechable: "+inetaddtype.isReachable(600));

                //equals check
                InetAddress inetEquals1 = InetAddress.getByName("216.58.196.164");
                InetAddress inetEquals2 = InetAddress.getByName("216.58.196.164");
                System.out.println("is equals: "+ inetEquals1.equals(inetEquals2));
                System.out.println("hash code: "+ inetEquals1.hashCode());
                System.out.println("string: "+ inetEquals1.toString());

                //inet4address
                InetAddress inet4Address = Inet4Address.getByName("www.google.com");
                System.out.println(inet4Address);

                //inet6address
                InetAddress inet6Address = Inet6Address.getByName("www.google.com");
                System.out.println(inet6Address);

                NetworkInterface networkInterface = NetworkInterface.getByName("eth0");
                System.out.println(networkInterface);

                NetworkInterface networkInterface1 = NetworkInterface.getByInetAddress(inet4Address);
                System.out.println(networkInterface1);

                Enumeration networkInterface2 = NetworkInterface.getNetworkInterfaces();
                while (networkInterface2.hasMoreElements()){
                    System.out.println(networkInterface2.nextElement());
                }

                Enumeration enumAddress = networkInterface.getInetAddresses();
                while (enumAddress.hasMoreElements()){
                    System.out.println(enumAddress.nextElement());
                }

                System.out.println(networkInterface.getName());
                System.out.println(networkInterface.getDisplayName());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

}
