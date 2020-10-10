public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();

        murka.getWeight();

        // Замяукиваем кошку

        while (murka.getWeight() > 999) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println(murka.getStatus());
            murka.meow();
        }
    }
}