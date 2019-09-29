package Java1.Lesson_4.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class PasswordCheck {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String psw = "";

        while (true) {
            System.out.println("Придумайте пароль.");
            try {
                psw = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (test(psw)){
                System.out.println("Пароль может быть использован.");
                break;
            } else {
                System.out.println("Пароль не прошел проверку. Придумайте другой");
            }
        }
    }

    public static boolean test(String testString) {
        Boolean result = true;

        Pattern kirillPat = Pattern.compile("^.*[А-Яа-я].*$");
        Pattern mainPat = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");//Честно стырено с Хабра, но всё понятно
        result = mainPat.matcher(testString).matches()& !kirillPat.matcher(testString).matches();

        return result ;
    }
}

//1 Должна быть заглавная буква
//2 Должна быть хотябы 1 цифра
//3 Минимум 8 символов
//4 Латиница
//5 Спец. символ
