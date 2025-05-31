package com.bankmas.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("forward")
@Slf4j
public class ForwardEventHandler implements VideoEventHandler {

    @Override
    public void handle(String userId) {
        log.info("[{}] Forward event handled", userId);
    }

}