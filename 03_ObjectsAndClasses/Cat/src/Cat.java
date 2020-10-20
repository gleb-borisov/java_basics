
public class Cat<catDead>
{
    private double originWeight;
    private double weight;

    private static final double MIN_WEIGHT = 1000; // Константа минимального веса
    private static final double MAX_WEIGHT = 9000; // Константа максимального веса
    public static final int CATS_EYES_COUNT = 2; // Константа кол-ва глаз у кошки

    static int count; // Создал статическую переменную count

    private boolean deadCat = false; // Задаем двоичную переменную для определения - жива ли кошка

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++; // Добавил счетчик обьектов
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        if (deadCat() == true) return; // Запрет кушать для мёртвой кошки
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        if (deadCat() == true) return; // Запрет пить для мёртвой кошки
        weight = weight + amount;
    }

    // Возвратил метод pee с запретом
    public void pee()
    {
        if (deadCat() == true) return; // Запрет для мёртвой кошки ходить в туалет
        weight = weight - 150.0; // Ёмкость мочевого пузыря кошки = 150 грамм
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) { // Заменил переменную на константу
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) { // Заменил переменную на константу
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    // Статический метод getCount
    public static int getCount() {
        return count;
    }

    // Метод проверки жива ли кошка
    public boolean deadCat() {
        if (getWeight() <= MIN_WEIGHT || getWeight() >= MAX_WEIGHT) { // Заменил переменные на константы
            return deadCat = true;
        }
        else return deadCat = false;
    }
}