public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();

        murka.getWeight();

        // Перекармливаем кошку

        while (murka.getWeight() < 9001) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println(murka.getStatus());
            murka.feed(1.0);
        }
    }
}