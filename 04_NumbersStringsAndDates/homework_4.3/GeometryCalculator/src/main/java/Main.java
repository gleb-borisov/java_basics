import java.util.Scanner;

public class Main {

    private static final int CAR_CAPACITY = 12;
    private static final int CONTAINER_CAPACITY = 27;

    public static void main(String[] args) {

        Scanner inBox = new Scanner(System.in);
        System.out.print("Введите кол-во ящиков - ");
        int box = inBox.nextInt();
        int container = box / CONTAINER_CAPACITY;
        int boxRemainder = box % 27;
        int car = container / CAR_CAPACITY;
        int containerRemainder = container % 12;
        int carIn = 0;
        int containerIn = 0;
        int boxIn = 0;

        for (int a = 1; a <= car; a++) {
            System.out.println("Грузовик: " + ++carIn);
            for (int b = 1; b <= CAR_CAPACITY; b++) {
                System.out.println("\t Контейнер: " + ++containerIn);
                for (int c = 1; c <= CONTAINER_CAPACITY; c++) {
                    System.out.println("\t \t \t Ящик: " + ++boxIn);
                }
            }
        }

        System.out.println("Грузовик: " + ++carIn);
        for (int d = 1; d <= containerRemainder; d++) {
            System.out.println("\t Контейнер: " + ++containerIn);
            for (int e = 1; e <= CONTAINER_CAPACITY; e++) {
                System.out.println("\t \t \t Ящик: " + ++boxIn);
            }
        }

        System.out.println("\t Контейнер: " + ++containerIn);
        for (int f = 1; f <= boxRemainder; f++){
            System.out.println("\t \t \t Ящик: " + ++boxIn);
        }

        System.out.println();

        System.out.println("Необходимо: ");
        System.out.println("Грузовиков - " + carIn + " шт.");
        System.out.println("Контейнеров - " + containerIn + " шт.");
    }
}
