package Java1.Lesson_1.Marafon.Competitors;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    @Override
    public boolean isOnDistance() {
        return active;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 30;
        this.maxSwimDistance = 200;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " ������ ��������� � �������");
        } else {
            System.out.println(name + " �� ��������� � �������");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " ������ ����������� ����� �����");
        } else {
            System.out.println(name + " �� ���� ������������ �����");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.println(name + " ������� �������");
        } else {
            System.out.println(name + " �� ���� ��������");
            active = false;
        }
    }

    @Override
    public void info() {
        System.out.println(name + " - " + active);
    }
}