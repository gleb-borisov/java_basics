import java.text.DecimalFormat;

public class Main {

    private static final int patientsVolume = 30;
    private static final float minNormalTemperature = 36.2f;
    private static final float maxNormalTemperature = 36.9f;
    private static DecimalFormat decimalFormat = new DecimalFormat("#.#");
    private static float sumTemperatures = 0f;
    private static int healthPatients = 0;

    public static void main(String[] args) {
        System.out.print("Температуры пациентов - ");
        averageTemperature(patientsVolume);
        System.out.println();
        System.out.println("Средняя температура - " + decimalFormat.format(sumTemperatures/patientsVolume));
        System.out.println("Количество здоровых пациентов - " + healthPatients);
    }

    private static void averageTemperature (int patientsVolume) {
        Float[] patientsTemperature = new Float[patientsVolume];
        for (int i = 0; i < patientsVolume; i++) {
            Patient patient = new Patient();
            patientsTemperature[i] = patient.getTemperature();
            System.out.print(decimalFormat.format(patientsTemperature[i]) + " C; ");
            sumTemperatures = sumTemperatures + patientsTemperature[i];
            if (patientsTemperature[i] >= minNormalTemperature && patientsTemperature[i] <= maxNormalTemperature) {
                healthPatients++;
            }
        }
    }
}
