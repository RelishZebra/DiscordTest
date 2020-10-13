package discordtest;

import discordtest.cfg.AuthLoader;
import discordtest.cfg.ProxyLoader;
import okhttp3.OkHttpClient;

import java.util.ArrayList;

public class BotPool {

    private static ArrayList<Bot> bots = new ArrayList<Bot>();
    private static int botIndex = 0;
    private static OkHttpClient client = new OkHttpClient.Builder().build();

    public static void init(){
        for(int i = 0; i < AuthLoader.getTokens().size(); i++) {
            bots.add(new Bot(AuthLoader.getNextToken(), client.newBuilder().proxy(ProxyLoader.getNextProxy()).build()));
        }
    }

    public static Bot getNextBot(){
        botIndex = (botIndex + 1) % bots.size();
        return bots.get(botIndex);
    }

    public static Bot getCurrentBot(){
        return bots.get(botIndex);
    }

    public static class Bot{
        private String token;
        private OkHttpClient client;

        public Bot(String token, OkHttpClient client) {
            this.token = token;
            this.client = client;
        }

        public String getToken(){
            return token;
        }

        public OkHttpClient getClient(){
            return client;
        }
    }
}
