package com.example.tictactoe;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.util.*;
import java.util.stream.Collectors;

public class HelloController {
    private final Model gameModel = new Model();
    public Label playerOne, computerPlayer;
    public Button btn1, btn2, btn3, btn4, btn5, btn6,btn7,btn8, btn9;
    public Button[] buttons;
    private boolean gameFinished;


    public void initialize() {
        buttons = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        startNewGame();

    }
    private void startNewGame() {
        gameFinished = false;
        gameModel.currentPlayer = gameModel.player1.getPlayer();
        updateButtonLabels();
    }
    public void reset() {
        gameModel.initializeBoard();
        startNewGame();
    }


    private void updateButtonLabels() {
        for (Button button : buttons) {
            Integer rowIndex = GridPane.getRowIndex(button);
            Integer columnIndex = GridPane.getColumnIndex(button);
       button.setText(gameModel.getABoardPosition(rowIndex, columnIndex));
        }
    }


    public void handleButtonClick(MouseEvent buttonClicked){
        if ("x".equals(gameModel.currentPlayer)&& !gameFinished)  {
            playerXTurn(buttonClicked);
        }

    }
    private void playerXTurn(MouseEvent buttonClicked) {
        Object source = buttonClicked.getSource();
        if (source instanceof Button clickedButton) {
            updateGame(clickedButton);
                computerTurn();
            }

    }

    public void updateGame(Button button){
        Integer rowIndex = GridPane.getRowIndex(button);
        Integer columnIndexIndex = GridPane.getColumnIndex(button);
        if(gameModel.isValidMove(rowIndex, columnIndexIndex)) {
            button.setText(gameModel.currentPlayer);
            updateGameModel(rowIndex, columnIndexIndex);
            if (gameModel.checkWinner()) {
                updateScoreLabels();
                gameFinished = true;
            } else {
                gameModel.toggleCurrentPlayer();
            }
        }
    }
    private void updateGameModel(int rowIndex, int columnIndexIndex) {
        gameModel.setABoardPosition(rowIndex, columnIndexIndex, gameModel.currentPlayer);
    }
    private void updateScoreLabels() {
        int scorePlayerOne = gameModel.player1.getScore();
        int computer = gameModel.player2.getScore();
        playerOne.setText("Score: "+ (scorePlayerOne));
        computerPlayer.setText("Score: "+ (computer));
    }

    public void computerTurn(){
        if ("o".equals(gameModel.currentPlayer) && !gameFinished) {
            List<Button> emptyPositions = filterForEmptyPositions();
            if (!emptyPositions.isEmpty()) {
                int selected = randomPosition(emptyPositions);
                Button button = emptyPositions.get(selected);
                updateGame(button);
            }
        }
    }

    private static int randomPosition(List<Button> emptyPositions) {
        return new Random().nextInt(emptyPositions.size());
    }

    private List<Button> filterForEmptyPositions() {
        return Arrays.stream(buttons)
                .filter(button -> button.getText().equals(" "))
                .collect(Collectors.toList());
    }


}

