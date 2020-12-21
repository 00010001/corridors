package com.sample.base.service;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;

public interface InputProcessor {

    InputCommand getInputCommand(GameState gameState, boolean error);

}
