package Java0.Lesson_7.Game;

import javax.swing.*;

public class Game {
    private GameBoard board;
    private GamePlayer [] gamePlayers = new GamePlayer[2];
    private int palyersTurn = 0;

    public Game(){
        this.board = new GameBoard(this);
    }


    public void initGame() {
        gamePlayers[0] = new GamePlayer('X', true);
        gamePlayers[1] = new GamePlayer('O', false);
    }

    void passTurn(){
        if (palyersTurn==0)
            palyersTurn=1;
        else
            palyersTurn=0;
    }

    GamePlayer getCurrentPlayer(){
        return gamePlayers[palyersTurn];
    }

    void showMessage (String messageText){
        JOptionPane.showMessageDialog(board,messageText);
    }
}

