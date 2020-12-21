package com.sample.game.service;

import com.sample.base.model.GameState;
import com.sample.base.model.SaveData;
import com.sample.game.AppParameters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class SaveGameService {

    private boolean saveFileWasCreated;

    public void saveGame(GameState gameState) {

        SaveData saveData = prepareSaveData(gameState);

        ObjectOutputStream o;
        try (FileOutputStream f = new FileOutputStream(new File(AppParameters.SAVE_FILE))) {
            o = new ObjectOutputStream(f);
            o.writeObject(saveData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private SaveData prepareSaveData(GameState gameState) {
        return new SaveData()
                .hero(gameState.getHero())
                .level(gameState.getLevel())
                .stage(gameState.getStage())
                .localDateTime(LocalDateTime.now())
                .direction(gameState.getDirection())
                .col(gameState.getCol())
                .row(gameState.getRow());
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
