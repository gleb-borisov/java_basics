import employee.Employee;
import employee.Manager;
import employee.Operator;
import employee.TopManager;

public class Recruiting {

    public Employee recruitingManager() {
        Manager manager = new Manager();
        manager.setIncomeManagerForCompany(115000 + (int)((140000 - 115000) * Math.random()));
        manager.setSalary(manager.getSalaryOfManager() + (int)(manager.getIncomeManagerForCompany() * 0.05));
        return manager;
    }

    public Employee recruitingTopManager(int companyIncome) {
        TopManager topManager = new TopManager();
        if (companyIncome > 10000000) {
            topManager.setSalary(topManager.getSalaryOfTopManager() + (int) (topManager.getSalaryOfTopManager() * 1.5));
        } else {
            topManager.setSalary(topManager.getSalaryOfTopManager());
        }
        return topManager;
    }

    public Employee recruitingOperator() {
        Operator operator = new Operator();
        operator.setSalary(operator.getSalaryOfOperator());
        return operator;
    }

}
