package com.galih.software.engineer.screening.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("play")
@Slf4j
public class PlayEventHandler implements VideoEventHandler {

    @Override
    public void handle(String userId) {
        log.info("[{}] Playing video...", userId);
    }

}