public class TopManager implements Employee {

    private static final int DEFAULT_COMPANY_INCOME = 10_000_000;
    static final double FIXED_PERCENT_FROM_TOP_MANAGER = 1.5;

    @Override
    public int getMonthSalary() {
        if (Company.companyInCome > DEFAULT_COMPANY_INCOME) {
            return (int) (FIXED_SALARY + (FIXED_SALARY * FIXED_PERCENT_FROM_TOP_MANAGER));
        }
        return FIXED_SALARY;
    }
}
