public class Patient {

    private static final float minTemperature = 32.0f;
    private static final float maxTemperature = 40.0f;
    private static float temperature;

    public Patient() {
        temperature = minTemperature + (maxTemperature - minTemperature) * (float)Math.random();
    }
    public static float getTemperature() {
        return temperature;
    }
}
