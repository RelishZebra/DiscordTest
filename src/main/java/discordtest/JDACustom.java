package discordtest;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.utils.config.AuthorizationConfig;
import net.dv8tion.jda.internal.utils.config.MetaConfig;
import net.dv8tion.jda.internal.utils.config.SessionConfig;
import net.dv8tion.jda.internal.utils.config.ThreadingConfig;
import okhttp3.OkHttpClient;

public class JDACustom extends JDAImpl {

    private BotPool.Bot currentBot;

    public JDACustom(AuthorizationConfig authConfig, SessionConfig sessionConfig, ThreadingConfig threadConfig, MetaConfig metaConfig) {
        super(authConfig, sessionConfig, threadConfig, metaConfig);
        this.requester = new RequesterCustom(this);
    }

    @Override
    public String getToken() {
        return currentBot.getToken();
    }

    @Override
    public OkHttpClient getHttpClient() {
        return currentBot.getClient();
    }

    public void setCurrentBot(BotPool.Bot bot){
        currentBot = bot;
    }
}
