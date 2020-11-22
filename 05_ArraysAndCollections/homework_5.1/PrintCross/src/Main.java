import java.util.Scanner;

public class Main {

    private static String[][] cross;

    public static void main(String[] args) {

        int circle = 0;
        while (circle == 0) {

            Scanner in = new Scanner(System.in);
            System.out.print("Введите размер стороны квадрата в который будет вписан крест,\nДля выхода из цикла наберите отрицательное число  - ");
            int arraySize = in.nextInt();
            if (arraySize < 0) {
                return;
            }
            crossCreate(arraySize);

            for (int i = 0; i < cross.length; i++) {
                for (int j = 0; j < cross[i].length; j++) {
                    System.out.print(cross[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static String[][] crossCreate (int arraySize) {

        cross = new String[arraySize][arraySize];

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                cross[i][j] = " ";
                if ((i - j) == 0) {
                    cross[i][j] = "X";
                }
                if (((arraySize - 1 - i) - j) == 0) {
                    cross[i][j] = "X";
                }
            }
        }
        return cross;
    }
}
