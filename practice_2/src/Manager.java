public class Manager implements Employee{

    static final double FIXED_PERCENT_FROM_MANAGER = 0.05;
    int monthProfit = (int) (Math.random() * ((140_000 - 115_000) + 1)) + 115_000;

    @Override
    public int getMonthSalary() {
        int fivePercentFromMonthProfit = (int) (monthProfit * FIXED_PERCENT_FROM_MANAGER);
        return FIXED_SALARY + fivePercentFromMonthProfit;
    }

    /*
    * Получение прибыли путем прибавления заработаных денег для компании
    * */
    public int companyInCome(int countManagers){
        int inCome = 0;

        for (int i = 0; i < countManagers; i++) {
            inCome += monthProfit;
        }

        return inCome;
    }
}
