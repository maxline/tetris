package com.seleon.tetris.view.game;

import com.seleon.tetris.controller.KeyListener;
import com.seleon.tetris.controller.MouseActionListener;
import com.seleon.tetris.model.Board;
import com.seleon.tetris.model.Figure;
import com.seleon.tetris.model.Game;

import javax.swing.*;
import java.awt.*;

import static com.seleon.tetris.config.Config.*;

/**
 * @author Sergey Mikhluk.
 */
public class BoardPanel extends JPanel {
    private static final int BOARD_PANEL_WIDTH = BOARD_WIDTH * BLOCK_SIZE;
    private static final int BOARD_PANEL_HEIGHT = BOARD_HEIGHT * BLOCK_SIZE;

    public BoardPanel() {
        setOpaque(true);
        setFocusable(true);
        setBorder(BorderFactory.createLineBorder(Color.red));
        setBackground(Color.BLACK);
        setSize(BOARD_PANEL_WIDTH, BOARD_PANEL_HEIGHT);
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Game game = Game.getInstance(); //todo должно инжектиться?

        drawBoard(graphics, game);
        drawFigure(graphics, game);
    }

    private void drawFigure(Graphics graphics, Game game) {
        Figure figure = game.getFigure();
        if (figure == null || figure.getShape() == null) {
            return;
        }

        graphics.setColor(new Color(figure.getColor()));
        for (int y = 0; y < figure.getShape().length; y++) {
            for (int x = 0; x < figure.getShape()[0].length; x++) {
                if (figure.getShape()[y][x] > 0) {
                    graphics.drawRoundRect((x + figure.getFigureX()) * BLOCK_SIZE, (y + figure.getFigureY()) * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1, ARC_WIDTH, ARC_HEIGHT);
                }
            }
        }
    }

    private void drawBoard(Graphics graphics, Game game) {
        Board board = game.getBoard();

        for (int y = 0; y < board.getBoard().length; y++) {
            for (int x = 0; x < board.getBoard()[0].length; x++) {
                if (board.getBoard()[y][x] > 0) {
                    graphics.setColor(new Color(board.getBoard()[y][x]));
                    graphics.drawRoundRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1, ARC_WIDTH, ARC_HEIGHT);
                }
            }
        }
    }

    public void addBoardKeyListener(KeyListener keyListener) {
        addKeyListener(keyListener);
    }

    public void addBoardMouseListener(MouseActionListener mouseActionListener) {
        addMouseListener(mouseActionListener);
    }
}
