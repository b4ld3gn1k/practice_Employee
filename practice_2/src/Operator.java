public class Operator implements Employee{

    @Override
    public int getMonthSalary() {
        return FIXED_SALARY;
    }

    @Override
    public int getMonthSalary(int companyInCome) {
        return getMonthSalary();
    }
}
