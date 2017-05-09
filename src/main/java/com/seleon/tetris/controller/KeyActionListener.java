package com.seleon.tetris.controller;

import com.seleon.tetris.model.TetrisBoard;
import com.seleon.tetris.view.TetrisWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Sergey Mikhluk.
 */
public class KeyActionListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        Game game = Game.getInstance();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            TetrisBoard.getInstance().decrementX(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            game.go();
        }

        TetrisWindow.getInstance().repaint(); //todo перенести
    }
}
