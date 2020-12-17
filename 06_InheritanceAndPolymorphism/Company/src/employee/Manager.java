package employee;

public class Manager extends EmployeeStandard {

    private final int SALARY_OF_MANAGER = 30000;
    private int incomeManagerForCompany;

    public int getSALARY_OF_MANAGER() {
        return SALARY_OF_MANAGER;
    }

    public int getIncomeManagerForCompany() {
        return incomeManagerForCompany;
    }

    public void setIncomeManagerForCompany(int incomeManagerForCompany) {
        this.incomeManagerForCompany = incomeManagerForCompany;
    }
}
