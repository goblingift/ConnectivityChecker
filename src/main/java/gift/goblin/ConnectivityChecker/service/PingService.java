/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gift.goblin.ConnectivityChecker.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service which ping specific address to check if connectivity is there.
 *
 * @author andre
 */
@Service
public class PingService {

    @Value("${ping.targeturl}")
    private String targetUrl;
    
    @Value("${ping.timeoutSeconds}")
    private int timeout;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public boolean checkConnection() {
        
        boolean result = false;
        
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(targetUrl, 80), timeout * 1000);
            result = true;
        } catch (Exception e) {
            logger.warn("Couldnt resolve hostname, looks like internet is down: {}", targetUrl);
        } 
        
        return result;
    }
    
}
