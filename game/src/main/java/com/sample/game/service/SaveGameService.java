package com.sample.game.service;

import com.sample.base.model.GameState;
import com.sample.game.AppParameters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveGameService {

    private boolean saveFileWasCreated;

    public void saveGame(GameState gameState) {

        ObjectOutputStream o;
        try (FileOutputStream f = new FileOutputStream(new File(AppParameters.SAVE_FILE))) {
            o = new ObjectOutputStream(f);
            o.writeObject(gameState);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createSaveFileIfNotExists() {
        try {
            saveFileWasCreated = new File(AppParameters.SAVE_FILE).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isSaveFileWasCreated() {
        return saveFileWasCreated;
    }
}
