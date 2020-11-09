public class Main {
    public static void main(String[] args) {

        char[] alphabetLat = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] alphabetRus = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я','А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};

        System.out.println("Латинский шрифт - кодировка:");
        for (int i = 0; i < alphabetLat.length; i++) {
            System.out.println(alphabetLat[i] + " - " + (int)alphabetLat[i]);
        }
        System.out.println();

        System.out.println("Кириллица - кодировка:");
        for (int i = 0; i < alphabetRus.length; i++) {
            System.out.println(alphabetRus[i] + " - " + (int)alphabetRus[i]);
        }
    }
}
