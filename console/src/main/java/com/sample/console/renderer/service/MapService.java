package com.sample.console.renderer.service;

import java.io.InputStream;

public class MapService {

    private FileService fileService;

    private String fileName = "txt/map.txt";

    public void loadMap() {
        InputStream fileFromResourceAsStream = fileService.getFileFromResourceAsStream(fileName);

    }
}
