package entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Integer empId;

    @Column(name = "EMPLOYEE_NAME",length = 100,nullable = false)
    private String empName;

    @Column(name = "EMPLOYEE_DOJ")
    private Date doj;

    @Column(name = "EMPLOYEE_SALARY")
    private Double salary;

    public Employee() {

    }

    public Employee(Integer empId, String empName, Date doj, Double salary) {
        this.empId = empId;
        this.empName = empName;
        this.doj = doj;
        this.salary = salary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
