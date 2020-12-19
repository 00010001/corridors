package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.base.model.Stage;
import com.sample.base.service.Renderer;
import com.sample.console.renderer.service.ConsoleService;
import com.sample.console.renderer.service.FileService;

import java.util.Arrays;
import java.util.List;

import static com.sample.console.renderer.ConsoleRendererProperties.ATTACK_SKELETON;
import static com.sample.console.renderer.ConsoleRendererProperties.GAME_SAVED;

public class ConsoleRenderer implements Renderer {

    private final List<Stage> STAGE_LIST = Arrays.asList(Stage.MAIN_GAME, Stage.ITEM, Stage.FIGHT);

    private final MenuRenderer menuRenderer = new MenuRenderer();
    private final CharacterCreationRenderer characterCreationRenderer = new CharacterCreationRenderer();
    private final GameRenderer gameRenderer = new GameRenderer();
    private final ConsoleService consoleService = new ConsoleService();
    private final FileService fileService = new FileService();

    @Override
    public void render(GameState gameState) {
        consoleService.clearScreen();
        if (gameState.getStage() == Stage.MENU) {
            menuRenderer.render(gameState);
        } else if (gameState.getStage() == Stage.CHARACTER_CREATION) {
            characterCreationRenderer.render(gameState.getHero());
        } else if (STAGE_LIST.contains(gameState.getStage())) {
            gameRenderer.render(gameState);
        } else if (gameState.getStage() == Stage.GAME_SAVED) {
            FileService.printInputStream(fileService.getFileFromResourceAsStream(GAME_SAVED));
        } else if (gameState.getStage() == Stage.ATTACKING_SKELETON) {
            FileService.printInputStream(fileService.getFileFromResourceAsStream(ATTACK_SKELETON));
        }
    }
}
