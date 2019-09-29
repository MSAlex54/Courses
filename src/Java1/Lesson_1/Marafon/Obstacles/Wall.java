package Java1.Lesson_1.Marafon.Obstacles;

import Java1.Lesson_1.Marafon.Competitors.Competitor;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}