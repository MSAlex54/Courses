package Java0.Lesson_4;

public class IntroductionInOOP {
    public static void main(String[] args) {
        Employee employee = new Employee();//создаю объект через конструктор по-умолчанию (без параметров)
        Employee[] emplArray = new Employee[5]; // Вначале объявляем массив объектов
        emplArray[0]  = new Employee();//вызываем конструктор по-умолчанию
        emplArray[1] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com ", "892312312", 30000, 45);
        emplArray[2] = new Employee("Petrov Petr", "Manager", "manager1@mailbox.com ", "892312312", 60000,43 );
        emplArray[3] = new Employee("Vasiliev Vailiy", "Manager", "manager2@mailbox.com ", "892312312", 60000, 25);
        emplArray[4] = new Employee("Maksimov Maksim", "Manager", "manager3@mailbox.com ", "892312312", 60000, 21);
        for (Employee emp: emplArray) {
            if (emp.getAge()>40) {
                System.out.println(emp.toString());//я вызываю переопределенный (смотри код класса) метод toString у созданного объекта кдасса Employee
            }
        }
        Cat cat = new Cat();
        cat.jump(1);
        cat.run(5);
        cat.swim(1);
        Dog dog = new Dog();
        dog.jump(1);
        dog.run(3);
        dog.swim(3);
    }
}
