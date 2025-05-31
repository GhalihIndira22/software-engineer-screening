package com.bankmas.scaling;

import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.lang.management.ManagementFactory;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

@Component
@Slf4j
public class ScalingManager {

    private final Set<String> activeUsers = new HashSet<>();

    private static final Double CPU_THRESHOLD = 0.5; // 50%
    private static final Double MEMORY_THRESHOLD = 0.7; // 70%
    private static final Double ONE_POINT_ZERO = 1.0;
    private static final Integer ONE_HUNDRED = 100;
    private static final Long ONE = 1L;
    private static final Long TEN = 10L;

    private final OperatingSystemMXBean osBean =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public void trackUser(String userId) {
        activeUsers.add(userId);
        log.info("Tracking user: {}", userId);
        checkResourceUsage();
    }

    @PostConstruct
    private void startResourceMonitor() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::checkResourceUsage, ONE, TEN, TimeUnit.SECONDS);
    }

    private void checkResourceUsage() {
        double cpuLoad = osBean.getCpuLoad(); // 0.0 to 1.0
        long freeMemory = osBean.getFreeMemorySize();
        long totalMemory = osBean.getTotalMemorySize();
        double memoryUsage = ONE_POINT_ZERO - ((double) freeMemory / totalMemory);

        log.info("📊 CPU Usage: {}%, Memory Usage: {}%", String.format("%.2f", cpuLoad * ONE_HUNDRED), String.format("%.2f", memoryUsage * ONE_HUNDRED));

        if (cpuLoad > CPU_THRESHOLD || memoryUsage > MEMORY_THRESHOLD) {
            log.warn("⚠️ [Auto-scaling] Resource usage high. Simulating scale-out...");
        }
    }
}