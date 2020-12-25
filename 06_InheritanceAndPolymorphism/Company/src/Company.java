import employee.Employee;
import employee.Manager;

import java.util.Collections;
import java.util.ArrayList;

public class Company {

    private int companyIncome = 0;
    private String rang;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Employee> managersList = new ArrayList<>();
    private ArrayList<Employee> topManagerList = new ArrayList<>();
    private ArrayList<Employee> operatorList = new ArrayList<>();
    private ArrayList<Integer> salary = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void makingSalaryList () {
        for (int i = 0; i < employees.size(); i++) {
            salary.add(employees.get(i).getMonthSalary());
        }
    }

    public ArrayList<Integer> getTopSalaryStaff(int count) {
        salary.clear();
        makingSalaryList();
        if (count > salary.size()) {
            count = salary.size();
        }
        Collections.sort(salary, Collections.reverseOrder());
        for (int i = 0; i < count; i++) {
            System.out.println(salary.get(i) + " руб.");
        }
        return null;
    }

    public ArrayList<Integer> getLowestSalaryStaff(int count) {
        salary.clear();
        makingSalaryList();
        if (count > salary.size()) {
            count = salary.size();
        }
        Collections.sort(salary);
        for (int i = 0; i < count; i++) {
            System.out.println(salary.get(i) + " руб.");
        }
        return null;
    }

    public void hireAll () {
        rang = "manager";
        for (int i = 0; i < 180; i++) {
            managersList.add(hire(rang, companyIncome));
        }
        getCompanyIncome();
        rang = "topmanager";
        for (int i = 0; i < 10; i++) {
            topManagerList.add(hire(rang, companyIncome));
        }
        rang = "operator";
        for (int i = 0; i < 80; i++) {
            operatorList.add(hire(rang, companyIncome));
        }
    }

    public Employee hire(String rang, int companyIncome) {
        if (rang.equals("manager")) {
            Recruiting recruiting = new Recruiting();
            return recruiting.recruitingManager();
        }
        if (rang.equals("topmanager")) {
            Recruiting recruiting = new Recruiting();
            return recruiting.recruitingTopManager(companyIncome);
        }
        if (rang.equals("operator")) {
            Recruiting recruiting = new Recruiting();
            return recruiting.recruitingOperator();
        }
        return null;
    }

    public void fire (Employee person) {
        employees.remove(person);
    }

    public void getEmployeesList() {
        employees.addAll(managersList);
        employees.addAll(topManagerList);
        employees.addAll(operatorList);
    }

    public int getCompanyIncome() {
        for (Object person :  managersList) {
            companyIncome += ((Manager) person).getIncomeManagerForCompany();
        }
        return companyIncome;
    }
}