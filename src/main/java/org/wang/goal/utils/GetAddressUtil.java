package org.wang.goal.utils;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class GetAddressUtil implements ApplicationListener<WebServerInitializedEvent> {

    public static String getAddress(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return address.getHostAddress();
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {

    }
}
