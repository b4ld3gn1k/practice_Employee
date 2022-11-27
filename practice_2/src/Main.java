import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Company company = new Company();

    public static void addEmployee(int countOperator, int countManager, int countTopManager){
        for (int i = 0; i < countOperator; i++) {
            company.hire(new Operator());
        }

        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < countManager; i++) {
            workers.add(new Manager());
        }

        for (int i = 0; i < countTopManager; i++) {
            company.hire(new TopManager(company));
        }
        company.hireAll(workers);
    }

    public static void fireEmployee(int countFireEmployee){
        List<Employee> employee = company.getEmployees();
        for (int i = 0; i < countFireEmployee; i++) {
            company.fire(employee.get(i));
        }
        System.out.println("\nБыло уволено " + countFireEmployee + " сотрудников.");
    }

    public static void getTopAndLowSalary(int countTopSalary, int countLowSalary){
        List<Employee> getTopSalaryStaf = company.getTopSalaryStaff(countTopSalary);
        for (Employee employee : getTopSalaryStaf){
            System.out.println(employee.getMonthSalary() + " rub.");
        }

        List<Employee> getLowestSalaryStaff = company.getLowestSalaryStaff(countLowSalary);
        for (Employee employee : getLowestSalaryStaff){
            System.out.println(employee.getMonthSalary() + " rub.");
        }
    }

    public static void main(String[] args) {

        addEmployee(180, 80, 10);

        System.out.println(company);

        getTopAndLowSalary(12, 15);

        System.out.println(company);

        fireEmployee(135);

        System.out.println(company);

        getTopAndLowSalary(12, 15);
    }
}
