package com.example.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private Model model;

    @BeforeEach
    public void setup() {
        model = new Model();
    }

    @Test
    public void testIsValidMove() {
        String[][] board = {
                {"x", "o", " "},
                {" ", "x", "o"},
                {" ", " ", "x"}
        };
        model.setBoard(board);
        assertFalse(model.isValidMove(0, 1));
    }

    @Test
    public void testIsNotValidMove() {
        String[][] board = {
                {"x", "o", " "},
                {" ", "x", "o"},
                {" ", " ", "x"}
        };
        model.setBoard(board);
        assertFalse(model.isValidMove(0, 1));
    }

    @Test
    public void testPlayerHasWon() {
        model.initializeBoard();
        model.setABoardPosition(0, 0, "x");
        model.setABoardPosition(0, 1, "x");
        model.setABoardPosition(0, 2, "x");
        assertTrue(model.hasWon("x"));
    }
    @Test
    public void testPlayerHasNotWon() {
        model.initializeBoard();
        model.setABoardPosition(0, 0, "x");
        model.setABoardPosition(0, 1, "x");
        model.setABoardPosition(0, 2, "x");
        assertFalse(model.hasWon("o"));
    }
    @Test
    public void testComputerHasWon() {
        model.initializeBoard();
        model.setABoardPosition(0, 0, "o");
        model.setABoardPosition(0, 1, "o");
        model.setABoardPosition(0, 2, "o");
        assertFalse(model.hasWon("x"));
        assertTrue(model.hasWon("o"));
    }
    @Test
    public void testComputerHasNotWon() {
        model.initializeBoard();
        model.setABoardPosition(0, 0, "o");
        model.setABoardPosition(0, 1, "o");
        model.setABoardPosition(0, 2, "o");
        assertFalse(model.hasWon("x"));
    }


    @Test
    public void testIfEqual() {
        String[][] board = {
                {"x", "o", "x"},
                {"x", "x", "o"},
                {"o", "x", "o"}
        };
        model.setBoard(board);
        assertTrue(model.isBoardFull());
    }


}