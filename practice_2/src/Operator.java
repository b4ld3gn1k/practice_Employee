public class Operator implements Employee{
    private final int FIXED_SALARY = (int) (Math.random() * 30_000) + 30_000;

    @Override
    public int getMonthSalary() {
        return FIXED_SALARY;
    }
}
