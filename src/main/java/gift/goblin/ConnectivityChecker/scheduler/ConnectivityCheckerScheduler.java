/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gift.goblin.ConnectivityChecker.scheduler;

import gift.goblin.ConnectivityChecker.service.MetricService;
import gift.goblin.ConnectivityChecker.service.PingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author andre
 */
@Component
public class ConnectivityCheckerScheduler {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    MetricService metricService;
    
    @Autowired
    PingService PingService;
    
    @Scheduled(fixedRate = 30_000)
    public void triggerScheduler() {
        logger.info("Triggered connectivity scheduler!");
        boolean checkConnection = PingService.checkConnection();
        metricService.triggerMetricsConnectivity(checkConnection);
    }
    
}
