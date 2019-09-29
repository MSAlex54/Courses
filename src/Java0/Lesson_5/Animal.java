package Java0.Lesson_5;

public class Animal {
    String name;

    public boolean run(int i){
        System.out.println(this.name + " побежал " + i + " метров");
        return true;
    }
    public boolean swim(int i){
        System.out.println(this.name + " проплыл " + i + " метров");
        return true;
    }
    public boolean jump(int i){
        System.out.println(this.name + " прыгнул на " + i + " метров");
        return true;
    }
    Animal(){
        name = "Unnamed";
    }
}
