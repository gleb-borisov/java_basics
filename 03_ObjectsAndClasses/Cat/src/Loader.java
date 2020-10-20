public class Loader
{

    // Создал метод обращения к классу без создания экземпляра класса с заданным параметром 1100 грамм
    private static Cat getKitten() {
        return new Cat(1100);
    }

    public static void main(String[] args) {

        int i = 1;

        // Создаем три обьекта класса Cat
        while (i <= 3) {
            Cat kitten = getKitten(); // Создаём обьект "котёнок" через метод private static Cat getKitten
            System.out.println("Вес котёнка = " + kitten.getKittenWeight());
            i = ++i;
        }

    }


}