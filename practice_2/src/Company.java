import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void hire(Employee employee) {
        employee.setCompany(this);
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        for (Employee e : employees){
            hire(e);
        }
    }

    public void fire(Employee employee) {
        employee.setCompany(null);
        employees.remove(employee);
    }

    public int getIncome() {
        int inCome = 0;
        for (Employee employee : employees){
            if (employee instanceof Manager){
                inCome += ((Manager) employee).getInCome();
            }
        }

        return inCome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        System.out.println("\nСамая высока зарплата у " + count + " сотрудников.");
        return getList(count, Comparator.reverseOrder());
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        System.out.println("\nСамая низкая зарплата у " + count + " сотрудников.");
        return getList(count, Comparator.naturalOrder());
    }

    private List<Employee> getList (int count, Comparator<Employee> comparator){
        if (count < 0){
            System.out.println("Введено не коректное значение!");
            return Collections.emptyList();
        }
        if (count > employees.size()){
            count = employees.size();
        }

        employees.sort(comparator);
        return employees.subList(0, count);
    }

    private int getOperator(){
        int countOperator = 0;

        for (Employee employee : employees){
            if (employee instanceof Operator){
                countOperator++;
            }
        }
        return countOperator;
    } // кол-во операторов

    private int getManager(){
        int countManager = 0;

        for (Employee employee : employees){
            if (employee instanceof Manager){
                countManager++;

            }
        }
        return countManager;
    } // кол-во менеджеров

    private int getTopManager(){
        int countTopManager = 0;

        for (Employee employee : employees){
            if (employee instanceof TopManager){
                countTopManager++;
            }
        }
        return countTopManager;
    } // кол-во топ-менеджеров

    @Override
    public String toString() {
        return  "\nВ комании работают: " + employees.size() + " человек." +
                "\n================================" +
                "\nОператоры: " + getOperator() + " чел." +
                "\nМенеджеры: " + getManager() + " чел." +
                "\nТоп-Менеджеры: " + getTopManager() + " чел." +
                "\n================================" +
                "\nПрибыль копании составила: " + getIncome() + " руб.";
    }

}