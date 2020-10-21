
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private String catName; // Создал текстовую переменную для имени кошки
    private String catColor; // Создал текстовую переменную для цвета кошки

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    public Cat (Double weight, String catName, String catColor) { // Конструктор для задания параметров - имя и цвет кошки
        this.weight = weight;
        this.catName = catName;
        this.catColor = catColor;
    }

    public Cat (Cat copy) { // Конструктор для создании копии кошки
        this.weight = copy.getWeight();
        this.catName = copy.getCatName();
        this.catColor = copy.getCatColor();
    }

     public void setCatName(String catName) { // Создал сеттер для имени кошки
        this.catName = catName;
    }

    public String getCatName() { // Создал геттер для имени кошки
        return catName;
    }

    public void setCatColor(String catColor) { // Создал сеттер для цвета кошки
        this.catColor = catColor;
    }

    public String getCatColor() { // Создал геттер для цвета кошки
        return catColor;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public void setWeight(Double weight) { // Создал сеттер для веса кошки
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}