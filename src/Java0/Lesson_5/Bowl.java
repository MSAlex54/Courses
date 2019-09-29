package Java0.Lesson_5;

public class Bowl {
    private int volume;//объем
    private int fullness;//наполненность

    Bowl(){
        volume = 10;
    }
    public void bowlFilling (int foodVolume){
        if (foodVolume > volume || (fullness + foodVolume) > volume ){
            fullness = volume;
        }else {
            fullness += foodVolume;
        }
    }

    public int eatFromBowl (int bite){
        int howMuchEaten = 0;
        if (bite>fullness){
            howMuchEaten = fullness;
            fullness = 0;
        } else {
            howMuchEaten = bite;
            fullness -=bite;
        }
        return howMuchEaten;
    }

    public int checkFullness (){
        return fullness;
    }
}
