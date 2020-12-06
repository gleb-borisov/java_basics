import java.util.*;

public class Main {

    private static long start;
    private static long duration;
    private static String[] alphabetic;

    public static void main(String[] args) {
        ArrayList<String> carNumberList = new ArrayList<>();
        alphabetic = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        label:
        {
            for (int region = 0; region < 200; region++) {
                for (int series1 = 0; series1 < 26; series1++) {
                    for (int series2 = 0; series2 < 26; series2++) {
                        for (int series3 = 0; series3 < 26; series3++) {
                            carNumberList.add(alphabetic[series1] + 666 + alphabetic[series2]
                                    + alphabetic[series3] + region);
                            if (carNumberList.size() == 2000000) {
                                break label;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Колличество номеров - " + carNumberList.size());

        while (true) {
            System.out.print("Введите регистрационный номер автомобиля (пример - B666DG25) - ");
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();

            // Прямой перебор по ArrayList
            directSortingSearch(number, carNumberList);

            // Бинарный поиск по ArrayList
            binarySearch(number, carNumberList);

            // Поиск в HashSet
            hashSetSearch(number, carNumberList);

            // Поиск в TreeSet
            treeSetSearch(number, carNumberList);
        }
    }

    private static void directSortingSearch (String number, ArrayList carNumberList) {
        start = System.nanoTime();
        search:
        {
            for (Object search : carNumberList) {
                if (search.equals(number)) {
                    System.out.print("Номер автомобиля - " + number + ", найден.");
                    break search;
                }
            }
            System.out.print("Номер автомобиля - " + number + ", не найден.");
        }
        duration = System.nanoTime() - start;
        System.out.println(" Время прямого перебора составило - " + duration + " нс");
    }

    private static void binarySearch (String number, ArrayList carNumberList) {
        Collections.sort(carNumberList);
        start = System.nanoTime();
        int index = Collections.binarySearch(carNumberList, number);
        if (index < 0) {
            System.out.print("Номер автомобиля - " + number + ", не найден.");
        } else {
            System.out.print("Номер автомобиля - " + carNumberList.get(index) + ", найден.");
        }
        duration = System.nanoTime() - start;
        System.out.println(" Время бинарного поиска составило - " + duration + " нс");
    }

    private static void hashSetSearch (String number, ArrayList carNumberList) {
        HashSet<String> carNumberListHashSet = new HashSet<>(carNumberList);
        start = System.nanoTime();
        if (carNumberListHashSet.contains(number)) {
            System.out.print("Номер автомобиля - " + number + ", найден.");
        } else {
            System.out.print("Номер автомобиля - " + number + ", не найден.");
        }
        duration = System.nanoTime() - start;
        System.out.println(" Время поиска в HashSet составило - " + duration + " нс");
    }

    private static void treeSetSearch (String number, ArrayList carNumberList) {
        HashSet<String> carNumberListTreeSet = new HashSet<>(carNumberList);
        start = System.nanoTime();
        if (carNumberListTreeSet.contains(number)) {
            System.out.print("Номер автомобиля - " + number + ", найден.");
        } else {
            System.out.print("Номер автомобиля - " + number + ", не найден.");
        }
        duration = System.nanoTime() - start;
        System.out.println(" Время поиска в TreeMap составило - " + duration + " нс");
    }
}