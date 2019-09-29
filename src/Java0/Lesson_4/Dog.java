package Java0.Lesson_4;

public class Dog extends  Animal {
    Dog(){
        this.name = "Backey";
    }

    @Override
    public boolean run(int i) {
        boolean result = false;
        if (i>500){
            System.out.println("Это жестокое обращение с собаками! Сама(а) то пробежишь столько?!");
        } else {
            result = super.run(i);
        }
        return result;
    }

    @Override
    public boolean swim(int i) {
        boolean result = false;
        if (i>10){
            System.out.println("Сейчас холодно -  собака дальше чем на 10 метров не проплывет.");
        } else {
            result = super.swim(i);
        }
        return result;
    }

    @Override
    public boolean jump(int i) {
        boolean result = false;
        if (i<=0.5) {
            result = super.jump(i);
        } else {
            System.out.println("Это такса - она максимум на 50 см прыгает!");
        }
        return result;
    }
}