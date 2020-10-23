
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
            if (murka.deadCat() == true) break;
        }

        // Замяукиваем кошку
        System.out.println();
        System.out.println("Замяукиваем Мурку");
        while (murka.getWeight() > 999) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println(murka.getStatus());
            murka.meow();
        }

        // Считаем кошек
        System.out.println();
        System.out.println("Считаем кошек");
        if (murka.getStatus() == "Exploded" || murka.getStatus() == "Dead") {
            Cat.count = Cat.count - 1;
        }
        System.out.println("Количество оставшихся кошек = " + Cat.count);

        // Использование метода возврата сьеденной еды
        System.out.println();
        System.out.println("Считаем сьеденную еду");
        while (murka.catFood() <= 150.0) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println("Кол-во съеденной еды = " + murka.catFood() + " грамм");
            murka.feed(1.0);
            murka.sumCatFood();
            if (murka.deadCat() == true) break;
        }

        // Использование метода pee()
        System.out.println();
        System.out.println("Мурка ходит на горшок");
        murka.pee();
        System.out.println("Мурка сходила на горшок емкостью в 150 мл");
        System.out.println("Вес Мурки после опорожнения = " + murka.getWeight() + " грамм");

        // Оживляем кошку
        murka.setWeight(3000.0);

        // Проверка - меняем максимальный вес кошки
        System.out.println();
        System.out.println("кормим кошку");
        while (murka.getWeight() < 10000.0) {
            murka.feed(300.0);
            System.out.println("Вес Мурки = " + murka.getWeight());
            System.out.println("Мурка " + murka.getStatus());
            if (murka.deadCat() == true) break;
        }

        // Выводим состояние кошки - жива/мертва:
        System.out.println();
        System.out.println("Состояние кошки - жива/мертва");
        if (murka.deadCat() == false) {
            System.out.println("Мурка жива!");
        } else {
            System.out.println("Мурка мёртва!");
        }
    }
}