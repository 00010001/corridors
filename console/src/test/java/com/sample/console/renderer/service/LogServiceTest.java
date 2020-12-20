package com.sample.console.renderer.service;

import com.sample.base.model.GameState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogServiceTest {

    private final LogService logService = new LogService();

    @Test
    public void shouldGetLogEntry() {
        GameState gameState = new GameState();
        assertEquals("", logService.getLogEntry(gameState, 0));
        gameState.getGameLog().add("1");
        assertEquals("1", logService.getLogEntry(gameState, 0));
        gameState.getGameLog().add("2");
        assertEquals("2", logService.getLogEntry(gameState, 0));
        assertEquals("1", logService.getLogEntry(gameState, 1));
        assertEquals("", logService.getLogEntry(gameState, 2));

    }

}