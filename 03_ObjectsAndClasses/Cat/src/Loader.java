
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat(3000.0, "Мурка", "Черный");

        System.out.println("Имя Мурки - " + murka.getCatName());
        System.out.println("Цвет Мурки - " + murka.getCatColor());
        System.out.println("Вес Мурки - " + murka.getWeight() + " грамм");
        System.out.println();

        Cat vasya = new Cat(murka);

        System.out.println("Имя Васи - " + vasya.getCatName());
        System.out.println("Цвет Васи - " + vasya.getCatColor());
        System.out.println("Вес Васи - " + vasya.getWeight() + " грамм");
        System.out.println();

        Cat barsik = new Cat(murka);

        System.out.println("Имя Барсика - " + barsik.getCatName());
        System.out.println("Цвет Барсика - " + barsik.getCatColor());
        System.out.println("Вес Барсика - " + barsik.getWeight() + " грамм");
    }
}