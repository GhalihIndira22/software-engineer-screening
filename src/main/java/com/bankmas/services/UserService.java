package com.bankmas.services;

import com.bankmas.scaling.ScalingManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;

    private final ScalingManager scalingManager;
    private final VideoWatchService videoWatchService;
    private static final AtomicInteger userCounter = new AtomicInteger(ONE);

    public void addUsers(Integer count) {
        for (Integer i = ZERO; i < count; i++) {
            String userId = "user - " + userCounter.getAndIncrement();
            ExecutorService executor = Executors.newSingleThreadExecutor();
            scalingManager.trackUser(userId);

            executor.submit(() -> videoWatchService.simulateWatch(userId));
        }
    }
}
