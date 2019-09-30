
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /*
        блок настроек игры
    */
    private static char[][] map; //матрица игры
    private static final int SIZE = 3;
    private static final char DOT_EMPTY = '\u2014';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static Random random = new Random();
    private static final boolean SILLY_MODE = false;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
        while(true){
            humanTurn();//ход человека
            if (isEndGame(DOT_X)) {
                break;
            }
            computerTurn();//ход компьютера
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("игра окончена!");
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;
        printMap();

        if(checkWin(playerSymbol)){
            System.out.println("Победил " + playerSymbol);
            result = true;
            scanner.close();
        }

        if (isMapFull()){
            System.out.println("Ничья!");
            result = true;
            scanner.close();
        }

        return result;
    }

    /*
    инициализация поля
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i ++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /*
    вывод поля на экран
     */
    private static void printMap() {
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i =0; i < SIZE; i++){
            System.out.print((i+1) + " ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    /*
    проверка заполнености поля
     */

    private static boolean isMapFull() {
        boolean result = true;
        for (int i = 0; i<SIZE; i++){
            for (int j = 0; j<SIZE; j++){
                if (map[i][j] == DOT_EMPTY){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /*
    ход игрпока человека
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки (X Y)");
            y = scanner.nextInt() - 1; // Считывание номера строки
            x = scanner.nextInt() - 1; // Считывание номера столбца
        }
        while(!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    /*
    ход игрока компьютера
     */
    private static void computerTurn(){
        int x = -1;
        int y = -1;

        if(SILLY_MODE){
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while(!isCellValid(x, y));
        }
        else{
            boolean finishHim = false;
            boolean thretathMove = false;
            int [] computerMove = compMove(DOT_O);
            finishHim = computerMove[0] == 1;//есть ли ход которым компьютер может закончить игру?
            if (finishHim){
                x = computerMove[2];
                y = computerMove[1];
            } else {
                computerMove = compMove(DOT_X);
                thretathMove = computerMove[0] == 1;//есть ли ход которым игрок может закончить игру?
                if (thretathMove){
                    x = computerMove[2];
                    y = computerMove[1];
                }
            }
            if (!finishHim && !thretathMove){
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while(!isCellValid(x, y));
            }
        }
        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }

    /*
    метод проверки хода обеспечивающего победу (возвращет координаты куда сходить тчобы победить/не проиграть)
    */
    private static int[] compMove(char playerSymbol) {
        int[] cMove = new int[3];
        boolean result = false;
        for(int i = 0; i < SIZE; i++) {
            //проверяем строки
            int symbRowCounter = 0;
            int emptyRowCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == playerSymbol) symbRowCounter++;
                if (map[i][j] == DOT_EMPTY) {
                    emptyRowCounter++;
                    cMove[1] = i;
                    cMove[2] = j;
                }
            }
            if (symbRowCounter == 2 && emptyRowCounter == 1) {
                cMove[0] = 1;
                break;
            }

            //проверяем столбцы
            int symbColCounter = 0;
            int emptyCOlCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == playerSymbol) symbColCounter++;
                if (map[j][i] == DOT_EMPTY) {
                    emptyCOlCounter++;
                    cMove[1] = j;
                    cMove[2] = i;
                }
            }
            if (symbColCounter == 2 && emptyCOlCounter == 1) {
                cMove[0] = 1;
                break;
            }

            //проверяем диагонали
            if (i == 1) {
                int symbMainCounter = 0;
                int emptyMainCounter = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][j] == playerSymbol) symbMainCounter++;
                    if (map[j][j] == DOT_EMPTY) {
                        emptyMainCounter++;
                        cMove[1] = j;
                        cMove[2] = j;
                    }
                }
                if (symbMainCounter == 2 && emptyMainCounter == 1) {
                    cMove[0] = 1;
                    break;
                }
                int symbRevCounter = 0;
                int emptyRevCounter = 0;
                for (int j = 0; j < SIZE; j++) {

                    if (map[j][SIZE - 1 - j] == playerSymbol) symbRevCounter++;
                    if (map[j][SIZE - 1 - j] == DOT_EMPTY) {
                        emptyRevCounter++;
                        cMove[1] = j;
                        cMove[2] = SIZE - 1 - j;
                    }
                }
                if (symbRevCounter == 2 && emptyRevCounter == 1) {
                    cMove[0] = 1;
                    break;
                }
            }
        }
        return cMove;
    }

    /*
    валидация хода
     */
    private static boolean isCellValid(int x, int y){
        boolean result = true;
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }
        if(map[y][x] != DOT_EMPTY){
            result = false;
        }
        return result;
    }

    /*
    проверка победы символа
     */
    private static boolean checkWin(char playerSymbol) {
        boolean result = false;
        if(
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)){
            result = true;
        }
        return result;
    }




}
