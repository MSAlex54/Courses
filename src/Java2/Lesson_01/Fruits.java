package Java2.Lesson_01;

abstract public class Fruits {
    private float weight;
    public String type;

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
