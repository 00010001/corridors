package com.sample.base.service;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.Stage;

public interface InputProcessor {

    InputCommand getInputCommand(GameState gameState, boolean error);

}
