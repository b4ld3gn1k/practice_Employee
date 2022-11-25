public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        TopManager topManager = new TopManager();

        company.addEmployee(180, 80, 10);

        System.out.println(company);
        System.out.println(topManager);
    }
}
