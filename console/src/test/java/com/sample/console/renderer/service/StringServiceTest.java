package com.sample.console.renderer.service;

import com.sample.console.renderer.ConsoleRendererProperties;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringServiceTest {

    StringService stringService = new StringService();

    @Test
    public void formatEvenStringForConsole() {
        String even = "abcd";
        assertEquals(ConsoleRendererProperties.CONSOLE_MAX_WIDTH, stringService.formatStringForConsole(even).length());
    }

    @Test
    public void formatOddStringForConsole() {
        String odd = "abc";
        assertEquals(ConsoleRendererProperties.CONSOLE_MAX_WIDTH, stringService.formatStringForConsole(odd).length());
    }
}