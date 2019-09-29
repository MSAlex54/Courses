package Java1.Lesson_2.HomeWork.EnumPractice;

public class DayOfWeekMain {
    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }

    public static String getWorkingHours (DayOfWeek day){
        String s = "";
        if (day.isWeekend()){
            s = "Сегодня выходной!";
        } else  {
            s = "Сегодня " + day.getNameOfTheDayRus() + ". До конца рабочей недели осталось " + ( (5 - day.getNumOfDay())*8 )+ " часов. Держитесь!";
        }
        day.getNumOfDay();
        return s;
    }
}