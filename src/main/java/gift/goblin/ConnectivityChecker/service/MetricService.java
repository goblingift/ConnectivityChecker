/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gift.goblin.ConnectivityChecker.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

/**
 *
 * @author andre
 */
@Component
public class MetricService {

    private final Counter failedConnectionCounter;
    private final Counter sumConnectionCounter;
    
    public MetricService(MeterRegistry meterRegistry) {
        this.failedConnectionCounter = meterRegistry.counter("failedConnections");
        this.sumConnectionCounter = meterRegistry.counter("sumConnections");
    }
    
    public void triggerMetricsConnectivity(boolean successful) {
        if (successful) {
            sumConnectionCounter.increment();
        } else {
            failedConnectionCounter.increment();
        }
    }
    
}
