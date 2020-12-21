package com.sample.console.renderer.service;

import java.io.InputStream;

import static com.sample.base.ErrorMessages.FILE_NOT_FOUND;

public class FileService {

    public InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new RuntimeException(FILE_NOT_FOUND + fileName);
        } else {
            return inputStream;
        }

    }

}
