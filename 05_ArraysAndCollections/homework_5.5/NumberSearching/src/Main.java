import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

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
        start = System.nanoTime();
        int binarySearch = Integer.parseInt(number.substring(6)) * (int) Math.pow(26, 3)
                + Arrays.asList(alphabetic).indexOf(number.substring(0, 1)) * (int) Math.pow(26, 2)
                + Arrays.asList(alphabetic).indexOf(number.substring(4, 5)) * 26
                + Arrays.asList(alphabetic).indexOf(number.substring(5, 6));
        int regionNumber = Integer.parseInt(number.substring(6));
        int regionListNumber = 100;

        if (binarySearch > 2000000) {
            System.out.print("Номер автомобиля - " + number + ", не найден.");
        } else {
            binarySearch = 0;

            while (true) {
                if (binarySearch > 2000000) {
                    System.out.print("Номер автомобиля - " + number + ", не найден.");
                    break;
                }
                if (regionNumber == regionListNumber) {
                    binarySearch = regionListNumber * (int) Math.pow(26, 3);
                    break;
                }
                if (regionNumber < regionListNumber) {
                    regionListNumber = regionListNumber / 2;
                } else {
                    regionListNumber = regionListNumber + regionListNumber / 2;
                }
            }

            int letterOneToDigit = 13;
            int letterOneOfNumberToDigit = Arrays.asList(alphabetic).indexOf(number.substring(0, 1));

            while (true) {
                if (letterOneOfNumberToDigit == letterOneToDigit) {
                    binarySearch = binarySearch + letterOneToDigit * (int) Math.pow(26, 2);
                    break;
                }
                if (letterOneOfNumberToDigit < letterOneToDigit) {
                    letterOneToDigit = Math.round(letterOneToDigit / 2);
                } else {
                    letterOneToDigit = letterOneToDigit + Math.round(letterOneToDigit / 2);
                }
            }

            letterOneToDigit = 13;
            letterOneOfNumberToDigit = Arrays.asList(alphabetic).indexOf(number.substring(4, 5));

            while (true) {
                if (letterOneOfNumberToDigit == letterOneToDigit) {
                    binarySearch = binarySearch + letterOneToDigit * 26;
                    break;
                }
                if (letterOneOfNumberToDigit < letterOneToDigit) {
                    letterOneToDigit = Math.round(letterOneToDigit / 2);
                } else {
                    letterOneToDigit = letterOneToDigit + Math.round(letterOneToDigit / 2);
                }
            }

            letterOneToDigit = 13;
            letterOneOfNumberToDigit = Arrays.asList(alphabetic).indexOf(number.substring(5, 6));

            while (true) {
                if (letterOneOfNumberToDigit == letterOneToDigit) {
                    binarySearch = binarySearch + letterOneToDigit;
                    break;
                }
                if (letterOneOfNumberToDigit < letterOneToDigit) {
                    letterOneToDigit = Math.round(letterOneToDigit / 2);
                } else {
                    letterOneToDigit = letterOneToDigit + Math.round(letterOneToDigit / 2);
                }
            }
            System.out.print("Номер автомобиля - " + carNumberList.get(binarySearch) + ", найден.");
        }
        duration = System.nanoTime() - start;
        System.out.println(" Время бинарного поиска составило - " + duration + " нс");
    }

    private static void hashSetSearch (String number, ArrayList carNumberList) {
        start = System.nanoTime();
        HashSet<String> carNumberListHashSet = new HashSet<>(carNumberList);
        if (carNumberListHashSet.contains(number)) {
            System.out.print("Номер автомобиля - " + number + ", найден.");
        } else {
            System.out.print("Номер автомобиля - " + number + ", не найден.");
        }
        duration = System.nanoTime() - start;
        System.out.println(" Время поиска в HashSet составило - " + duration + " нс");
    }

    private static void treeSetSearch (String number, ArrayList carNumberList) {
        start = System.nanoTime();
        HashSet<String> carNumberListTreeSet = new HashSet<>(carNumberList);
        if (carNumberListTreeSet.contains(number)) {
            System.out.print("Номер автомобиля - " + number + ", найден.");
        } else {
            System.out.print("Номер автомобиля - " + number + ", не найден.");
        }
        duration = System.nanoTime() - start;
        System.out.println(" Время поиска в TreeMap составило - " + duration + " нс");
    }
}