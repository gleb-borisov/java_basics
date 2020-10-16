public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();

        murka.getWeight();
        murka.sumCatFood();
        murka.catFood();


        // использование метода возврата сьеденной еды
        while (murka.catFood() <= 150.0) {
            System.out.println("Вес Мурки = " + murka.getWeight() + " грамм");
            System.out.println("Кол-во съеденной еды = " + murka.catFood() + " грамм");
            murka.feed(1.0);
            murka.sumCatFood();
        }

        // Использование метода pee()
        murka.pee();
        System.out.println("Мурка сходила на горшок емкостью в 150 мл");
        System.out.println("Вес Мурки после опорожнения = " + murka.getWeight() + " грамм");
    }
}