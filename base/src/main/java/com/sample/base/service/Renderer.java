package com.sample.base.service;

import com.sample.base.model.GameParameters;
import com.sample.base.model.GameState;

public interface Renderer {
    void render(GameState gameState, GameParameters gameParameters);
}
