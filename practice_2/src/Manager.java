public class Manager implements Employee{

    static final double FIXED_PERCENT_FROM_MANAGER = 0.05;
    static int monthProfit = (int) (Math.random() * ((140_000 - 115_000) + 1)) + 115_000;

    private int inCome = 0;

    public Manager() {
        inCome = (int) (Math.random() * ((140_000 - 115_000) + 1)) + 115_000;
    }

    @Override
    public int getMonthSalary() {
        int fivePercentFromMonthProfit = (int) (monthProfit * FIXED_PERCENT_FROM_MANAGER);
        return FIXED_SALARY + fivePercentFromMonthProfit;
    }

    @Override
    public int getMonthSalary(int companyInCome) {
        return getMonthSalary();
    }


    public int getInCome() {
        return inCome;
    }

}
