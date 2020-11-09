import java.util.Scanner;

public class Main {

    private static final int CAR_CAPACITY = 324;
    private static final int CONTAINER_CAPACITY = 27;

    public static void main(String[] args) {

        Scanner inBox = new Scanner(System.in);
        System.out.print("Введите кол-во ящиков - ");
        int box = inBox.nextInt();
        int container = 0;
        int car = 0;

        for (int a = 1; a <= box; a++) {
            car = a/CAR_CAPACITY + 1;
            container = a/CONTAINER_CAPACITY + 1;
            int carRemainder = a % CAR_CAPACITY;
            int containerRemainder = a % CONTAINER_CAPACITY;

            if (carRemainder == 0) {
                System.out.println("Грузовик: " + car);
            }

            if (containerRemainder == 0) {
                System.out.println("\t Контейнер: " + container);
            }
            System.out.println("\t \t \t Ящик:" + a);
        }
        System.out.println();

        System.out.println("Необходимо: ");
        System.out.println("Грузовиков - " + car + " шт.");
        System.out.println("Контейнеров - " + container + " шт.");
    }
}