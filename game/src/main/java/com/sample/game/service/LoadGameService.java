package com.sample.game.service;

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
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void overwriteGameState(SaveData loadedSaveData, GameState currentGameState) {
        currentGameState
                .level(levelFactory.getByNumber(loadedSaveData.getLevelId()))
                .hero(heroFactory.getById(loadedSaveData.getHeroId()))
                .playerDirection(loadedSaveData.getPlayerDirection())
                .xPos(loadedSaveData.getxPos())
                .yPos(loadedSaveData.getyPos());
    }

    public boolean isSaveFileValid() {
        return loadSaveData() != null;
    }
}
