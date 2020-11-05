
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

    private boolean deadCat; // Задаем двоичную переменную для определения - жива ли кошка

    private double kittenWeight; // Задал дробную переменную для перегрузки

    private Color catColor; // Создал переменную для окраса кошки
    private String catName; // Создал текстовую переменную для имени кошки

    private boolean isAlive; // Переменная содержащая состояние кота (жив/мертв)

    public Boolean getIsAlive () { // Создал геттер возвращающий состояние кота (жив/мертв)
        return isAlive;
    }

    public void setCatColor(String catColor) { // Создал сеттер для окраса
        this.catColor = Color.BLACK;
    }

    public Color getCatColor() { // Создал геттер для окраса
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
        deadCat = false; // Ввел состояние кота в конструктор
        isAlive = true;
    }

    // Конструктор для задания параметров - веса имени и цвета кошки
    public Cat (Double weight, String catName, String catColor) {
        this();
        this.weight = weight;
        this.catName = catName;
        this.catColor = Color.BLACK;
    }

    // Конструктор для создании копии кошки
    public Cat (Cat copy) {
        this();
        this.weight = copy.getWeight();
        this.catName = copy.getCatName();
        this.catColor = copy.getCatColor();
    }


    // Создал перегрузку
    public Cat (double kittenWeight)    {
        this();
        this.kittenWeight = kittenWeight;
    }

    // Создал метод по возвращению веса котёнка
    public double getKittenWeight () {
        return kittenWeight;
    }


    public void meow()
    {
        isAlive = isWeightNormal();
        if (isAlive) {
            weight = weight - 1;
            System.out.println("Meow");
        } else {
            System.out.println("Кот(кошка) не может мяукать.");
            count--;
        }
    }

    public void feed(Double amount)
    {
        if (isAlive) {
            if (isWeightNormal()) {
                weight = weight + amount;
                food = food + amount; // Учет сьеденого
            } else {
                System.out.println("Кот(кошка) не может кушать.");
                isAlive = false;
                count--;
            }
        } else {
            return;
        }

    }

    public double getFood () { // Геттер для возвращения кол-ва сьеденного
        return food;
    }

    public void drink(Double amount)
    {
        if (deadCat()) { // Запрет пить для мёртвой кошки
            return;
        }
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

    // Метод pee()
    public void pee()
    {
        if (deadCat()) { // Запрет для мёртвой кошки ходить в туалет
            return;
        }
        weight = weight - 150.0; // Ёмкость мочевого пузыря кошки = 150 грамм
    }

    // Статический метод getCount
    public int getCount() {
        if (deadCat())
        count--;
        return count;
    }

    // Метод проверки жива ли кошка
    public boolean deadCat() {
        if (getWeight() <= MIN_WEIGHT || getWeight() >= MAX_WEIGHT) { // Заменил переменные на константы
            return deadCat = true;
        }
        else {
            return deadCat = false;
        }
    }

    // Дополнительный метод проверки состояния кота
    public boolean isWeightNormal() {
        return (weight> MIN_WEIGHT && weight <MAX_WEIGHT);
    }
}