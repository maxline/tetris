package com.seleon.tetris.controller.command;

/**
 * @author Sergey Mikhluk.
 */
public class PauseCommand implements ICommand {

    public void execute() {
        game.pause();
    }
}