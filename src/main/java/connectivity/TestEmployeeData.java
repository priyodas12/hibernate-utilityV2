package connectivity;

import entity.Employee;

import java.util.Date;

public class TestEmployeeData {
    public static Employee getTestEmployee() {
        Employee e = new Employee();

        e.setDoj(new Date());
        e.setEmpName("Priyobrato.Das");
        e.setSalary(55000.90);

        return e;
    }
}
