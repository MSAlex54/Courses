package Java1.Lesson_1.Marafon.Obstacles;

import Java1.Lesson_1.Marafon.Competitors.Competitor;
import Java1.Lesson_1.Marafon.Competitors.Team;

public class Course {
    private Obstacle[] course;

    public Course() {
        setCourse(new Obstacle[]{new Cross(80), new Wall(2), new Wall(1), new Cross(120)});
    }

    public Obstacle[] getCourse() {
        Obstacle[] courseCopy;
        courseCopy = course;
        return courseCopy ;
    }

    public void setCourse(Obstacle[] course) {
        this.course = course;
    }

    public void doIt(Team team){
        for (Competitor c: team.getCompetitor()) {
            for (Obstacle o:getCourse()){
                o.doIt(c);
                if (!c.isOnDistance())break;
            }
        }
    }
}
