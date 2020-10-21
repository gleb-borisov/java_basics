
public class Cat<catDead>
{
    private double originWeight;
    private double weight;

    public static final double MIN_WEIGHT = 1000; // Константа минимального веса
    public static final double MAX_WEIGHT = 9000; // Константа максимального веса
    public static final int CATS_EYES_COUNT = 2; // Константа кол-ва глаз у кошки

    static int count; // Создал статическую переменную count

    private boolean deadCat = false; // Задаем двоичную переменную для определения - жива ли кошка

    private double kitten; // Задал дробную переменную для перегрузки

    private String catColor; // Создал переменную для окраса кошки

    public void setCatColor(String catColor) { // Создал сеттер для окраса
        this.catColor = catColor;
    }

    public String getCatColor() { // Создал геттер для окраса
        return catColor;
    }

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++; // Добавил счетчик обьектов
    }

    // Создал перегрузку
    public Cat (double kitten)
    {
        this.kitten = kitten;
    }

    // Создал метод по возвращению веса котёнка
    public double getKittenWeight () {
        return kitten;
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