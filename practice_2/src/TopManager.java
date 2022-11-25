public class TopManager implements Employee{

    private int companyInCome = 0; // передача значения дохода компании для дальнейшего расчета за топов

    public TopManager (int companyInCome){
        this.companyInCome = companyInCome;
    }

    public TopManager(){

    }


    private static final int DEFAULT_COMPANY_INCOME = 10_000_000;
    static final double FIXED_PERCENT_FROM_TOP_MANAGER = 1.5;

    @Override
    public int getMonthSalary() {
        if (companyInCome > DEFAULT_COMPANY_INCOME){
            return (int) (FIXED_SALARY + (FIXED_SALARY * FIXED_PERCENT_FROM_TOP_MANAGER));
        }
        return FIXED_SALARY;
    }

    @Override
    public String toString() {
        return String.valueOf(getMonthSalary());
    }
}
