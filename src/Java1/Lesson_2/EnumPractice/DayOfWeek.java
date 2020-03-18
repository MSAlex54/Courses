package Java1.Lesson_2.EnumPractice;

public enum DayOfWeek {
    MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"), FRIDAY("Пятница"), SATURDAY("Суббота"), SUNDAY("Воскресенье");

    private String nameOfTheDayRus;
    private int numOfDay;

    private boolean weekend;

    DayOfWeek(String nameOfTheDayRus) {
        this.nameOfTheDayRus = nameOfTheDayRus;
        this.numOfDay = this.ordinal();
        this.setWeekend();
    }

    public String getNameOfTheDayRus() {
        return nameOfTheDayRus;
    }

    public void setNameOfTheDayRus(String nameOfTheDayRus) {
        this.nameOfTheDayRus = nameOfTheDayRus;
    }

    public int getNumOfDay() {
        return this.numOfDay;
    }

    private void setWeekend() {
        if (this.ordinal()<5) {
            this.weekend = false;
        }else{
            this.weekend = true;
        }
    }

    public boolean isWeekend() {
        return weekend;
    }
}
