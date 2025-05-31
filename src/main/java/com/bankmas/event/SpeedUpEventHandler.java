package com.bankmas.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("speedup")
@Slf4j
public class SpeedUpEventHandler implements VideoEventHandler {

    @Override
    public void handle(String userId) {
        log.info("[{}] Speeding up video...", userId);
    }

}