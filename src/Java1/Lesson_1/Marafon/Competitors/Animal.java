package Java1.Lesson_1.Marafon.Competitors;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(type + " " + name + " ������ ��������� � �������");
        } else {
            System.out.println(type + " " + name + " �� ��������� � �������");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " ������ ����������� ����� �����");
        } else {
            System.out.println(type + " " + name + " �� ���� ������������ �����");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " �� ����� �������");
            onDistance = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            System.out.println(type + " " + name + " ������� �������");
        } else {
            System.out.println(type + " " + name + " �� ���� ��������");
            onDistance = false;
        }
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " - " + onDistance);
    }
}