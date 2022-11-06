package lan.pojo;

import java.math.BigDecimal;

public class Emp {
    private String empId;

    private String empName;

    private String post;

    private String phoneNumber;

    private BigDecimal salary;

    private String deptId;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public Emp(String empId, String empName, String post, String phoneNumber, BigDecimal salary, String deptId) {
        this.empId = empId;
        this.empName = empName;
        this.post = post;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", post='" + post + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", deptId='" + deptId + '\'' +
                ", dept=" + dept +
                '}';
    }
}