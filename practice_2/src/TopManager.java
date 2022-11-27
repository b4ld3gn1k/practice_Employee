public class TopManager implements Employee {

    private static final int DEFAULT_COMPANY_INCOME = 10_000_000;
    private static final double FIXED_PERCENT_FROM_TOP_MANAGER = 1.5;
    private final int FIXED_SALARY = (int) (Math.random() * 50_000) + 50_000;

    private Company company;

    public TopManager(Company company) {
        setCompany(company);
    }

    public TopManager(){

    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > DEFAULT_COMPANY_INCOME) {
            return (int) (FIXED_SALARY + (FIXED_SALARY * FIXED_PERCENT_FROM_TOP_MANAGER));
        }
        return FIXED_SALARY;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

}
