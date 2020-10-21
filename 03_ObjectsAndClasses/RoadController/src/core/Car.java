package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;
//======================================================================
    public void setNumber(String number) { // Создал сеттер для номера
        this.number = number;
    }

    public String getNumber() { // Создал геттер для номера
        return number;
    }
//=======================================================================
    public void setHeight(int height) { // Создал сеттер для высоты
        this.height = height;
    }

    public int getHeight() { // Создал геттер для высоты
        return height;
    }
//=======================================================================
    public void setWeight(double weight) { // Создал сеттер для веса
        this.weight = weight;
    }

    public double getWeight() { // Создал геттер для веса
        return weight;
    }
//=======================================================================
    public void setHasVehicle(boolean hasVehicle) { // Создал сеттер для автомобиля с прицепом
        this.hasVehicle = hasVehicle;
    }

    public boolean getHasVehicle() { // Создал геттер для автомобиля с прицепом
        return hasVehicle;
    }
//=======================================================================
    public void setIsSpecial(boolean isSpecial) { // Создал сеттер для спец транспорта
        this.isSpecial = isSpecial;
    }

    public boolean getIsSpecial() { // Создал геттер для спец транспорта
        return isSpecial;
    }
//=======================================================================
    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}