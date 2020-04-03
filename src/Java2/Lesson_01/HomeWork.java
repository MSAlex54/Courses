package Java2.Lesson_01;

/*≈сть классы Fruit -> Apple, Orange (больше фруктов не надо);
 ласс Box, в который можно складывать фрукты.  оробки условно сортируютс€ по типу фрукта, поэтому в одну коробку нельз€ сложить и €блоки, и апельсины;
ƒл€ хранени€ фруктов внутри коробки можно использовать ArrayList;
—делать метод getWeight(), который высчитывает вес коробки, зна€ количество фруктов и вес одного фрукта (вес €блока Ц 1.0f, апельсина Ц 1.5f. Ќе важно, в каких это единицах);
¬нутри класса  оробка сделать метод compare, который позвол€ет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true Ц если она равны по весу, false Ц в противном случае (коробки с €блоками мы можем сравнивать с коробками с апельсинами);
Ќаписать метод, который позвол€ет пересыпать фрукты из текущей коробки в другую (помним про сортировку фруктов: нельз€ €блоки высыпать в коробку с апельсинами). —оответственно, в текущей коробке фруктов не остаетс€, а в другую перекидываютс€ объекты, которые были в этой коробке;
Ќе забываем про метод добавлени€ фрукта в коробку.*/

public class HomeWork {

    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        for (int i = 0; i < 9 ; i++) {
            box1.addToBox(new Apple());
        }
        for (int i = 0; i < 6; i++) {
            box2.addToBox(new Orange());
        }
        System.out.println(box1.getTypeOfBox() + " " + box1.getWeight());
        System.out.println(box2.getTypeOfBox() + " " + box2.getWeight());
        System.out.println(box1.compareBoxes(box2));
        box1.moveToAnotherBox(box3);
        System.out.println(box1.getTypeOfBox() + " " + box1.getWeight());
        System.out.println(box3.getTypeOfBox() + " " + box3.getWeight());
    }
}
