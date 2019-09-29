package Java0.Lesson_7.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListiner implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListiner(int rowNum, int cellNum, GameButton gameButton) {
        this.row = rowNum;
        this.cell = cellNum;
        this.button = gameButton;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row,cell)){
            updateByLayersData(board);

            if(board.isFull()){
                board.getGame().showMessage("Ничья");
                board.emptyField();
            } else{
                updateByAiData(board);
            }

        } else{
            board.getGame().showMessage("Некорректный ход");
        }
    }

    private void updateByAiData(GameBoard board) {
        int x = 0;
        int y = 0;
        Random rnd = new Random();

//        GameBoard copyBoard = board;
//        boolean finishHim = false;
//        for (int i = 0; i<GameBoard.dimension; i++){
//            boolean endOfCycle = false;
//            for (int j = 0; j<GameBoard.dimension; j++){
//                if (board.isTurnable(i, j)){
//                    GameBoard copyBoard = board;
//                    copyBoard.updateGameField(i,j);
//                    int cellIndex = GameBoard.dimension*i+j;
//                    copyBoard.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
//                    if (copyBoard.checkWin()){
//                        endOfCycle = true;
//                        finishHim = true;
//                        x = i;
//                        y = j;
//                        break;
//                    }
//                }
//            }
//            if (endOfCycle) break;;
//        }
//        if (finishHim == false) {
            do {
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!board.isTurnable(x, y));
//        }

        board.updateGameField(x,y);

        int cellIndex = GameBoard.dimension*x+y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()){
            button.getBoard().getGame().showMessage("Компьютер победил!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }

    }

    private void updateByLayersData(GameBoard board) {
        board.updateGameField(row,cell);

        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()){
            button.getBoard().getGame().showMessage("Вы выиграли");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }

    }
}
