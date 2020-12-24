public class Main {
    public static void main(String[] args) {

        Company newCompany = new Company();
        newCompany.hireAll();
        System.out.println("Создана новая компания.");

        newCompany.getEmployeesList();
        System.out.println("Кол-во сотрудников в компании - " + newCompany.employees.size() + " человек.");
        System.out.println("Компания заработала за месяц - " + newCompany.getCompanyIncome() + " руб.");

        System.out.println("Список самых высоких зарплат компании:");
        newCompany.getTopSalaryStaff(15);
        System.out.println("Список самых низких зарплат компании:");
        newCompany.getLowestSalaryStaff(30);

        System.out.println("Увольняем 50 процентов персонала:");
        for (int i = 0; i < 135; i++) {            ;
            newCompany.fire(newCompany.employees.get(i));
        }
        System.out.println("В компании осталось - " + newCompany.employees.size() + " человек.");

        System.out.println("Список самых высоких зарплат компании:");
        newCompany.getTopSalaryStaff(15);
        System.out.println("Список самых низких зарплат компании:");
        newCompany.getLowestSalaryStaff(30);
    }
}
