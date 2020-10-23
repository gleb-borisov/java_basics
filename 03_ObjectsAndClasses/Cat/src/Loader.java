
public class Loader
{
    public static void main(String[] args)
    {
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

    }
}