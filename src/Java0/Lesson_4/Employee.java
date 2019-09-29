package Java0.Lesson_4;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee() {
        fullName = "Фамильев Имён Отчествович"; //креатив уровня Бог - делюсь, копирайтом не защищал :)
        position = "Малдший помошник старшего дворника";
        email = "familyiev@super_pochta.com";
        phoneNumber = "89991234567";
        salary = 50000;
        age = 44;
    }

    /*
    перегруженный конструктор со всеми параметрами, я немного знаю из java.
    перегрузка - эт когда вы называете метод одинаково,
    но передаетеет в него разные параметры или в разном порядке.
    например все параметры, или частично (как ниже - без email)
    */
    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String fullName, String position, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }


    @Override//это тег означает, что мы переопределем метод (все классы и объекты наследники класс Object, у которого есть метод toString) - наследование - наше всё.
    //небольшая лентяйка - у inellij IDEA есть много горячих клавишь (в данном случае Alt + Insert, который позволяет создать сеттеры/геттеры, а также конструкторв и т.д.)
    // которые позволяют ускорить создание кода (рекомендую загуглить "горячие клавиши Intellij IDEA")
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
    //дальше идут геттеры (к полям класса создаются геттары чтобы получить их значения) (инкапсуляция - наше всё)
    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
