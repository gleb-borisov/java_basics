public class Main {

    private static String[] colors;

    public static void main(String[] args) {

        String text = "Каждый охотник желает знать, где сидит фазан";

        arrayTurning(text);

        for (String word : colors) {
            System.out.print(word + " ");
        }
    }

    private static void arrayTurning (String text) {
        colors = text.split(",?\\s+");
        StringBuilder textTurning = new StringBuilder();
        
        for (int i = colors.length - 1; i >= 0; i--) {
            textTurning.append(colors[i] + " ");
        }
        text = textTurning.toString();
        colors = text.split("\\s+");
    }
}
