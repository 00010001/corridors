package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.SaveData;
import com.sample.base.model.factory.HeroFactory;
import com.sample.base.model.factory.LevelFactory;
import com.sample.game.AppParameters;

import java.io.*;

public class LoadGameService {

    private final LevelFactory levelFactory = new LevelFactory();
    private final HeroFactory heroFactory = new HeroFactory();

    public SaveData loadSaveData() {
        ObjectInputStream oi;
        try (FileInputStream fi = new FileInputStream(new File(AppParameters.SAVE_FILE))) {
            oi = new ObjectInputStream(fi);
            return (SaveData) oi.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found: " + AppParameters.SAVE_FILE);
        } catch (IOException e) {
            throw new RuntimeException("error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("can't load save data");
    }

    public void overwriteGameState(SaveData loadedSaveData, GameState currentGameState) {
        currentGameState
                .level(levelFactory.getByNumber(loadedSaveData.getLevelId()))
                .hero(heroFactory.getById(loadedSaveData.getHeroId()))
                .direction(loadedSaveData.getDirection())
                .col(loadedSaveData.getCol())
                .row(loadedSaveData.getRow());
    }

    public boolean isSaveFileValid() {
        return loadSaveData() != null;
    }
}
