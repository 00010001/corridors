package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.SaveData;
import com.sample.game.AppParameters;

import java.io.*;

import static com.sample.base.ErrorMessages.*;

public class LoadGameService {

    public SaveData loadSaveData(boolean calledForTest) {
        ObjectInputStream oi;
        try (FileInputStream fi = new FileInputStream(new File(AppParameters.SAVE_FILE))) {
            oi = new ObjectInputStream(fi);
            return (SaveData) oi.readObject();
        } catch (FileNotFoundException e) {
            if (calledForTest) {
                return null;
            }
            throw new RuntimeException(FILE_NOT_FOUND + AppParameters.SAVE_FILE);
        } catch (IOException e) {
            if (calledForTest) {
                return null;
            }
            throw new RuntimeException(ERROR_INITIALIZING_STREAM);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(CANT_LOAD_SAVE_DATA);
    }

    public void overwriteGameState(SaveData loadedSaveData, GameState currentGameState) {
        currentGameState
                .stage(loadedSaveData.getStage())
                .level(loadedSaveData.getLevel())
                .hero(loadedSaveData.getHero())
                .direction(loadedSaveData.getDirection())
                .col(loadedSaveData.getCol())
                .row(loadedSaveData.getRow());
    }

    public boolean isSaveFileValid() {
        return loadSaveData(true) != null;
    }
}
