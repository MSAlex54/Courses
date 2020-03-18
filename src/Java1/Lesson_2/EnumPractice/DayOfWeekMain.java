package Java1.Lesson_2.EnumPractice;

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
            s = "������� ��������!";
        } else  {
            s = "������� " + day.getNameOfTheDayRus() + ". �� ����� ������� ������ �������� " + ( (5 - day.getNumOfDay())*8 )+ " �����. ���������!";
        }
        day.getNumOfDay();
        return s;
    }
}