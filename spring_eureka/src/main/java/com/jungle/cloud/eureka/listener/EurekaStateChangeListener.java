package com.jungle.cloud.eureka.listener;


import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EurekaStateChangeListener {


    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info("{} \t  {} 服务下线", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo info = event.getInstanceInfo();
        log.info("{}:{} \t  {} 服务上线", info.getIPAddr(), info.getPort(), info.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info("{} \t  {} 服务续约", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("Eureka 注册中心  启动成功");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("Eureka Server 启动成功");
    }
}
