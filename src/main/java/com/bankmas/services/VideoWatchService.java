package com.bankmas.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoWatchService {

    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer THREE = 3;
    private static final Integer FIVE = 5;
    private static final Integer SLEEP_SHORT = 2000;
    private static final Integer SLEEP_MEDIUM = 3000;
    private static final Integer SLEEP_LONG = 10000;

    private static final String ACTION_PLAY = "play";
    private static final String ACTION_FORWARD = "forward";
    private static final String ACTION_CONTINUE = "continue";
    private static final String ACTION_STOP = "stop";
    private static final String ACTION_SPEED_UP = "speedup";
    private static final String ACTION_SPEED_DOWN = "speeddown";
    private static final String ACTION_BACK = "back";

    private final EventDispatcherService dispatcher;

    public void simulateWatch(String userId) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            try {
                Integer videoCount = ONE;
                log.info("[{}] Starting video #{}", userId, videoCount);

                dispatcher.dispatch(ACTION_PLAY, userId);
                for (Integer i = ZERO; i < THREE; i++) {
                    Thread.sleep(SLEEP_MEDIUM);
                    dispatcher.dispatch(ACTION_FORWARD, userId);
                    Thread.sleep(SLEEP_SHORT);
                    dispatcher.dispatch(ACTION_SPEED_UP, userId);
                }
                Thread.sleep(SLEEP_LONG);
                dispatcher.dispatch(ACTION_CONTINUE, userId);
                Thread.sleep(SLEEP_SHORT);
                dispatcher.dispatch(ACTION_BACK, userId);
                Thread.sleep(SLEEP_MEDIUM);
                dispatcher.dispatch(ACTION_SPEED_DOWN, userId);
                Thread.sleep(SLEEP_SHORT);
                dispatcher.dispatch(ACTION_STOP, userId);

                log.info("[{}] Finished watching video #{}", userId, videoCount);
            } catch (InterruptedException e) {
                log.warn("[{}] Stopped watching due to interruption", userId);
                Thread.currentThread().interrupt();
                scheduler.shutdown();
            }
        }, ZERO, FIVE, TimeUnit.SECONDS);
    }
}