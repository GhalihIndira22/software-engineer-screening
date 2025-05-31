package com.bankmas.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("back")
@Slf4j
public class BackEventHandler implements VideoEventHandler {

    @Override
    public void handle(String userId) {
        log.info("[{}] Back event handled", userId);
    }

}