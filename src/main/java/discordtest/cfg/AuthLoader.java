package discordtest.cfg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Scanner;

public class AuthLoader {

    private static ArrayList<String> tokens;
    private static int tokenCounter = 0;

    public static void init(){
        File configFile = new File("config\\bots.txt");
        try {
            configFile.getParentFile().mkdir();
            if(!configFile.exists()){
                configFile.createNewFile();
                return;
            }
            Scanner sc = new Scanner(configFile);

            while(sc.hasNext()){
                tokens.add(sc.nextLine());
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getTokens(){
        return tokens;
    }

    public static String getNextToken(){
        String tok = tokens.get(tokenCounter);
        tokenCounter = (tokenCounter + 1) % tokens.size();
        return tok;
    }

}
