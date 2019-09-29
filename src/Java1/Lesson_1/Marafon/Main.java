package Java1.Lesson_1.Marafon;

import Java1.Lesson_1.Marafon.Competitors.*;
import Java1.Lesson_1.Marafon.Obstacles.Course;
import Java1.Lesson_1.Marafon.Obstacles.Cross;
import Java1.Lesson_1.Marafon.Obstacles.Obstacle;
import Java1.Lesson_1.Marafon.Obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Метеор");
        Course c = new Course();
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}