public interface Employee extends Comparable<Employee>{

    int getMonthSalary();

    default void setCompany(Company company){

    }

    default int compareTo(Employee o) {
        return getMonthSalary() - o.getMonthSalary();
    }
}