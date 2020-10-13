package discordtest;

import discordtest.cfg.AuthLoader;
import discordtest.cfg.ProxyLoader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import okhttp3.OkHttpClient;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class Manager {

    private static ArrayList<JDA> bots = new ArrayList<JDA>();

    public static final OkHttpClient client = new OkHttpClient.Builder().build();

    public static void init() throws LoginException {
        for(String token : AuthLoader.getTokens()){
            JDABuilder builder = JDABuilder.createDefault(token);
            builder.setHttpClient(client.newBuilder().proxy(ProxyLoader.getNextProxy()).build());
            bots.add(builder.build());
        }
    }
}
