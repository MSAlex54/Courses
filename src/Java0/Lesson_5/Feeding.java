package Java0.Lesson_5;

public class Feeding {
    public static void main(String[] args) {
        //создаем котов
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Васька",3,5);
        cats[1] = new Cat("Мурзик",7,14);
        cats[2] = new Cat("Пущок");
        cats[3] = new Cat("Пиксель",2,3);
        cats[4] = new Cat();

        Bowl bowl = new Bowl();//создаем мсику

        bowl.bowlFilling(15);//наполяем миску

        //кормим котов
        for (Cat cat:cats){
            while (!cat.isSatiety()) {//кормим котов пока они не наедятся
                if (bowl.checkFullness() == 0) {
                    System.out.println("Миска пуста, наполняем");
                    bowl.bowlFilling(10);
                }
                cat.eate(bowl);
                System.out.println("В миске осталось " + bowl.checkFullness() + " еды");
            }
        }
    }
}

