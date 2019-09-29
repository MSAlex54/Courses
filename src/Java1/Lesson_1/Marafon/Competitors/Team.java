package Java1.Lesson_1.Marafon.Competitors;

public class Team {
    private String teamName;

    private Competitor [] competitor;

    public Team (String name){
        setTeamName(name);
        setCompetitor(new Competitor[]{new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")});
    }

    public void setCompetitor(Competitor[] competitor) {
        this.competitor = competitor;
    }

    public Competitor[] getCompetitor() {
        Competitor [] competitorCopy;
        competitorCopy = competitor;
        return competitorCopy ;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getTeamName() {
        return teamName;
    }

    public void showResults(){
        System.out.printf("\nРезультаты команды %s:\n", getTeamName());
        for (Competitor c:getCompetitor()) {
            c.info();
        }
    }
}
