import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeProcessor {
    public static void main(String[] args) {

        String[] employeeNames = {
            "Alice", "Bob", "Charlie", "Alice", "David",
            "Bob", "Eve", "Charlie", "Alice", "Frank", "Grace", "Bob"
        };

        List<String> employeeList = new ArrayList<>();

        for (String name : employeeNames) {
            employeeList.add(name);
        }
        System.out.println("Total Entries: " + employeeList.size());

        System.out.println("All Entries:");
        for (String name : employeeList) {
            System.out.println(name);
        }
        Set<String> uniqueEmployees = new HashSet<>(employeeList);

        System.out.println("\nUnique Employees: " + uniqueEmployees.size());

        System.out.println("Unique Names:");
        for (String name : uniqueEmployees) {
            System.out.println(name);
        }
    }
}

