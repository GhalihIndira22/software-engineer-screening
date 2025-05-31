package com.bankmas.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("speeddown")
@Slf4j
public class SpeedDownEventHandler implements VideoEventHandler {

    @Override
    public void handle(String userId) {
        log.info("[{}] Speeding down video...", userId);
    }
}