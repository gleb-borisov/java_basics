public class Loader
{
    public static void main(String[] args)
    {
        Cat vasya = new Cat();
        Cat masha = new Cat();
        Cat barsik = new Cat();

        // Проверка - взрываем Васю
        while (vasya.getWeight() < 9000) {
            vasya.feed(100.0);
        }

        System.out.println("Вася " + vasya.getStatus());



        if (vasya.getStatus() == "Exploded" || vasya.getStatus() == "Dead") {
            Cat.count = Cat.count - 1;
        }
        System.out.println("Количество кошек = " + Cat.count);
    }
}