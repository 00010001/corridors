package com.sample.base.service;

import com.sample.base.model.GameParameters;
import com.sample.base.model.InputCommand;
import com.sample.base.model.Stage;

public interface InputProcessor {

    InputCommand getInputCommand(GameParameters gameParameters, Stage currentStage, boolean error);

}
