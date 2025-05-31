package com.bankmas.services;

import com.bankmas.event.VideoEventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventDispatcherService {

    private final Map<String, VideoEventHandler> handlers;

    public void dispatch(String action, String userId) {
        Optional.ofNullable(handlers.get(action))
                .ifPresentOrElse(
                        handler -> handler.handle(userId),
                        () -> log.info("No handler registered for action: {}", action)
                );
    }
}