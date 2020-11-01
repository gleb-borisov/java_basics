
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private static final double MIN_WEIGHT = 1000; // Константа минимального веса
    private static final double MAX_WEIGHT = 9000; // Константа максимального веса
    public static final int CATS_EYES_COUNT = 2; // Константа кол-ва глаз у кошки

    private double food; // Ввел переменную для учета сьеденной еды

    static int count; // Создал статическую переменную count

    private boolean deadCat = false; // Задаем двоичную переменную для определения - жива ли кошка

    private double kitten; // Задал дробную переменную для перегрузки

    private String catColor; // Создал переменную для окраса кошки
    private String catName; // Создал текстовую переменную для имени кошки

    Double oneFood = 0.0; // Добавил переменную по суммированию еды

    public void setCatColor(String catColor) { // Создал сеттер для окраса
        this.catColor = catColor;
    }

    public String getCatColor() { // Создал геттер для окраса
        return catColor;
    }

    public void setCatName(String catName) { // Создал сеттер для имени кошки
        this.catName = catName;
    }

    public String getCatName() { // Создал геттер для имени кошки
        return catName;
    }

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        food = 0;
        count++; // Добавил счетчик обьектов
    }

    // Конструктор для задания параметров - веса имени и цвета кошки
    public Cat (Double weight, String catName, String catColor) {
        this.weight = weight;
        this.catName = catName;
        this.catColor = catColor;
    }

    // Конструктор для создании копии кошки
    public Cat (Cat copy) {
        this.weight = copy.getWeight();
        this.catName = copy.getCatName();
        this.catColor = copy.getCatColor();
    }


    // Создал перегрузку
    public Cat (double kitten)    {
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
        oneFood = amount; // Присвоил переменной кол-во еды потребляемой кошкой за один раз
    }

    public void drink(Double amount)
    {
        if (deadCat() == true) return; // Запрет пить для мёртвой кошки
        weight = weight + amount;
    }

    public void setWeight(Double weight) { // Создал сеттер для веса
        this.weight = weight;
    }

    public Double getWeight() {
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

    // Метод возвращения сьеденной еды
    public void sumCatFood ()
    {
        food = food + oneFood; // Переделал метод для подсчета сьеденной еды
    }
    public Double catFood() {return food;}

    // Метод pee()
    public void pee()
    {
        if (deadCat() == true) return; // Запрет для мёртвой кошки ходить в туалет
        weight = weight - 150.0; // Ёмкость мочевого пузыря кошки = 150 грамм
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