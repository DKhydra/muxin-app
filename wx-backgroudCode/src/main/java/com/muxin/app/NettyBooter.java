package com.muxin.app;

import com.muxin.app.netty.WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * netty 启动
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {




    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            try {
                WSServer.getInstance().start();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
