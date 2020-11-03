
public class Loader
{
    // Создал метод обращения к классу без создания экземпляра класса с заданным параметром 1100 грамм
    private static Cat getKitten() {
        return new Cat(1100);
    }

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
        while (murka.deadCat() == false) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            murka.feed(1.0);
            System.out.println(murka.getStatus());
        }
        System.out.println("Кот(кошка) не может кушать.");

        // Замяукиваем кошку
        System.out.println();
        System.out.println("Замяукиваем Ваську");
        while (vaska.deadCat() == false) {
            System.out.println("Вес Васьки = " + vaska.getWeight() + " грамм");
            vaska.meow();
            System.out.println(vaska.getStatus());
        }

        // Считаем кошек
        System.out.println();
        System.out.println("Считаем кошек");

        murka.getCount();
        vaska.getCount();
        barsik.getCount();
        pirozhok.getCount();
        mashka.getCount();
        pinochet.getCount();
        lapa.getCount();

        System.out.println("Количество оставшихся кошек = " + Cat.count);

        // Использование метода возврата сьеденной еды
        System.out.println();
        System.out.println("Считаем сьеденную еду");
        while (murka.getFood() <= 150.0) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println("Кол-во съеденной еды = " + murka.getFood() + " грамм");
            murka.feed(1.0);
            if (murka.deadCat()) {
                break;
            }
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
            if (murka.deadCat()) {
                break;
            }
        }

        // Выводим состояние кошки - жива/мертва:
        System.out.println();
        System.out.println("Состояние кошки - жива/мертва");
        if (murka.deadCat()) {
            System.out.println("Мурка мертва!");
        } else {
            System.out.println("Мурка жива!");
        }

        // Создаем три обьекта класса Cat с заданным весом - 1100 грамм
        int i = 1;

        System.out.println();
        System.out.println("Создаём три котенка с заданным весом - 1100 грамм");

        while (i <= 3) {
            Cat kitten = getKitten(); // Создаём обьект "котёнок" через метод private static Cat getKitten
            System.out.println("Вес котёнка = " + kitten.getKittenWeight());
            i = ++i;
        }

        // Создаем две копии Мурки
        System.out.println();
        System.out.println("Создаём две копии Мурки");
        murka.setCatName("Мурка");
        murka.setCatColor("Черный");
        murka.setWeight(3000.0);

        System.out.println("Имя Мурки - " + murka.getCatName());
        System.out.println("Цвет Мурки - " + murka.getCatColor());
        System.out.println("Вес Мурки - " + murka.getWeight() + " грамм");
        System.out.println();

        System.out.println("Вася - копия Мурки");
        Cat vasya = new Cat(murka);
        System.out.println("Имя Васи - " + vasya.getCatName());
        System.out.println("Цвет Васи - " + vasya.getCatColor());
        System.out.println("Вес Васи - " + vasya.getWeight() + " грамм");
        System.out.println();

        System.out.println("Пушок - копия Мурки");
        Cat pushok = new Cat(murka);
        System.out.println("Имя Пушка - " + pushok.getCatName());
        System.out.println("Цвет Пушка - " + pushok.getCatColor());
        System.out.println("Вес Пушка - " + pushok.getWeight() + " грамм");
    }
}