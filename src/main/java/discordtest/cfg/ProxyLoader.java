package discordtest.cfg;

import com.sun.deploy.net.proxy.ProxyType;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class ProxyLoader {

    private static ArrayList<Proxy> proxies;
    private static int proxyCounter = 0;

    public static void init(){
        File configFile = new File("config\\proxies.txt");
        try {
            configFile.getParentFile().mkdir();
            if(!configFile.exists()){
                configFile.createNewFile();
                return;
            }
            Scanner sc = new Scanner(configFile);

            while(sc.hasNext()){
                String addr = sc.next();
                int port = sc.nextInt();
                sc.nextLine();
                SocketAddress sa = new InetSocketAddress(addr, port);
                Proxy p = new Proxy(Proxy.Type.SOCKS, sa);
                proxies.add(p);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Proxy> getProxies(){
        return proxies;
    }

    public static Proxy getNextProxy(){
        Proxy p = proxies.get(proxyCounter);
        proxyCounter = (proxyCounter + 1) % proxies.size();
        return p;
    }

}
