import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> staff = new ArrayList<>();

    Manager manager = new Manager();
    TopManager topManager = new TopManager();
    Operator operator = new Operator();

    public void hire(Employee employee) {
        staff.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        staff.addAll(employees);
    }

    public void fire(Employee employee) {
        staff.remove(employee);
    }

// TODO: 26.11.2022 Сделать тогику работы двух методов ниже и доработаь методы увольнения

    public int getIncome() {
        int inCome = 0;
        for (Employee employee : staff){
            if (employee instanceof Manager){
                inCome += ((Manager) employee).getInCome();
            }
        }

        return inCome;
    }

    public ArrayList<String> getTopSalaryStaff() {
        return null;
    }

    public ArrayList<String> getLowestSalaryStaff() {
        return null;
    }



    public void addEmployee(int countOperator, int countManager, int countTopManager){
        for (int i = 0; i < countOperator; i++) {
            hire(operator);
        }

        for (int i = 0; i < countManager; i++) {
            hire(manager);
        }

        for (int i = 0; i < countTopManager; i++) {
            hire(topManager);
        }
    }

    private int getOperator(){
        int countOperator = 0;

        for (Employee employee : staff){
            if (employee instanceof Operator){
                countOperator++;
            }
        }
        return countOperator;
    } // кол-во операторов

    private int getManager(){
        int countManager = 0;

        for (Employee employee : staff){
            if (employee instanceof Manager){
                countManager++;

            }
        }
        return countManager;
    } // кол-во менеджеров

    private int getTopManager(){
        int countTopManager = 0;

        for (Employee employee : staff){
            if (employee instanceof TopManager){
                countTopManager++;
            }
        }
        return countTopManager;
    } // кол-во топ-менеджеров

    @Override
    public String toString() {
        return "В комании работают: " +
                staff.size() + " человек." +
                "\n================================" +
                "\nОператоры: " + getOperator() + " чел." +
                "\nМенеджеры: " + getManager() + " чел." +
                "\nТоп-Менеджеры: " + getTopManager() + " чел." +
                "\n================================" +
                "\nПрибыль копании составила: " + getIncome() + " руб." +
                "\nSalary manager = " + manager.getMonthSalary() +
                "\nSalary operator = " + operator.getMonthSalary() +
                "\nSalary topManager = " + topManager.getMonthSalary(getIncome());
    }
}
