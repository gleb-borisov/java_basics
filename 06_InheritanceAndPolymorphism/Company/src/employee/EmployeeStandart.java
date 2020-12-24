package employee;

abstract class EmployeeStandard implements Employee {

    private int salary;

    @Override
    public int getMonthSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
