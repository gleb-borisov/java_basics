
public class Loader
{
    public static void main(String[] args) {
        // Создаем семь кошек
        Cat murka = new Cat();
        Cat vaska = new Cat();
        Cat barsik = new Cat();
        Cat pirozhok = new Cat();
        Cat mashka = new Cat();
        Cat pinochet = new Cat();
        Cat lapa = new Cat();

        // Печатаем вес семи кошек
        System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
        System.out.println("Вес Васьки = " + vaska.getWeight() + " грамм");
        System.out.println("Вес Барсика = " + barsik.getWeight() + " грамм");
        System.out.println("Вес Пирожка = " + pirozhok.getWeight() + " грамм");
        System.out.println("Вес Машки = " + mashka.getWeight() + " грамм");
        System.out.println("Вес Пиночета = " + pinochet.getWeight() + " грамм");
        System.out.println("Вес Лапы = " + lapa.getWeight() + " грамм");

        // Кормим двух кошек
        murka.feed(1.0);
        vaska.feed(1.0);

        System.out.println();
        System.out.println("Новый вес Мурки = " + murka.getWeight() + " грамм");
        System.out.println("Новый вес Васьки = " + vaska.getWeight() + " грамм");

        // Перекармливаем кошку
        System.out.println();
        System.out.println("Кормим Мурку");
        while (murka.getWeight() < 9001) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println(murka.getStatus());
            murka.feed(1.0);
        }

        // Замяукиваем кошку
        System.out.println();
        System.out.println("Замяукиваем Мурку");
        while (murka.getWeight() > 999) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println(murka.getStatus());
            murka.meow();
        }
    }
}