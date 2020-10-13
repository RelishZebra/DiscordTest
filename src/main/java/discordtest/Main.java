package discordtest;

import discordtest.cfg.AuthLoader;
import discordtest.cfg.ProxyLoader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.utils.ConcurrentSessionController;
import net.dv8tion.jda.internal.utils.config.AuthorizationConfig;
import net.dv8tion.jda.internal.utils.config.SessionConfig;
import net.dv8tion.jda.internal.utils.config.ThreadingConfig;

import javax.security.auth.login.LoginException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    private static JDA jda;

    public static void main(String[] args) throws LoginException, InterruptedException {
        AuthLoader.init();
        ProxyLoader.init();
        BotPool.init();
        jda = new JDACustom(null, null, null, null);
    }

//    private static void initCustomJDA(){
//        jda = new JDACustom(null,null,null,null);
//
//        AuthorizationConfig authConfig = new AuthorizationConfig(BotPool.getCurrentBot().getToken());
//
//        ThreadingConfig threadingConfig = new ThreadingConfig();
//
//        ExecutorService callbackPool = null;
//        boolean shutdownCallbackPool = true;
//        threadingConfig.setCallbackPool(callbackPool, shutdownCallbackPool);
//
//        ScheduledExecutorService mainWsPool = null;
//        boolean shutdownMainWsPool = true;
//        threadingConfig.setGatewayPool(mainWsPool, shutdownMainWsPool);
//
//        ScheduledExecutorService rateLimitPool = null;
//        boolean shutdownRateLimitPool = true;
//        threadingConfig.setRateLimitPool(rateLimitPool, shutdownRateLimitPool);
//
//        ExecutorService eventPool = null;
//        boolean shutdownEventPool = true;
//        threadingConfig.setEventPool(eventPool, shutdownEventPool);
//
//         ConcurrentSessionController controller = new ConcurrentSessionController();
//
//        SessionConfig sessionConfig = new SessionConfig(controller, httpClient, wsFactory, voiceDispatchInterceptor, flags, maxReconnectDelay, largeThreshold);
//
//        setMemberCachePolicy(MemberCachePolicy.DEFAULT)
//                .setChunkingFilter(ChunkingFilter.NONE)
//                .disableCache(CacheFlag.CLIENT_STATUS, CacheFlag.ACTIVITY)
//                .setLargeThreshold(250);
//}
}
