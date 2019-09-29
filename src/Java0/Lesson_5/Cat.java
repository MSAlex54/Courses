package Java0.Lesson_5;

public class Cat extends Animal {
    private int hunger; //размер голода я решил чуть усложнить логику программы
    private int appetite;//количество еды съедаемое за раз

    public boolean isSatiety() {
        return satiety;
    }

    private boolean satiety;
    Cat(){
        name = "Tom";
        hunger = 10;
        satiety = false;
        appetite = 5;
    }
    Cat(String nickname){
        name = nickname;
        hunger = 10;
        satiety = false;
        appetite = 5;
    }
    Cat(String nickname, int appetite){
        name = nickname;
        hunger = 10;
        satiety = false;
        this.appetite = appetite;
    }
    Cat(String nickname, int appetite, int hunger){
        name = nickname;
        this.hunger = hunger;
        satiety = false;
        this.appetite = appetite;
    }
    @Override
    public boolean run(int i) {
        boolean result = false;
        if (i>200){
            System.out.println("Кот столько не побежит - у него же лапки!");
        } else {
            result = super.run(i);
            hunger++;
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
            hunger++;
        } else {
            System.out.println("Кот  так высоко не прыгнет - у него же лапки!");
            result = false;
        }
        return result;
    }

    //теперь кот умеет есть
    public void eate(Bowl bowl){
        int biteResult = bowl.eatFromBowl(appetite);
        switch (biteResult ){
            case 0:
                System.out.println("Голодный Мяв");
            default:
                hunger = hunger - biteResult;
                System.out.println(name + " довольно ест.");
                if (hunger<0){
                    hunger = 0;
                    satiety = true;
                    System.out.println(name + " наелся");
                }
        }
    }
}