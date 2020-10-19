public class Loader
{
    public static void main(String[] args)
    {
        Cat vasya = new Cat();
        Cat masha = new Cat();
        Cat barsik = new Cat();

        // Проверка - меняем максимальный вес Васи
        while (vasya.getWeight() < 10000.0) {
            vasya.feed(300.0);
            System.out.println("Вес Васи = " + vasya.getWeight());
            System.out.println("Вася " + vasya.getStatus());
            if (vasya.deadCat() == true) break;
        }

        // Выводим состояние кошки - жива/мертва
        if (vasya.deadCat() == false) {
            System.out.println("Вася жив!");
        } else {
            System.out.println("Вася мёртв!");
        }

        // Проверяем кол-во кошек
        if (vasya.getStatus() == "Exploded" || vasya.getStatus() == "Dead") {
            Cat.count = Cat.count - 1;
        }
        System.out.println("Количество кошек = " + Cat.count);
    }
}