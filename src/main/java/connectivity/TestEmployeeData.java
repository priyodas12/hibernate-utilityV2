package connectivity;

import entity.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestEmployeeData {
    public static List<Employee> getTestEmployee() {

        List<Employee> listOfEmp=new ArrayList<>();

        Employee e1 = new Employee();

        e1.setDoj(new Date());
        e1.setEmpName("Priyobrato.Das");
        e1.setSalary(55000.90);

        Employee e2 = new Employee();

        e2.setDoj(new Date());
        e2.setEmpName("Debabrato.Das");
        e2.setSalary(90000.90);

        listOfEmp.add(e1);
        listOfEmp.add(e2);

        return listOfEmp;
    }
}
