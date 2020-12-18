package com.sample.game.service;

import com.sample.base.model.GameState;
import com.sample.game.AppParameters;

import java.io.*;

public class LoadGameService {

    public GameState loadGame() {
        ObjectInputStream oi;
        try (FileInputStream fi = new FileInputStream(new File(AppParameters.SAVE_FILE))) {
            oi = new ObjectInputStream(fi);
            return (GameState) oi.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isSaveFileValid() {
        return loadGame() != null;
    }
}
