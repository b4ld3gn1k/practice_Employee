public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        Manager manager = new Manager();

        company.addEmployee(180, 100, 10);

        System.out.println(company);
    }
}
