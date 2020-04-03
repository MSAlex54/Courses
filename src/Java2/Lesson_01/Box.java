package Java2.Lesson_01;

import java.util.ArrayList;

public class Box <T extends Fruits> {
    private String whatInside = "Empty";
    private ArrayList<T> box;

    public Box(){
        box = new ArrayList();
    }

    public void addToBox(T fruit){
        if (whatInside.equals("Empty") || whatInside.equals(fruit.getType())) {
            whatInside = fruit.getType();
            box.add(fruit);
        } else {
            System.out.println("Wrong fruit");
        }
    }

    public float getWeight(){
        float weitgh = 0.0f;
        for (Fruits f:box) {
            weitgh += f.getWeight();
        }
        return weitgh;
    }

    public String getTypeOfBox(){
        return whatInside;
    }

    public boolean compareBoxes(Box otherBox){
        return otherBox.getWeight()==this.getWeight();
    }

    public boolean moveToAnotherBox(Box otherBox){
        if (otherBox.getTypeOfBox().equals("Empty")||otherBox.getTypeOfBox().equals(getTypeOfBox())){
            for (Fruits f: box) {
                otherBox.addToBox(f);
            }
            resetBox();
            return true;
        } else{
            return false;
        }
    }
    public void resetBox(){
        box.clear();
        whatInside = "Empty";
    }
}
