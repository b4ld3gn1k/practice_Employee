public class Manager implements Employee {

    private static final double FIXED_PERCENT_FROM_MANAGER = 0.05;
    private final int FIXED_SALARY = (int) (Math.random() * 40_000) + 40_000;

    private int inCome = 0;

    public Manager() {
        inCome = (int) (Math.random() * ((140_000 - 115_000) + 1)) + 115_000;
    }

    @Override
    public int getMonthSalary() {
        return (int) (FIXED_SALARY + (inCome * FIXED_PERCENT_FROM_MANAGER));
    }

    public int getInCome() {
        return inCome;
    }

}