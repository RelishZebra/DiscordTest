package discordtest;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.internal.requests.Requester;

public class RequesterCustom extends Requester {

    public RequesterCustom(JDA api) {
        super(api);
    }

    @Override
    public Long execute(Request<?> apiRequest, boolean retired, boolean handleOnRateLimit) {
        BotPool.Bot bot = BotPool.getNextBot();
        ((JDACustom)api).setCurrentBot(bot);
        return super.execute(apiRequest, retired, handleOnRateLimit);
    }
}
