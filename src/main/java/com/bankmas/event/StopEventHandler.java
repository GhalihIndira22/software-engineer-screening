package com.bankmas.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("stop")
@Slf4j
public class StopEventHandler implements VideoEventHandler {

    @Override
    public void handle(String userId) {
        log.info("[{}] Stop event handled", userId);
    }

}