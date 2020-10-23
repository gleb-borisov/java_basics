
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double food; // Ввел переменную для учета сьеденной еды

    static int count; // Создал статическую переменную count

    private boolean deadCat = false; // Задаем двоичную переменную для определения - жива ли кошка

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        food = 0;
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

    public void setWeight(Double weight) { // Создал сеттер для веса
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

    // Метод возвращения сьеденной еды
    public void sumCatFood ()
    {
        food = weight - originWeight;
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
        if (getWeight() <= minWeight || getWeight() >= maxWeight) {
            return deadCat = true;
        }
        else return deadCat = false;
    }
}