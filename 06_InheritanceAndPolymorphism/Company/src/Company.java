import employee.Employee;
import employee.Manager;
import employee.Operator;
import employee.TopManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Company implements Comparator<Employee> {

    private int companyIncome = 0;
    boolean trigger;
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Employee> managersList = new ArrayList<>();
    ArrayList<Employee> topManagerList = new ArrayList<>();
    ArrayList<Employee> operatorList = new ArrayList<>();

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        if (count > employees.size()) {
            count = employees.size();
        }
        trigger = true;
        Collections.sort(employees, this::compare);
        for (int i = 0; i < count; i++) {
            System.out.println(employees.get(i).getMonthSalary() + " руб.");
        }
        return null;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        if (count > employees.size()) {
            count = employees.size();
        }
        trigger = false;
        Collections.sort(employees, this::compare);
        for (int i = 0; i < count; i++) {
            System.out.println(employees.get(i).getMonthSalary() + " руб.");
        }
        return null;
    }

    public void hireAll () {
        for (int i = 0; i < 180; i++) {
            Manager manager = new Manager();
            manager.setIncomeManagerForCompany(115000 + (int)((140000 - 115000) * Math.random()));
            manager.setSalary(manager.getSALARY_OF_MANAGER() + (int)(manager.getIncomeManagerForCompany() * 0.05));
            managersList.add(manager);
        }
        getCompanyIncome();
        for (int i = 0; i < 10; i++) {
            TopManager topManager = new TopManager();
            if (companyIncome > 10000000) {
                topManager.setSalary(topManager.getSALARY_OF_TOP_MANAGER() + (int) (topManager.getSALARY_OF_TOP_MANAGER() * 1.5));
            } else {
                topManager.setSalary(topManager.getSALARY_OF_TOP_MANAGER());
            }
            topManagerList.add(topManager);
        }
        for (int i = 0; i < 80; i++) {
            Operator operator = new Operator();
            operator.setSalary(operator.getSALARY_OF_OPERATOR());
            operatorList.add(operator);
        }
    }

    public void hire(String rang) {
        if (rang.equals("manager")) {
            Manager manager = new Manager();
            manager.setIncomeManagerForCompany(115000 + (int)((140000 - 115000) * Math.random()));
            manager.setSalary(manager.getSALARY_OF_MANAGER() + (int) (manager.getIncomeManagerForCompany() * 0.05));
            managersList.add(manager);
        }
        if (rang.equals("topmanager")) {
            TopManager topManager = new TopManager();
            if (companyIncome > 10000000) {
                topManager.setSalary(topManager.getSALARY_OF_TOP_MANAGER() + (int) (topManager.getSALARY_OF_TOP_MANAGER() * 1.5));
            } else {
                topManager.setSalary(topManager.getSALARY_OF_TOP_MANAGER());
            }
            topManagerList.add(topManager);
        }
        if (rang.equals("operator")) {
            Operator operator = new Operator();
            operator.setSalary(operator.getSALARY_OF_OPERATOR());
            operatorList.add(operator);
        }
    }

    public void fire (int index) {
        employees.remove(index);
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

    @Override
    public int compare(Employee o1, Employee o2) {
        if (trigger) {
            return compareTopSalaryStaff(o1, o2);
        } else {
            return compareLowestSalaryStaff(o1, o2);
        }
    }

    public int compareTopSalaryStaff (Employee o1, Employee o2) {
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
            return -1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return 1;
        }
        return 0;
    }

    public int compareLowestSalaryStaff (Employee o1, Employee o2) {
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return -1;
        }
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
            return 1;
        }
        return 0;
    }
}