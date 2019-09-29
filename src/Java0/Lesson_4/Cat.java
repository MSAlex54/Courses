package Java0.Lesson_4;

public class Cat extends Animal {
    Cat(){
        this.name = "Tom";
    }
    @Override
    public boolean run(int i) {
        boolean result = false;
        if (i>200){
            System.out.println("Кот столько не побежит - у него же лапки!");
        } else {
            result = super.run(i);
        }
        return result;
    }

    @Override
    public boolean swim(int i) {
        boolean result = false;
        System.out.println("Плыть?! Фуууу - мерзость! Это же - кот!");
        return result;
    }

    @Override
    public boolean jump(int i) {
        boolean result = false;
        if (i<=2) {
            result = super.jump(i);
        } else {
            System.out.println("Кот  так высоко не прыгнет - у него же лапки!");
            result = false;
        }
        return result;
    }
}
/*
5. Создать классы Собака и Кот с наследованием от класса Животное;
6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);
7. У каждого животного есть ограничения на действия (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);
 */