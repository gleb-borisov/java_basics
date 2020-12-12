public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        while (true) {
            menu.mainMenu();
            if (menu.getCommand().equals("1")) {
                while (true) {
                    menu.choiceAccount();
                    if (menu.getChoice().equals("0")) {
                        break;
                    }
                    while (true) {
                        menu.createNewPersonAccount(menu.getChoice());
                        menu.newAccountCreation();
                        if (menu.getCommand().equals("0")) {
                            break;
                        }
                    }
                }
            }
            if (menu.getCommand().equals("2")) {
                while (true) {
                    menu.choiceAccount();
                    if (menu.getChoice().equals("0")) {
                        break;
                    }
                    while (true) {
                        menu.depositAccount();
                        if (menu.getCommand().equals("0")) {
                            break;
                        }
                    }
                }
            }
            if (menu.getCommand().equals("3")) {
                while (true) {
                    menu.choiceAccount();
                    if (menu.getChoice().equals("0")) {
                        break;
                    }
                    while (true) {
                        menu.withdrawAccount();
                        if (menu.getCommand().equals("0")) {
                            break;
                        }
                    }
                }
            }
            if (menu.getCommand().equals("4")) {
                menu.printListAccounts();
            }
            if (menu.getCommand().equals("ДА")) {
                break;
            }
        }
        System.out.println("Спасибо что воспользовались нашей программой.");
    }
}
