package Java0.Lesson_7.Game;

public class GameAiPlayer {
    private char playerSign;
    private boolean realPlayer = false;

    public GameAiPlayer(char playerSign, boolean realPlayer) {
        this.playerSign = playerSign;
        this.realPlayer = realPlayer;
    }

    public boolean isRealPlayer(){
        return realPlayer;
    }

    public char getPlayerSign(){
        return playerSign;
    }
}