public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();

        Cat murka = new Cat();
        Cat vaska = new Cat();

        // Кормим двух кошек

        murka.getWeight();
        System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");

        vaska.getWeight();
        System.out.println("Вес Васьки = " + vaska.getWeight() + " грамм");
    }
}